package com.ssm.mapper;

import com.ssm.pojo.Result;
import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Select;


import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from tb_user where id = #{id}")
    public User findById(Integer id);

    @Select("select * from tb_user")
    public List<User> findAll();

    Result<Map<String, String>> addUser(User user);
}

