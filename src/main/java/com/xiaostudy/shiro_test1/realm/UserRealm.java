package com.xiaostudy.shiro_test1.realm;

import com.xiaostudy.shiro_test1.entity.PermissionEntity;
import com.xiaostudy.shiro_test1.entity.RoleEntity;
import com.xiaostudy.shiro_test1.entity.UserEntity;
import com.xiaostudy.shiro_test1.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm，实现授权与认证
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 15:01
 * Description: No Description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 用户授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {

        System.out.println("===执行授权===");

        Subject subject = SecurityUtils.getSubject();
        UserEntity user = (UserEntity)subject.getPrincipal();
        if(user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            // 权限字符串集合
            Collection<String> premissionCollection = new HashSet<>();
            // 读取并赋值用户角色与权限
            Set<RoleEntity> roles = user.getRoles();
            for(RoleEntity role : roles){
                rolesCollection.add(role.getName());
                Set<PermissionEntity> permissions = role.getPermissions();
                for (PermissionEntity permission : permissions){
                    // 权限名称为PermissionEntity为字段url
                    premissionCollection.add(permission.getUrl());
                }
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * 用户认证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("===执行认证===");

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        UserEntity bean = userService.findByName(token.getUsername());

        if(bean == null){
            // 用户不存在
            throw new UnknownAccountException();
        } else {
            bean = userService.findById(bean.getId());
            if(null == bean) {
                // 认证失败
                throw new AuthenticationException();
            }
        }

        ByteSource credentialsSalt = ByteSource.Util.bytes(bean.getName());

        return new SimpleAuthenticationInfo(bean, bean.getPassword(),
                credentialsSalt, getName());
    }
}