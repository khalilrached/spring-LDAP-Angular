package com.leoni.stage.controller;

import com.leoni.stage.model.FormModel;
import com.leoni.stage.services.FileStorageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/form")
public class FormController {

    Logger logger = LogManager.getLogger(FormController.class);
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
    FormModel form = new FormModel();

    @ResponseBody
    @PostMapping("/submit")
    public ModelAndView handleSubmission(
        @RequestParam("textfield") String textfield,
        @RequestParam("checkbox") Boolean checkbox,
        @RequestParam("selecteddata") Integer selectedindex,
        @RequestParam("pickeddate") String pickeddate,
        @RequestParam("selecteddata") String selecteddata,
        Model model
    )
    {
        try{
            this.form = new FormModel(textfield,checkbox,simpleDate.parse(pickeddate),selectedindex,selecteddata);
            FormModel temp = new FormModel();
            model.addAllAttributes(temp.render());
            model.addAttribute("submited",true);
            model.addAttribute("error","");
            logger.debug(this.form.toString());

        }catch (Exception e){
            model.addAttribute("submited",false);
            model.addAttribute("error",e.toString());
            logger.error(e.toString());
        }
        return new ModelAndView("user/submit","form",model);
    }

    @GetMapping("/submit")
    public ModelAndView acceptSubmission(Model model){
        FormModel form = new FormModel();
        model.addAllAttributes(form.render());
        model.addAttribute("submited",false);
        model.addAttribute("error","");
        return new ModelAndView("user/submit","form",model);
    }


}
