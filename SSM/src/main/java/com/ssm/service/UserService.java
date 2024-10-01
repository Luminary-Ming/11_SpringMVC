package com.ssm.service;

import com.ssm.pojo.Result;
import com.ssm.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    Result<User> findById(Integer id);

    Result<List<User>> findAll();

    public Result<Map<String,String>> addUser(User user);
}
