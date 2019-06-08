package com.xiaostudy.shiro_test1.mapper;

import com.xiaostudy.shiro_test1.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 14:45
 * Description: No Description
 */
@Mapper
public interface UserMapper {

    // 根据用户名称，查询用户信息
    public UserEntity findByName(String name);

    // 根据用户id，查询用户信息、角色、权限
    public UserEntity findById(String id);
}
