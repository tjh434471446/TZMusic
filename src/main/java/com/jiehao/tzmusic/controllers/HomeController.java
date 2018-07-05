package com.jiehao.tzmusic.controllers;

import com.jiehao.tzmusic.dao.UserService;
import com.jiehao.tzmusic.pojo.User;
import com.jiehao.tzmusic.pojo.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
class HomeController{
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    String home(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        session.setAttribute("loginFlag",false);
        if (null != user){
            session.setAttribute("loginFlag",true);
        }
        return "index";
    }

    @GetMapping("/login")
    String loginForm(Model model){
        model.addAttribute("user",new User());
        return "user/login";
    }

    @PostMapping("/login")
    @ResponseBody WebResult loginSubmit(@Valid @RequestBody User user,HttpSession session){
        System.out.println("the username is " + user.getUsername());
        //System.out.println("the password is " + user.getPassword());
        User userFind = userService.getByUsernameAndAndPassword(user.getUsername(),user.getPassword());
        if (null != userFind) {
            if (!userFind.getPassword().equals(user.getPassword())){
                return new WebResult(-1,"用户名或密码错误",null);
            }
            session.setAttribute("user",user);
            session.setAttribute("loginFlag",true);
            return new WebResult(1,"成功",user);
        }
        return new WebResult(-1,"无此用户",null);
    }

    @GetMapping("/register")
    String registerForm(Model model){
        model.addAttribute("user",new User());
        System.out.println(11111);
        return  "user/register";
    }
    @PostMapping("/register")
    @ResponseBody WebResult registerSubmit(@RequestBody User user,HttpSession session){
        User userCheck = userService.getByUsernameAndAndPassword(user.getUsername(),user.getPassword());
        if (null != userCheck){
            new WebResult(-1,"用户已存在",null);
        }
        userService.save(user);
        //System.out.println(userCheck.getUsername());
        session.setAttribute("user",user);
        session.setAttribute("loginFlag",true);
        return new WebResult(1,"注册成功",user);
    }
    @GetMapping("exit")
    String exitLogin(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("loginFlag");
        return "index";
    }

}