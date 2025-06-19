package org.g220804.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Order
{
    private int orderId;
    private String orderNum;
    private int orderUserId;
    private int orderArrangeId;
    private int orderSeatRow;
    private int orderSeatCol;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime orderTime;
    private double orderAmount;
    private int orderState = 0;
    private Integer orderPayId;
    public Order()
    {
    }
    public Order(int orderId, String orderNum, int orderUserId, int orderArrangeId, int orderSeatRow, int orderSeatCol, LocalDateTime orderTime, double orderAmount, int orderState, Integer orderPayId)
    {
        this.orderId = orderId;
        this.orderNum = orderNum;
        this.orderUserId = orderUserId;
        this.orderArrangeId = orderArrangeId;
        this.orderSeatRow = orderSeatRow;
        this.orderSeatCol = orderSeatCol;
        this.orderTime = orderTime;
        this.orderAmount = orderAmount;
        this.orderState = orderState;
        this.orderPayId = orderPayId;
    }
    public int getOrderId()
    {
        return orderId;
    }
    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }
    public String getOrderNum()
    {
        return orderNum;
    }
    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }
    public int getOrderUserId()
    {
        return orderUserId;
    }
    public void setOrderUserId(int orderUserId)
    {
        this.orderUserId = orderUserId;
    }
    public int getOrderArrangeId()
    {
        return orderArrangeId;
    }
    public void setOrderArrangeId(int orderArrangeId)
    {
        this.orderArrangeId = orderArrangeId;
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
    public Integer getOrderPayId()
    {
        return orderPayId;
    }
    public void setOrderPayId(Integer orderPayId)
    {
        this.orderPayId = orderPayId;
    }
}
