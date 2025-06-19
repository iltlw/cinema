package org.g220804.mapper;

import org.g220804.pojo.Arrange;
import org.g220804.pojo.ArrangeView;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ArrangeMapper
{
    @Insert("insert into t_arrange values(null, #{arrangeCinemaHallId}, #{arrangeMovieId}, #{arrangeMovieStartTime}, #{arrangePrice}, 1)")
    int add(Arrange arrange);
    @Select("select * from v_arrange where cinema_id=#{cinemaId} ")
    List<ArrangeView> getViewListByCinemaId(int cinemaId);
    @Select("select distinct arrange_movie_id from (select arrange_movie_id from t_arrange where #{startTime} < arrange_movie_start_time and arrange_state = 1 order by arrange_movie_start_time) as t_temp")
    List<Integer> getMovieIdsByStartTimeAfter(LocalDateTime startTime);
    @Select("select * from v_arrange where #{startTime} < movie_start_time and movie_id = #{movieId}")
    List<ArrangeView> getViewListByStartTimeAfterAndMovieId(@Param("startTime") LocalDateTime startTime, @Param("movieId") int movieId);
    @Select("select * from t_arrange where arrange_id=#{arrangeId}")
    Arrange getById(int arrangeId);
    @Select("select * from v_arrange where arrange_id=#{arrangeId}")
    ArrangeView getViewById(int arrangeId);
}
