package com.jiehao.tzmusic.controllers;

import com.jiehao.tzmusic.dao.SQLUserRepository;
import com.jiehao.tzmusic.pojo.SQLUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sqltest")
public class SQLTestController {
    @Autowired
    SQLUserRepository userRepository;
    @GetMapping("/all")
    @ResponseBody Iterable<SQLUser> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/add")
    @ResponseBody String addNewUser(@RequestParam String name,@RequestParam String email){
        SQLUser user = new SQLUser();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return "Saved";
    }
}
