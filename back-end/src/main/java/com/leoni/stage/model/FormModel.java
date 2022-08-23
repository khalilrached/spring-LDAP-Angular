package com.leoni.stage.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Setter
@Getter
public class FormModel {

    private Logger logger = LogManager.getLogger(FormModel.class);

    private String shortTextField;
    private Boolean radioButton;
    private String readOnlyTextInput;
    private MultipartFile fileInput;
    private List<String> autoCompleteData;


    public FormModel(){
        this.shortTextField = "undefined";
        this.radioButton = true;
        this.readOnlyTextInput = "exp: fetched data from db!";
        this.fileInput = null;
        this.autoCompleteData = new ArrayList<>();
    }


    public FormModel(String shortTextField,
                     Boolean radioButton,
                     MultipartFile fileInput){
        this.shortTextField = shortTextField;
        this.radioButton = radioButton ;
        this.readOnlyTextInput = "exp: fetched data from db!";
        this.fileInput = fileInput;
        this.autoCompleteData =new ArrayList<>();
    }

    public void fetchAutoCompleteData(){
        ArrayList<String> data = new ArrayList<>();
        data.add("value1");
        data.add("value2");
        data.add("value3");
        data.add("value4");
        data.add("value5");
        data.add("value6");
        data.add("value7");
        data.add("value8");
        data.add("value9");
        data.add("value01");
        data.add("value02");
        data.add("item1");
        data.add("item2");
        data.add("item3");
        data.add("item4");
        data.add("item5");
        data.add("item6");
        data.add("item7");
        data.add("item8");
        data.add("item9");
        data.add("item01");
        data.add("string1");
        data.add("string2");
        data.add("string3");
        data.add("string4");
        data.add("string5");
        data.add("string6");
        data.add("string7");
        data.add("string8");
        this.setAutoCompleteData(data);
    }

    public void setReadOnlyTextInput(String readOnlyTextInput) {
        logger.warn("this is read only field!");
    }

    public List<String> matchAutoCompleteData(String searchToken){
        AtomicReference<List<String>> _TEMP_REF = new AtomicReference<>();
        _TEMP_REF.set(new ArrayList<>());
        this.autoCompleteData.forEach(data -> {
            if(data.contains(searchToken)){
                List<String> _TEMP_LIST = _TEMP_REF.get();
                _TEMP_LIST.add(data);
                _TEMP_REF.set(_TEMP_LIST);
            }
        });
        return _TEMP_REF.get();
    }

    public Map<String,Object> view(){
        HashMap<String,Object> attributes = new HashMap<>();
        attributes.put("textField",this.shortTextField);
        attributes.put("radioBtn",this.radioButton);
        attributes.put("readOnlyInput",this.readOnlyTextInput);
        return attributes;
    }

    @Override
    public String toString(){
        return
                "{" +
                    "\"shortTextField\":\"" +this.shortTextField+"\","+
                    "\"readOnlyTextInput\":\"" +this.readOnlyTextInput+"\","+
                    "\"radioButton\":"+this.radioButton+","+
                    "\"file\":" +"{" +
                                    "\"fileName\":\"" +this.fileInput.getOriginalFilename()+
                                "\"}" +
                "}";
    }
}
