package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("user")
public class UserController {

    private String xinxi;
    @Autowired
    private UserService service;

    @GetMapping("login")
    public String login(String username, String password) {
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("正确");
            return "index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "b";
//            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
            return "b";
        }
    }


    @RequestMapping("index")
    public String index() {
        System.out.println("跳转至主页");
        return "a";
    }


    @GetMapping("yan")
    public void yanzhengma(@RequestParam("email") String email) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            String random = String.valueOf(new Random().nextInt(10));
            sb.append(random);
        }
        System.out.printf("email----------------------****" + email);
        String yanz = sb.toString();
        System.out.printf(" yanzheng------------------------------------xinxi" + xinxi);
        System.out.printf(" yanzhegn------------------------------------yanz" + yanz);
        xinxi = yanz;


    }

    @PostMapping("register")
    public String register(@RequestParam("username") String name, @RequestParam("password") String password, @RequestParam("yan") String yan) {
        if (yan.equals(xinxi)) {
            try {
                User user = new User();
                user.setUsername(name);
                user.setPassword(password);
                System.out.printf("register success------------------------------------xinxi" + xinxi);
                service.register(user);
                System.out.println("注册成功");
                return "a";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.printf("register erro------------------------------------xinxi" + xinxi);
                return "b";
            }
        }

        return "b";
    }


//    @RequestMapping("save")
//    public String save(){
//        System.out.println("进入方法");
//        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//        //代码方式
//        if (subject.hasRole("admin")) {
//            System.out.println("保存订单!");
//        }else{
//            System.out.println("无权访问!");
//        }
//        //基于权限字符串
//        //....
//        return "redirect:/index.jsp";
//    }


    @RequiresRoles(value = {"admin", "user"})//用来判断角色  同时具有 admin user
    @RequiresPermissions("user:update:01") //用来判断权限字符串
    @RequestMapping("save")
    public String save() {
        System.out.println("进入方法");
        return "redirect:/index.jsp";
    }


}
