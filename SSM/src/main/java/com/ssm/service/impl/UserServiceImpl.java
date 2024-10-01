package com.ssm.service.impl;

import com.ssm.exception.BizException;
import com.ssm.mapper.UserMapper;
import com.ssm.pojo.Result;
import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> findById(Integer id) {
        User user = userMapper.findById(id);
        if(user != null){
            return Result.success(user);
        }
        return Result.fail(5000,"没有查询到此用户");
    }

    @Override
    public Result<List<User>> findAll() {
        List<User> users = userMapper.findAll();
        if(users != null){
            return Result.success(users);
        }
        return Result.fail(5000,"查询错误");
    }

    @Override
    public Result<Map<String, String>> addUser(User user) {
        if(user.getUserName().equals("admin")){
            throw new BizException(4000,"用户名重复");
        }
        if(user.getTel().equals("13015944517")){
            throw new BizException(4001,"手机号重复");
        }
        return userMapper.addUser(user);
    }
}
