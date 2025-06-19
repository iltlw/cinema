package org.g220804.mapper;

import org.g220804.pojo.CinemaHall;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CinemaHallMapper
{
    @Insert("insert into t_cinema_hall values(null,#{cinemaHallName},#{cinemaHallSeat},#{cinemaHallCinemaId},1)")
    int add(CinemaHall cinemaHall);
    @Select("select * from t_cinema_hall where cinema_hall_cinema_id=#{cinemaId}")
    List<CinemaHall> getList(int cinemaId);
    @Update("update t_cinema_hall set cinema_hall_state=#{state} where cinema_hall_id=#{cinemaHallId}")
    int changeHallStateById(@Param("cinemaHallId") int cinemaHallId, @Param("state") int state);
    @Delete("delete from t_cinema_hall where cinema_hall_id=#{hallId}")
    int deleteById(int hallId);
}
