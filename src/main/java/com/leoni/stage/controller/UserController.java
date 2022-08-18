package com.leoni.stage.controller;



import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
public class UserController {
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("/about")
    public ModelAndView about(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("about");
        return mav;
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginpage");
        return mav;
    }

    @RequestMapping("/user")
    public ModelAndView userPage(@RequestParam String link, Model model){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message",link);
        mav.setViewName("user/userdata");
        return mav;
    }
}
