package org.g220804.controller;

import org.g220804.pojo.User;
import org.g220804.service.UserService;
import org.g220804.util.ResponseJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController
{
    private final UserService userService;
    public UserController(UserService userService){this.userService = userService;}
    @PostMapping("/register")
    public ResponseJson register(User user)
    {
        return userService.register(user);
    }
    @PostMapping("/login")
    public ResponseJson login(String username, String password, HttpSession httpSession)
    {
        return userService.login(username, password, httpSession);
    }
    @PostMapping("/movie-list")
    public ResponseJson getMovieList()
    {
        return userService.getMovieList();
    }
    @PostMapping("/arrange-list")
    public ResponseJson getArrangeByMovieId(int movieId)
    {
        return userService.getArrangeByMovieId(movieId);
    }
    @PostMapping("/seat-info")
    public ResponseJson getSeatInfo(int arrangeId)
    {
        return userService.getSeatInfo(arrangeId);
    }
    @PostMapping("/pay")
    public ResponseJson pay(int orderId, HttpSession httpSession) throws Exception
    {
        return userService.pay(orderId, httpSession);
    }
    @PostMapping("/refund")
    public ResponseJson refund(int orderId)
    {
        return userService.refund(orderId);
    }
    @PostMapping("/create-order")
    public ResponseJson createOrder(int arrangeId, int[] seats1D, HttpSession httpSession)
    {
        int[][] seats = new int[seats1D.length >> 1][2];
        for(int i = 0; i < seats.length; i++)
        {
            seats[i][0] = seats1D[i << 1];
            seats[i][1] = seats1D[(i << 1) + 1];
        }
        return userService.createOrder(arrangeId, seats, httpSession);
    }
    @PostMapping("/delete-order")
    public ResponseJson deleteOrder(int orderId)
    {
        return userService.deleteOrder(orderId);
    }
    @PostMapping("/notify_url")
    public String notifyUrl(@RequestBody String body) throws Exception
    {
        userService.updateOrderForNotify(body);
        return """
                <xml>
                  <return_code><![CDATA[SUCCESS]]></return_code>
                  <return_msg><![CDATA]></return_msg>
                </xml>""";
    }
    @PostMapping("/my-order")
    public ResponseJson getOrderList(HttpSession httpSession)
    {
        return userService.getOrderList(httpSession);
    }
    @PostMapping("/pay-info")
    public ResponseJson getPayInfo(int payId)
    {
        return userService.getPayInfo(payId);
    }
}
