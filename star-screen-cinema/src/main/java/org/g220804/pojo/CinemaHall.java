package org.g220804.pojo;

public class CinemaHall
{
    private int cinemaHallId;
    private String cinemaHallName;
    private String cinemaHallSeat;
    private int cinemaHallCinemaId;
    private boolean cinemaHallState = true;
    public CinemaHall()
    {
    }
    public CinemaHall(int cinemaHallId, String cinemaHallName, String cinemaHallSeat, int cinemaHallCinemaId, boolean cinemaHallState)
    {
        this.cinemaHallId = cinemaHallId;
        this.cinemaHallName = cinemaHallName;
        this.cinemaHallSeat = cinemaHallSeat;
        this.cinemaHallCinemaId = cinemaHallCinemaId;
        this.cinemaHallState = cinemaHallState;
    }
    public int getCinemaHallId()
    {
        return cinemaHallId;
    }
    public void setCinemaHallId(int cinemaHallId)
    {
        this.cinemaHallId = cinemaHallId;
    }
    public String getCinemaHallName()
    {
        return cinemaHallName;
    }
    public void setCinemaHallName(String cinemaHallName)
    {
        this.cinemaHallName = cinemaHallName;
    }
    public String getCinemaHallSeat()
    {
        return cinemaHallSeat;
    }
    public void setCinemaHallSeat(String cinemaHallSeat)
    {
        this.cinemaHallSeat = cinemaHallSeat;
    }
    public int getCinemaHallCinemaId()
    {
        return cinemaHallCinemaId;
    }
    public void setCinemaHallCinemaId(int cinemaHallCinemaId)
    {
        this.cinemaHallCinemaId = cinemaHallCinemaId;
    }
    public boolean getCinemaHallState()
    {
        return cinemaHallState;
    }
    public void setCinemaHallState(boolean cinemaHallState)
    {
        this.cinemaHallState = cinemaHallState;
    }
}
