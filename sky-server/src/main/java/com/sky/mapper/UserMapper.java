package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.entity.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE openid = #{id}")
    public User getByOpenid(String openid);

    void insert(User user);
}
