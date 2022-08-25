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

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/form")
public class FormController {
    @Autowired
    FileStorageService storageService;
    Logger logger = LogManager.getLogger(FormController.class);
    FormModel form = new FormModel();


    @ResponseBody
    @GetMapping(path = "/autoCompleteData/{val}")
    public List<String> matchTokenFromData(@PathVariable String val){
        return this.form.matchAutoCompleteData(val);
    }

    @ResponseBody
    @GetMapping(path = "/autoCompleteData/")
    public List<String> allData(){
        return this.form.getAutoCompleteData();
    }

    @ResponseBody
    @PostMapping("/submit")
    public String handleSubmission(@RequestParam("file") MultipartFile file,
                                   @RequestParam("textfield") String text,
                                   @RequestParam("readonlyfield") String readonlyField ,
                                   @RequestParam("radiobtn") Boolean radiobtn,
                                   @RequestParam("autocomplete") String autocomplete)
    {
        logger.debug("file: "+file.getOriginalFilename());
        try{
            FormModel form = new FormModel(text,radiobtn,file,autocomplete);
            logger.debug("text: "+text);
            logger.debug("radiobtn: "+radiobtn);
            logger.debug("readOnlyField: "+readonlyField);
            logger.debug("file: "+file.getOriginalFilename());
            logger.debug("autocomplete: "+autocomplete);
            storageService.save(file);
            return form.toString();
        }catch(Exception e){
            return e.toString();
        }
    }

    @GetMapping("/submit")
    public ModelAndView acceptSubmission(@NotNull Model model){
        FormModel form = new FormModel();
        model.addAllAttributes(form.view());
        return new ModelAndView("user/submit","form",model);
    }


}
