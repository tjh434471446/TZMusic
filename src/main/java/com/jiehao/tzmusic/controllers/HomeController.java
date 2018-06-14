package com.jiehao.tzmusic.controllers;

import com.jiehao.tzmusic.entity.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@EnableAutoConfiguration
class HomeController{
    @RequestMapping("/index")
    String home(){
        return "index";
    }
    @GetMapping("/login")
    String loginForm(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/login")
    String loginSubmit(@ModelAttribute User user){
        System.out.println(user.getPassword());

        return "index";
    }
}