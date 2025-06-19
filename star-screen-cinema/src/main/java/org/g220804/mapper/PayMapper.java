package org.g220804.mapper;

import org.g220804.pojo.Pay;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PayMapper
{
    @Insert("insert into t_pay values(null,#{payNum},#{payTime},null,null)")
    int add(Pay pay);
    @Select("select pay_id from t_pay where pay_num=#{payNum}")
    int getIdByNum(String payNum);
    @Select("select * from t_pay where pay_id=#{payId}")
    Pay getById(int payId);
}
