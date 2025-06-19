package org.g220804.service;

import org.g220804.http.AppInfo;
import org.g220804.mapper.CinemaMapper;
import org.g220804.mapper.MovieMapper;
import org.g220804.mapper.AdminMapper;
import org.g220804.pojo.Cinema;
import org.g220804.pojo.Movie;
import org.g220804.pojo.Admin;
import org.g220804.util.ResponseJson;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService
{
    private final AdminMapper adminMapper;
    private final MovieMapper movieMapper;
    private final CinemaMapper cinemaMapper;
    public AdminService(AdminMapper adminMapper, MovieMapper movieMapper, CinemaMapper cinemaMapper)
    {
        this.adminMapper = adminMapper;
        this.movieMapper = movieMapper;
        this.cinemaMapper = cinemaMapper;
    }
    public ResponseJson login(String name, String password, HttpSession httpSession)
    {
        Admin admin = adminMapper.getAdminByAdminName(name);
        if(admin != null)
        {
            if(admin.getAdminPassword().equals(password))
            {
                httpSession.setAttribute(AppInfo.SESSION_ADMIN, admin);
                return ResponseJson.getOK();
            }
            else
            {
                return ResponseJson.getError("密码错误");
            }
        }
        return ResponseJson.getError("用户不存在");
    }
    public ResponseJson addMovie(String movieName, int movieDuration, MultipartFile file) throws IOException
    {
        String imgName = UUID.randomUUID().toString();
        file.transferTo(new File(AppInfo.MOVIE_IMG_PATH, imgName));
        Movie movie = new Movie(movieName, movieDuration, true, "/down/movie/img/" + imgName);
        int i = movieMapper.add(movie);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
    public ResponseJson getMovieList()
    {
        List<Movie> movieList = movieMapper.list();
        return ResponseJson.getOK(movieList);
    }
    public ResponseJson changeMovieState(int movieId, boolean state)
    {
        int i = movieMapper.changeMovieState(movieId, state);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
    public ResponseJson addCinema(Cinema cinema)
    {
        int i = cinemaMapper.addCinema(cinema);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
    public ResponseJson getCinemaList()
    {
        List<Cinema> cinemaList = cinemaMapper.getList();
        return ResponseJson.getOK(cinemaList);
    }
    public ResponseJson changeCinemaState(int cinemaId, boolean state)
    {
        int i = cinemaMapper.changeCinemaState(cinemaId, state);
        return i > 0 ? ResponseJson.getOK() : ResponseJson.getError();
    }
}
