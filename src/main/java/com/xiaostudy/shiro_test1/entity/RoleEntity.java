package com.xiaostudy.shiro_test1.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 14:24
 * Description: No Description
 */
public class RoleEntity implements Serializable {
    private String id;
    private String name;
    private Set<PermissionEntity> permissions = new HashSet<>();

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

    public Set<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
