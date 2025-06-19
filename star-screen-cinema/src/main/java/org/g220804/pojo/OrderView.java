package org.g220804.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class OrderView
{
    private int orderId;
    private int userId;
    private int arrangeId;
    private int cinemaId;
    private int cinemaHallId;
    private int movieId;
    private Integer payId;
    private String orderNum;
    private String cinemaName;
    private String cinemaHallName;
    private String movieName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime movieStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime movieEndTime;
    private int movieDuration;
    private String movieImgUrl;
    private int orderSeatRow;
    private int orderSeatCol;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderTime;
    private double orderAmount;
    private int orderState = 0;
    public OrderView()
    {
    }
    public OrderView(int orderId, int userId, int arrangeId, int cinemaId, int cinemaHallId, int movieId, Integer payId, String orderNum, String cinemaName, String cinemaHallName, String movieName, LocalDateTime movieStartTime, LocalDateTime movieEndTime, int movieDuration, String movieImgUrl, int orderSeatRow, int orderSeatCol, LocalDateTime orderTime, double orderAmount, int orderState)
    {
        this.orderId = orderId;
        this.userId = userId;
        this.arrangeId = arrangeId;
        this.cinemaId = cinemaId;
        this.cinemaHallId = cinemaHallId;
        this.movieId = movieId;
        this.payId = payId;
        this.orderNum = orderNum;
        this.cinemaName = cinemaName;
        this.cinemaHallName = cinemaHallName;
        this.movieName = movieName;
        this.movieStartTime = movieStartTime;
        this.movieEndTime = movieEndTime;
        this.movieDuration = movieDuration;
        this.movieImgUrl = movieImgUrl;
        this.orderSeatRow = orderSeatRow;
        this.orderSeatCol = orderSeatCol;
        this.orderTime = orderTime;
        this.orderAmount = orderAmount;
        this.orderState = orderState;
    }
    public int getOrderId()
    {
        return orderId;
    }
    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }
    public int getUserId()
    {
        return userId;
    }
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public int getArrangeId()
    {
        return arrangeId;
    }
    public void setArrangeId(int arrangeId)
    {
        this.arrangeId = arrangeId;
    }
    public int getCinemaId()
    {
        return cinemaId;
    }
    public void setCinemaId(int cinemaId)
    {
        this.cinemaId = cinemaId;
    }
    public int getCinemaHallId()
    {
        return cinemaHallId;
    }
    public void setCinemaHallId(int cinemaHallId)
    {
        this.cinemaHallId = cinemaHallId;
    }
    public int getMovieId()
    {
        return movieId;
    }
    public void setMovieId(int movieId)
    {
        this.movieId = movieId;
    }
    public Integer getPayId()
    {
        return payId;
    }
    public void setPayId(Integer payId)
    {
        this.payId = payId;
    }
    public String getOrderNum()
    {
        return orderNum;
    }
    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }
    public String getCinemaName()
    {
        return cinemaName;
    }
    public void setCinemaName(String cinemaName)
    {
        this.cinemaName = cinemaName;
    }
    public String getCinemaHallName()
    {
        return cinemaHallName;
    }
    public void setCinemaHallName(String cinemaHallName)
    {
        this.cinemaHallName = cinemaHallName;
    }
    public String getMovieName()
    {
        return movieName;
    }
    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }
    public LocalDateTime getMovieStartTime()
    {
        return movieStartTime;
    }
    public void setMovieStartTime(LocalDateTime movieStartTime)
    {
        this.movieStartTime = movieStartTime;
    }
    public LocalDateTime getMovieEndTime()
    {
        return movieEndTime;
    }
    public void setMovieEndTime(LocalDateTime movieEndTime)
    {
        this.movieEndTime = movieEndTime;
    }
    public int getMovieDuration()
    {
        return movieDuration;
    }
    public void setMovieDuration(int movieDuration)
    {
        this.movieDuration = movieDuration;
    }
    public String getMovieImgUrl()
    {
        return movieImgUrl;
    }
    public void setMovieImgUrl(String movieImgUrl)
    {
        this.movieImgUrl = movieImgUrl;
    }
    public int getOrderSeatRow()
    {
        return orderSeatRow;
    }
    public void setOrderSeatRow(int orderSeatRow)
    {
        this.orderSeatRow = orderSeatRow;
    }
    public int getOrderSeatCol()
    {
        return orderSeatCol;
    }
    public void setOrderSeatCol(int orderSeatCol)
    {
        this.orderSeatCol = orderSeatCol;
    }
    public LocalDateTime getOrderTime()
    {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime)
    {
        this.orderTime = orderTime;
    }
    public double getOrderAmount()
    {
        return orderAmount;
    }
    public void setOrderAmount(double orderAmount)
    {
        this.orderAmount = orderAmount;
    }
    public int getOrderState()
    {
        return orderState;
    }
    public void setOrderState(int orderState)
    {
        this.orderState = orderState;
    }
}
