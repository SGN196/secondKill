package com.caiqian.miaosha.domain;

/**
 * @author SGN196
 * @date 2019/3/23 19:23
 */

public class User
{
    private int id;
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public User(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public User(){

    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
