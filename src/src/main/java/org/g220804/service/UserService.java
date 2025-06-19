package org.g220804.service;

import com.alibaba.fastjson.JSON;
import org.g220804.http.AppInfo;
import org.g220804.mapper.*;
import org.g220804.pojo.*;
import org.g220804.util.ResponseJson;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService
{
    private final UserMapper userMapper;
    private final MovieMapper movieMapper;
    private final ArrangeMapper arrangeMapper;
    private final OrderMapper orderMapper;
    private final PayMapper payMapper;
    private final WXPay wxPay;
    public UserService(UserMapper userMapper, MovieMapper movieMapper, ArrangeMapper arrangeMapper, OrderMapper orderMapper, PayMapper payMapper, WXPay wxPay)
    {
        this.userMapper = userMapper;
        this.movieMapper = movieMapper;
        this.arrangeMapper = arrangeMapper;
        this.orderMapper = orderMapper;
        this.payMapper = payMapper;
        this.wxPay = wxPay;
    }
    public ResponseJson register(User user)
    {
        int i = userMapper.addUser(user);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
    public ResponseJson login(String username, String password, HttpSession httpSession)
    {
        User user = userMapper.getUserByUserName(username);
        if(user != null)
        {
            if(user.getUserPassword().equals(password))
            {
                httpSession.setAttribute(AppInfo.SESSION_USER, user);
                return ResponseJson.getOK();
            }
            else
            {
                return ResponseJson.getError("密码错误");
            }
        }
        return ResponseJson.getError("用户不存在");
    }
    public ResponseJson getMovieList()
    {
        LocalDateTime startTime = LocalDateTime.now();
        List<Integer> movieIds = arrangeMapper.getMovieIdsByStartTimeAfter(startTime);
        List<Movie> movieList = movieMapper.getMovieByIds(movieIds);
        return ResponseJson.getOK(movieList);
    }
    private User getPojoBySession(HttpSession httpSession)
    {
        return (User) httpSession.getAttribute(AppInfo.SESSION_USER);
    }
    public ResponseJson getArrangeByMovieId(int movieId)
    {
        LocalDateTime startTime = LocalDateTime.now();
        List<ArrangeView> arrangeViewList = arrangeMapper.getViewListByStartTimeAfterAndMovieId(startTime, movieId);
        return ResponseJson.getOK(arrangeViewList);
    }
    public ResponseJson getSeatInfo(int arrangeId)
    {
        ArrangeView arrangeView = arrangeMapper.getViewById(arrangeId);
        Integer[][] seatInfo = JSON.parseObject(arrangeView.getCinemaHallSeat(), Integer[][].class);
        List<Order> orderList = orderMapper.getListByArrangeId(arrangeView.getArrangeId());
        orderList.forEach(order ->
        {
            seatInfo[order.getOrderSeatRow()][order.getOrderSeatCol()] = 2;//锁定
        });
        return ResponseJson.getOK(seatInfo);
    }
    @Transactional(rollbackFor=Exception.class)
    public ResponseJson pay(int orderId, HttpSession httpSession)
    {
        // 模拟支付，实际在此处添加支付逻辑
        User user = getPojoBySession(httpSession);
        Pay pay = new Pay();
        String payNum = "" + System.currentTimeMillis() + user.getUserId();
        pay.setPayNum(payNum);
        pay.setPayTime(LocalDateTime.now());
        payMapper.add(pay);
        int payId = payMapper.getIdByNum(payNum);
        orderMapper.payOrder(orderId, payId);
        return ResponseJson.getOK();
        // 以下为原buy函数中的代码，可能包含支付逻辑，故保留。
//        Map<String, String> map = new HashMap<>();
//        map.put("body", "购票");
//        map.put("out_trade_no", pay.getPayNum());
//        map.put("total_fee", "1");
//        map.put("spbill_create_ip", "127.0.0.1");
//        map.put("notify_url", " https://pqmsxs.natappfree.cc/cinema/user/notify_url");
//        map.put("trade_type", "NATIVE");
//        Map<String, String> resultMap = wxPay.unifiedOrder(map);
//        String code_url = resultMap.get("code_url");
//        if(code_url != null)
//        {
//            resultMap = new HashMap<>();
//            resultMap.put("code_url", code_url);
//            resultMap.put("payId", String.valueOf(pay.getPayId()));
//            return ResponseJson.getOK(resultMap);
//        }
//        else
//        {
////                System.out.println("===>" + resultMap);
//            throw new RuntimeException("支付码生成失败");
//        }
//        return ResponseJson.getError("支付订单创建失败");
    }
    @Transactional(rollbackFor=Exception.class)
    public ResponseJson refund(int orderId)
    {
        // 模拟退款，实际在此处添加退款逻辑
        orderMapper.refundOrder(orderId);
        return ResponseJson.getOK();
    }
    @Transactional(rollbackFor=Exception.class)
    public ResponseJson createOrder(int arrangeId, int[][] seats, HttpSession httpSession)
    {
        try
        {
            User user = getPojoBySession(httpSession);
            Arrange arrange = arrangeMapper.getById(arrangeId);
            if(arrange == null)
            {
                return ResponseJson.getError();
            }
            Order[] orders = new Order[seats.length];
            for(int i = 0; i < seats.length; i++)
            {
                int[] seat = seats[i];
                Order order = new Order();
                String orderNum = "" + System.currentTimeMillis() + user.getUserId() + arrange.getArrangeId();
                order.setOrderNum(orderNum);
                order.setOrderUserId(user.getUserId());
                order.setOrderArrangeId(arrange.getArrangeId());
                order.setOrderSeatRow(seat[0]);
                order.setOrderSeatCol(seat[1]);
                order.setOrderTime(LocalDateTime.now());
                order.setOrderAmount(arrange.getArrangePrice());
                order.setOrderState(0);
                orders[i] = order;
            }
            List<Integer[]> failed, locked;
            failed = new ArrayList<>();
            locked = new ArrayList<>();
            for(Order order: orders)
            {
                Integer i = orderMapper.isLockedByArrangeIdAndSeat(arrange.getArrangeId(), order.getOrderSeatRow(), order.getOrderSeatCol());
                if(i == 0)
                {
                    synchronized(UserService.class)
                    {
                        i = orderMapper.addOrder(order);
                        if(i < 1)
                        {
                            failed.add(new Integer[]{order.getOrderSeatRow(), order.getOrderSeatCol()});
                        }
                        continue;
                    }
                }
                locked.add(new Integer[]{order.getOrderSeatRow(), order.getOrderSeatCol()});
            }
            StringBuilder msg = new StringBuilder();
            if(failed.isEmpty() && locked.isEmpty())
            {
                msg.append("下单成功！");
            }
            else
            {
                msg.append("座位");
                if(!failed.isEmpty())
                {
                    for(var i: failed)
                    {
                        msg.append(i[0]+1).append("排").append(i[1]+1).append("列、");
                    }
                    msg.deleteCharAt(msg.length()-1);
                    msg.append("下单失败，");
                }
                if(!locked.isEmpty())
                {
                    for(var i: locked)
                    {
                        msg.append(i[0]+1).append("排").append(i[1]+1).append("列、");
                    }
                    msg.deleteCharAt(msg.length()-1);
                    msg.append("已被锁定，");
                }
                msg.append("其他座位下单成功。");
            }
            return ResponseJson.getOK(msg);
        }
        catch(Exception e)
        {
            return ResponseJson.getError(e.getMessage());
        }
    }
    @Transactional(rollbackFor=Exception.class)
    public ResponseJson deleteOrder(int orderId)
    {
        int i = orderMapper.deleteOrder(orderId);
        return i > 0? ResponseJson.getOK() : ResponseJson.getError();
    }
    public void updateOrderForNotify(String body) throws Exception
    {
        Map<String, String> xmlToMap = WXPayUtil.xmlToMap(body);
        if(xmlToMap.get("return_code").equals("SUCCESS") && xmlToMap.get("result_code").equals("SUCCESS"))
        {
            String payNum = xmlToMap.get("out_trade_no");
//            payMapper.pay(payNum, body);
            int payId = payMapper.getIdByNum(payNum);
//            该方法含义已改变，请检查后再重新使用或使用其他方法
//            orderMapper.payOrder();
        }
    }
    public ResponseJson getOrderList(HttpSession httpSession)
    {
        User user = getPojoBySession(httpSession);
        List<OrderView> orderViewList = orderMapper.getViewListByUserId(user.getUserId());
        return ResponseJson.getOK(orderViewList);
    }
    public ResponseJson getPayInfo(int payId)
    {
        Pay pay = payMapper.getById(payId);
        System.out.println(pay.getPayId() + " " + pay.getPayNum() + " " + pay.getPayTime());
        return ResponseJson.getOK(pay);
    }
}
