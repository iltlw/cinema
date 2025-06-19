package org.g220804.mapper;

import org.g220804.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper
{
    @Insert("insert into t_user values(null,#{userName},#{userPassword},1)")
    int addUser(User user);
    @Select("select * from t_user where user_name=#{userName}")
    User getUserByUserName(String username);
}
