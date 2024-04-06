package com.spring.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(Model model) {

        return "login";
    }

    @RequestMapping("/inicio")
    public String intranet(@AuthenticationPrincipal User user, Model model) {

        System.out.println("usuario que hizo login: " + user);

        return "inicio";
    }

}

