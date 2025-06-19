package org.g220804.controller;

import org.g220804.pojo.Cinema;
import org.g220804.service.AdminService;
import org.g220804.util.ResponseJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminController
{
    private final AdminService adminService;
    public AdminController(AdminService adminService){this.adminService = adminService;}
    @PostMapping("/login")
    public ResponseJson login(String name, String password, HttpSession httpSession)
    {
        return adminService.login(name, password, httpSession);
    }
    @PostMapping("/add-movie")
    public ResponseJson addMovie(String movieName, int movieDuration, MultipartFile file) throws IOException
    {
        return adminService.addMovie(movieName, movieDuration, file);
    }
    @PostMapping("/movie-list")
    public ResponseJson getMovieList()
    {
        return adminService.getMovieList();
    }
    @PostMapping("/change-movie-state")
    public ResponseJson changeMovieState(int movieId, boolean state)
    {
        return adminService.changeMovieState(movieId, state);
    }
    @PostMapping("/add-cinema")
    public ResponseJson addCinema(Cinema cinema)
    {
        return adminService.addCinema(cinema);
    }
    @PostMapping("/cinema-list")
    public ResponseJson getCinemaList()
    {
        return adminService.getCinemaList();
    }
    @PostMapping("/change-cinema-state")
    public ResponseJson changeCinemaState(int cinemaId, boolean cinemaState)
    {
        System.out.println(cinemaId + " " + cinemaState);
        return adminService.changeCinemaState(cinemaId, cinemaState);
    }
}
