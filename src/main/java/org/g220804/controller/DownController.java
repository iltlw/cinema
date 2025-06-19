package org.g220804.controller;

import org.g220804.service.DownService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/down")
public class DownController
{
    private final DownService downService;
    public DownController(DownService downService){this.downService = downService;}
    @GetMapping("/movie/img/{filename}")
    public void movieImg(@PathVariable("filename") String filename, HttpServletResponse response) throws IOException
    {
        downService.movieImg(filename, response);
    }
}
