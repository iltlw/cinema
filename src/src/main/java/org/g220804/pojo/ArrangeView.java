package org.g220804.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ArrangeView
{
    private int arrangeId;
    private int cinemaId;
    private int cinemaHallId;
    private int movieId;
    private String cinemaName;
    private String cinemaHallName;
    private String movieName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime movieStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime movieEndTime;
    private int movieDuration;
    private String cinemaHallSeat;
    private double arrangePrice;
    private boolean arrangeState;
    public ArrangeView()
    {
    }
    public ArrangeView(int arrangeId, int cinemaId, int cinemaHallId, int movieId, String cinemaName, String cinemaHallName, String movieName, LocalDateTime movieStartTime, LocalDateTime movieEndTime, int movieDuration, String cinemaHallSeat, int arrangePrice, boolean arrangeState)
    {
        this.arrangeId = arrangeId;
        this.cinemaId = cinemaId;
        this.cinemaHallId = cinemaHallId;
        this.movieId = movieId;
        this.cinemaName = cinemaName;
        this.cinemaHallName = cinemaHallName;
        this.movieName = movieName;
        this.movieStartTime = movieStartTime;
        this.movieEndTime = movieEndTime;
        this.movieDuration = movieDuration;
        this.cinemaHallSeat = cinemaHallSeat;
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
    public String getCinemaHallSeat()
    {
        return cinemaHallSeat;
    }
    public void setCinemaHallSeat(String cinemaHallSeat)
    {
        this.cinemaHallSeat = cinemaHallSeat;
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
