package com.leoni.stage.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    @RequestMapping("/home")
    public String home(){
        logger.info("info level work");
        logger.debug("debug level work");
        logger.warn("warn level work");
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
