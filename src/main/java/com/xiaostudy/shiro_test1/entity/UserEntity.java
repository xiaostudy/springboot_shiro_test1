package com.xiaostudy.shiro_test1.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 14:26
 * Description: No Description
 */
public class UserEntity implements Serializable {
    private String id;
    private String name;
    private String password;
    private Set<RoleEntity> roles = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}

