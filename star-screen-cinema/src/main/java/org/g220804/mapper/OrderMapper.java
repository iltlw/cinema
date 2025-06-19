package org.g220804.mapper;

import org.g220804.pojo.Order;
import org.apache.ibatis.annotations.*;
import org.g220804.pojo.OrderView;

import java.util.List;

@Mapper
public interface OrderMapper
{
    @Select("select * from t_order where order_arrange_id=#{arrangeId} and order_state!=2")
    List<Order> getListByArrangeId(int arrangeId);
    @Insert("insert into t_order values(null,#{orderNum},#{orderUserId},#{orderArrangeId},#{orderSeatRow},#{orderSeatCol},#{orderTime},#{orderAmount},#{orderState},#{orderPayId})")
    int addOrder(Order order);
    @Delete("delete from t_order where order_id=#{orderId}")
    int deleteOrder(int orderId);
    @Select("select count(1) from t_order where order_arrange_id=#{arrangeId} and order_seat_row=#{orderSeatRow} and order_seat_col=#{orderSeatCol} and order_state!=2")
    Integer isLockedByArrangeIdAndSeat(@Param("arrangeId") int arrangeId, @Param("orderSeatRow") int orderSeatRow, @Param("orderSeatCol") int orderSeatCol);
    @Update("update t_order set order_state = 1, order_pay_id = #{payId} where order_id=#{orderId}")
    void payOrder(int orderId, int payId);
    @Update("update t_order set order_state = 2 where order_id=#{orderId}")
    void refundOrder(int orderId);
    @Select("select * from v_order where user_id=#{userId}")
    List<OrderView> getViewListByUserId(int userId);
}
