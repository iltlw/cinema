package org.g220804.mapper;

import org.g220804.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper
{
    @Select("select * from t_admin where admin_name=#{name}")
    Admin getAdminByAdminName(String name);
}
