package com.leoni.stage.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/user")
    public ModelAndView userPage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/userdata");
        return mav;
    }
}
