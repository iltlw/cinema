package org.g220804.pojo;

public class Movie
{
    private int movieId;
    private String movieName;
    private int movieDuration;
    private boolean movieState = true;
    private String movieImgUrl;
    public Movie()
    {
    }
    public Movie(String movieName, int movieDuration, boolean movieState, String movieImgUrl)
    {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.movieState = movieState;
        this.movieImgUrl = movieImgUrl;
    }
    public Movie(int movieId, String movieName, int movieDuration, boolean movieState, String movieImgUrl)
    {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.movieState = movieState;
        this.movieImgUrl = movieImgUrl;
    }
    public int getMovieId()
    {
        return movieId;
    }
    public void setMovieId(int movieId)
    {
        this.movieId = movieId;
    }
    public String getMovieName()
    {
        return movieName;
    }
    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }
    public int getMovieDuration()
    {
        return movieDuration;
    }
    public void setMovieDuration(int movieDuration)
    {
        this.movieDuration = movieDuration;
    }
    public boolean getMovieState()
    {
        return movieState;
    }
    public void setMovieState(boolean movieState)
    {
        this.movieState = movieState;
    }
    public String getMovieImgUrl()
    {
        return movieImgUrl;
    }
    public void setMovieImgUrl(String movieImgUrl)
    {
        this.movieImgUrl = movieImgUrl;
    }
}
