package com.ay.controller;

import com.ay.model.AyUser;
import com.ay.service.AyUserService;
import com.ay.service.impl.AyUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

@Controller
@RequestMapping("/user")
public class AyUserController {
    @Autowired
    private AyUserService ayUserService;

    @GetMapping("/findAll")
    public String findAll() {
        List<AyUser> ayUserList = ayUserService.findAll();
        for (AyUser ayUser : ayUserList) {
            System.out.println("id:" + ayUser.getId());
            System.out.println("name:" + ayUser.getName());
        }
        return "hello";
    }
}
