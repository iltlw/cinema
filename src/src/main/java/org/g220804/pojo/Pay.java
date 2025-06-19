package org.g220804.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Pay
{
    private int payId;
    private String payNum;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime payTime;
    private String payRefundInfo;
    private String payNotifyInfo;
    public Pay()
    {
    }
    public Pay(int payId, String payNum, LocalDateTime payTime, String payRefundInfo, String payNotifyInfo)
    {
        this.payId = payId;
        this.payNum = payNum;
        this.payTime = payTime;
        this.payRefundInfo = payRefundInfo;
        this.payNotifyInfo = payNotifyInfo;
    }
    public int getPayId()
    {
        return payId;
    }
    public void setPayId(int payId)
    {
        this.payId = payId;
    }
    public String getPayNum()
    {
        return payNum;
    }
    public void setPayNum(String payNum)
    {
        this.payNum = payNum;
    }
    public LocalDateTime getPayTime()
    {
        return payTime;
    }
    public void setPayTime(LocalDateTime payTime)
    {
        this.payTime = payTime;
    }
    public String getPayRefundInfo()
    {
        return payRefundInfo;
    }
    public void setPayRefundInfo(String payRefundInfo)
    {
        this.payRefundInfo = payRefundInfo;
    }
    public String getPayNotifyInfo()
    {
        return payNotifyInfo;
    }
    public void setPayNotifyInfo(String payNotifyInfo)
    {
        this.payNotifyInfo = payNotifyInfo;
    }
}
