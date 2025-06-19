package org.g220804.pojo;

public class Cinema
{
    private int cinemaId;
    private String cinemaName;
    private String cinemaPassword;
    private String cinemaAddress;
    private boolean cinemaState = true;
    public Cinema()
    {
    }
    public Cinema(int cinemaId, String cinemaName, String cinemaPassword, String cinemaAddress, boolean cinemaState)
    {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaPassword = cinemaPassword;
        this.cinemaAddress = cinemaAddress;
        this.cinemaState = cinemaState;
    }
    public int getCinemaId()
    {
        return cinemaId;
    }
    public void setCinemaId(int cinemaId)
    {
        this.cinemaId = cinemaId;
    }
    public String getCinemaName()
    {
        return cinemaName;
    }
    public void setCinemaName(String cinemaName)
    {
        this.cinemaName = cinemaName;
    }
    public String getCinemaPassword()
    {
        return cinemaPassword;
    }
    public void setCinemaPassword(String cinemaPassword)
    {
        this.cinemaPassword = cinemaPassword;
    }
    public String getCinemaAddress()
    {
        return cinemaAddress;
    }
    public void setCinemaAddress(String cinemaAddress)
    {
        this.cinemaAddress = cinemaAddress;
    }
    public boolean getCinemaState()
    {
        return cinemaState;
    }
    public void setCinemaState(boolean cinemaState)
    {
        this.cinemaState = cinemaState;
    }
}
