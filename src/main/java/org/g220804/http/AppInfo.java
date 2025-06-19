package org.g220804.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:img.properties")
public class AppInfo
{
    public static final String SESSION_USER = "user";
    public static final String SESSION_CINEMA = "cinema";
    public static final String SESSION_ADMIN = "admin";
    public static String MOVIE_IMG_PATH;
    @Value("${img.path}")
    public void setMovieImgPath(String movieImgPath)
    {
        MOVIE_IMG_PATH = movieImgPath;
    }
}
