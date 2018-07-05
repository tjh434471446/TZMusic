package com.jiehao.tzmusic.controllers;

import com.jiehao.tzmusic.dao.SingerCollectionService;
import com.jiehao.tzmusic.pojo.Singer;
import com.jiehao.tzmusic.pojo.SingerCollection;
import com.jiehao.tzmusic.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/myMusic")
public class MusicController {
    @Autowired
    SingerCollectionService collectionService;

    @GetMapping("")
    public String mainPage(HttpSession session){
        User user = (User) session.getAttribute("user");
        System.out.println("myMusic user is  " + user);
        System.out.println(session.getAttribute("loginFlag"));
        if (null != user){

            return "myMusic/singers";
        }
        return "index";
    }

    @GetMapping("/singers")
    public String singers(HttpSession session){
        User user = (User) session.getAttribute("user");
        SingerCollection singerCollection = collectionService.getSingerCollectionsByUser(user);
        List<Singer> singers = singerCollection.getSingers();
        System.out.println(singers.size());
        if (null != user){
            return "myMusic/singers";
        }
        return "index";
    }
}
