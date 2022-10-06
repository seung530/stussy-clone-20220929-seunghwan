package com.stussy.stussyClone20220929seunghwan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
@Controller
public class AccountPageController {


    @GetMapping("/login")
    public String login() {

        return "account/login";
    }

    @GetMapping("/register")
    public String register() {
        return "account/register";
    }

}
