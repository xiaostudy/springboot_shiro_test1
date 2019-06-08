package com.xiaostudy.shiro_test1.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录、登出、错误页面跳转控制器
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/6/8
 * Time: 15:15
 * Description: No Description
 */
@Controller
public class MainController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("root", request.getContextPath());
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("root", request.getContextPath());
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // 等于null说明用户没有登录，只是拦截所有请求到这里，那就直接让用户去登录页面，就不认证了。
        // 如果这里不处理，那个会返回用户名不存在，逻辑上不合理，用户还没登录怎么就用户名不存在？
        if(null == userName) {
            return "login";
        }

        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 3.执行登录方法
        try{
            subject.login(token);
            return "redirect:/index";
        } catch (UnknownAccountException e){
            // 这里是捕获自定义Realm的用户名不存在异常
            request.setAttribute("msg","用户名不存在！");
        } catch (IncorrectCredentialsException e){
            request.setAttribute("userName",userName);
            request.setAttribute("msg","密码错误！");
        } catch (AuthenticationException e) {
            // 这里是捕获自定义Realm的认证失败异常
            request.setAttribute("msg","认证失败！");
        }

        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
//        return "redirect:/main";
        return "login";
    }

    @RequestMapping("/error/unAuth")
    public String unAuth(){
        return "/error/unAuth";
    }

    @RequestMapping("/err")
    public String err(){
        return "/error/unAuth";
    }
}
