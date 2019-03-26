package com.caiqian.miaosha.service;

import com.caiqian.miaosha.dao.UserMapper;
import com.caiqian.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author SGN196
 * @date 2019/3/23 19:28
 */


@Service
public class UserService
{
    @Autowired
    UserMapper userMapper;

    public User getById(int id){
        return userMapper.getById(id);
    }

    @Transactional
    public boolean tx()
    {
        User u1 = new User();
        u1.setId(2);
        u1.setName("222222");
        userMapper.insert(u1);

        User u2 = new User();
        u1.setId(1);
        u1.setName("11111");
        userMapper.insert(u1);

        return true;

    }
}
