package com.caiqian.miaosha.dao;

import com.caiqian.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author SGN196
 * @date 2019/3/26 19:51
 */

@Mapper
public interface MiaoshaUserMapper
{
    @Select("select * from miaosha_user where id = #{id}")
    public MiaoshaUser getById(@Param("id") long id);
}
