package com.leoni.stage.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @GetMapping("/userlogedin")
    public String logedin(){
        return "hellooo loged in";
    }
    @GetMapping("/userlogin")
    public String login(){
        return "hellooo log in";
    }
}
