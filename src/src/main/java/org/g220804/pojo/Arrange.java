package org.g220804.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Arrange
{
    private int arrangeId;
    private int arrangeCinemaHallId;
    private int arrangeMovieId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime arrangeMovieStartTime;
    private double arrangePrice;
    private boolean arrangeState = true;
    public Arrange()
    {
    }
    public Arrange(int arrangeId, int arrangeCinemaHallId, int arrangeMovieId, LocalDateTime arrangeMovieStartTime, int arrangePrice, boolean arrangeState)
    {
        this.arrangeId = arrangeId;
        this.arrangeCinemaHallId = arrangeCinemaHallId;
        this.arrangeMovieId = arrangeMovieId;
        this.arrangeMovieStartTime = arrangeMovieStartTime;
        this.arrangePrice = arrangePrice;
        this.arrangeState = arrangeState;
    }
    public int getArrangeId()
    {
        return arrangeId;
    }
    public void setArrangeId(int arrangeId)
    {
        this.arrangeId = arrangeId;
    }
    public int getArrangeCinemaHallId()
    {
        return arrangeCinemaHallId;
    }
    public void setArrangeCinemaHallId(int arrangeCinemaHallId)
    {
        this.arrangeCinemaHallId = arrangeCinemaHallId;
    }
    public int getArrangeMovieId()
    {
        return arrangeMovieId;
    }
    public void setArrangeMovieId(int arrangeMovieId)
    {
        this.arrangeMovieId = arrangeMovieId;
    }
    public LocalDateTime getArrangeMovieStartTime()
    {
        return arrangeMovieStartTime;
    }
    public void setArrangeMovieStartTime(LocalDateTime arrangeMovieStartTime)
    {
        this.arrangeMovieStartTime = arrangeMovieStartTime;
    }
    public double getArrangePrice()
    {
        return arrangePrice;
    }
    public void setArrangePrice(double arrangePrice)
    {
        this.arrangePrice = arrangePrice;
    }
    public boolean getArrangeState()
    {
        return arrangeState;
    }
    public void setArrangeState(boolean arrangeState)
    {
        this.arrangeState = arrangeState;
    }
}
