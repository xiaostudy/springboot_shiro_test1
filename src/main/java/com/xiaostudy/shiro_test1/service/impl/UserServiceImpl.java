package com.xiaostudy.shiro_test1.service.impl;

import com.xiaostudy.shiro_test1.entity.UserEntity;
import com.xiaostudy.shiro_test1.mapper.UserMapper;
import com.xiaostudy.shiro_test1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 14:56
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public UserEntity findById(String id) {
        return userMapper.findById(id);
    }
}