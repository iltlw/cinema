package org.g220804.service;

import org.g220804.http.AppInfo;
import org.g220804.mapper.ArrangeMapper;
import org.g220804.mapper.CinemaHallMapper;
import org.g220804.mapper.CinemaMapper;
import org.g220804.mapper.MovieMapper;
import org.g220804.pojo.*;
import org.g220804.util.ResponseJson;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Service
public class CinemaService
{
    private final CinemaMapper cinemaMapper;
    private final CinemaHallMapper cinemaHallMapper;
    private final MovieMapper movieMapper;
    private final ArrangeMapper arrangeMapper;
    public CinemaService(CinemaMapper cinemaMapper, CinemaHallMapper cinemaHallMapper, MovieMapper movieMapper, ArrangeMapper arrangeMapper)
    {
        this.cinemaMapper = cinemaMapper;
        this.cinemaHallMapper = cinemaHallMapper;
        this.movieMapper = movieMapper;
        this.arrangeMapper = arrangeMapper;
    }
    public ResponseJson login(String username, String password, HttpSession httpSession)
    {
        Cinema cinema = cinemaMapper.getCinemaByUserName(username);
        if(cinema != null)
        {
            if(!cinema.getCinemaState())
            {
                return ResponseJson.getError("已被封号");
            }
            else if(cinema.getCinemaPassword().equals(password))
            {
                httpSession.setAttribute(AppInfo.SESSION_CINEMA, cinema);
                return ResponseJson.getOK();
            }
            else
            {
                return ResponseJson.getError("密码错误");
            }
        }
        return ResponseJson.getError("用户不存在");
    }
    public ResponseJson addHall(CinemaHall cinemaHall, HttpSession httpSession)
    {
        Cinema cinema = getPojoBySession(httpSession);
        cinemaHall.setCinemaHallCinemaId(cinema.getCinemaId());
        int i = cinemaHallMapper.add(cinemaHall);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
    private Cinema getPojoBySession(HttpSession httpSession)
    {
        return (Cinema) httpSession.getAttribute(AppInfo.SESSION_CINEMA);
    }
    public ResponseJson getHallList(HttpSession httpSession)
    {
        Cinema cinema = getPojoBySession(httpSession);
        List<CinemaHall> cinemaHallList = cinemaHallMapper.getList(cinema.getCinemaId());
        return ResponseJson.getOK(cinemaHallList);
    }
    public ResponseJson changeHallState(int cinemaHallId, int state)
    {
        if(state == 0 || state == 1)
        {
            int i = cinemaHallMapper.changeHallStateById(cinemaHallId, state);
            return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
        }
        return ResponseJson.getError();
    }
    public ResponseJson deleteHall(int cinemaHallId)
    {
        int i = cinemaHallMapper.deleteById(cinemaHallId);
        return i > 0? ResponseJson.getOK() : ResponseJson.getError();
    }
    public ResponseJson getMovieList()
    {
        List<Movie> movieList = movieMapper.getListByState(1);
        return ResponseJson.getOK(movieList);
    }
    public ResponseJson addArrange(Arrange arrange)
    {
        int i = arrangeMapper.add(arrange);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
    public ResponseJson getArrangeList(HttpSession httpSession)
    {
        Cinema cinema = getPojoBySession(httpSession);
        List<ArrangeView> arrangeList = arrangeMapper.getViewListByCinemaId(cinema.getCinemaId());
        return ResponseJson.getOK(arrangeList);
    }
}
