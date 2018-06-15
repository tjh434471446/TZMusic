package com.jiehao.tzmusic.controllers;

import com.jiehao.tzmusic.dto.entity.User;
import com.jiehao.tzmusic.dto.repository.UserRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
class HomeController{
    private UserRepository userRepository;
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
    String loginSubmit(@ModelAttribute User user,Model model){
        System.out.println(user.getPassword());
        if (null != userRepository.findByUsername(user.getUsername())) {
            model.addAttribute("user", user);
            model.addAttribute("logged", true);
        }
        return "index";
    }

    @GetMapping("/register")
    String registerForm(Model model){
        model.addAttribute("user",new User());
        return  "register";
    }
}