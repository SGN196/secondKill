package com.caiqian.miaosha.dao;

import com.caiqian.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author SGN196
 * @date 2019/3/23 19:25
 */

@Mapper
public interface UserMapper
{
    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") int id);

    @Insert("insert into user(id, name) value(#{id}, #{name})")
    public int insert(User user);
}
