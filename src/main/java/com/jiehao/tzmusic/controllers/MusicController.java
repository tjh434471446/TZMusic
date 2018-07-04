package com.jiehao.tzmusic.controllers;

import com.jiehao.tzmusic.pojo.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@EnableAutoConfiguration
@RequestMapping("/myMusic")
public class MusicController {
    @GetMapping("")
    public String mainPage(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println("myMusic user is  " + user);
        System.out.println(session.getAttribute("loginFlag"));
        if (null != user){

            return "myMusic";
        }
        return "index";
    }
}
