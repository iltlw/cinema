package org.g220804.mapper;

import org.g220804.pojo.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MovieMapper
{
    @Insert("insert into t_movie values(null,#{movieName},#{movieDuration},1,#{movieImgUrl})")
    int add(Movie movie);
    @Select("select * from t_movie")
    List<Movie> list();
    @Update("update t_movie set movie_state=#{state} where movie_id=#{movieId}")
    int changeMovieState(@Param("movieId") int movieId, @Param("state") boolean state);
    @Select("select * from t_movie where movie_state=#{state}")
    List<Movie> getListByState(int state);
    List<Movie> getMovieByIds(@Param("movieIds") List<Integer> movieIds);
}
