package com.xiaostudy.shiro_test1.service;

import com.xiaostudy.shiro_test1.entity.UserEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 14:55
 * Description: No Description
 */
public interface UserService {

    UserEntity findByName(String name);

    UserEntity findById(String id);
}

