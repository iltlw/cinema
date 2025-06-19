package org.g220804.mapper;

import org.g220804.pojo.Cinema;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CinemaMapper
{
    @Select("select * from t_cinema where cinema_name=#{username}")
    Cinema getCinemaByUserName(String username);
    @Insert("insert into t_cinema values(null,#{cinemaName},#{cinemaPassword},#{cinemaAddress},1)")
    int addCinema(Cinema cinema);
    @Select("select * from t_cinema")
    List<Cinema> getList();
    @Update("update t_cinema set cinema_state=#{state} where cinema_id=#{cinemaId}")
    int changeCinemaState(@Param("cinemaId") int cinemaId, @Param("state") boolean state);
}
