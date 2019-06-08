package com.xiaostudy.shiro_test1.web.controller;

import com.xiaostudy.shiro_test1.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户页面跳转
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 15:21
 * Description: No Description
 */
@Controller
public class UserController {

    /**
     * 个人中心，需认证可访问
     */
    @RequestMapping("/user/index")
    @RequiresPermissions(value = "user")// 这里的user，就是对应权限实体类PermissionEntity的字段url，自定义Realm类UserRealm里是用这个字段
    public String add(HttpServletRequest request){
        UserEntity bean = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("userName", bean.getName());
        return "/user/index";
    }

    /**
     * 会员中心，需认证且角色为vip可访问
     */
    @RequestMapping("/vip/index")
    @RequiresPermissions(value = "vip")
    public String update(){
        return "/vip/index";
    }
}
