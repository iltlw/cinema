package org.g220804.controller;

import org.g220804.pojo.Arrange;
import org.g220804.pojo.CinemaHall;
import org.g220804.service.CinemaService;
import org.g220804.util.ResponseJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/cinema")
public class CinemaController
{
    private final CinemaService cinemaService;
    public CinemaController(CinemaService cinemaService){this.cinemaService = cinemaService;}
    @PostMapping("/login")
    public ResponseJson login(String username, String password, HttpSession httpSession)
    {
        return cinemaService.login(username, password, httpSession);
    }
    @PostMapping("/add-hall")
    public ResponseJson addHall(CinemaHall cinemaHall, HttpSession httpSession)
    {
        return cinemaService.addHall(cinemaHall, httpSession);
    }
    @PostMapping("/hall-list")
    public ResponseJson getHallList(HttpSession httpSession)
    {
        return cinemaService.getHallList(httpSession);
    }
    @PostMapping("/change-hall-state")
    public ResponseJson changeHallState(int cinemaHallId, int state)
    {
        return cinemaService.changeHallState(cinemaHallId, state);
    }
    @PostMapping("/delete-hall")
    public ResponseJson deleteHall(int cinemaHallId)
    {
        return cinemaService.deleteHall(cinemaHallId);
    }
    @PostMapping("/movie-list")
    public ResponseJson getMovieList()
    {
        return cinemaService.getMovieList();
    }
    @PostMapping("/add-arrange")
    public ResponseJson addArrange(Arrange arrange)
    {
        return cinemaService.addArrange(arrange);
    }
    @PostMapping("/arrange-list")
    public ResponseJson getArrangeList(HttpSession httpSession)
    {
        return cinemaService.getArrangeList(httpSession);
    }
}
