package com.leoni.stage.controller;

import com.leoni.stage.model.FormModel;
import com.leoni.stage.model.SearchToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/form")
public class FormController {

    Logger logger = LogManager.getLogger(FormController.class);
    FormModel form = new FormModel();

    @ResponseBody
    @GetMapping(path = "/autoCompleteData")
    public List<String> matchTokenFromData(@RequestBody SearchToken req){
        logger.debug(req.searchToken);
        this.form.fetchAutoCompleteData();
        return this.form.matchAutoCompleteData(req.searchToken);
    }


    @GetMapping("/submit")
    public ModelAndView acceptSubmission(Model model){

        return new ModelAndView("submit","model",model);
    }

}
