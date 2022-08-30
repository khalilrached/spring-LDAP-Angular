package com.leoni.stage.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Setter
@Getter
public class FormModel {

    private Logger logger = LogManager.getLogger(FormModel.class);

    private String textField;
    private Boolean checkBox;
    private Date datePicked;
    private String selectedData;
    private List<String> multiSelectedData = new ArrayList<>();

    private List<String> selectFieldData = new ArrayList<>();
    private Map<String,String> multiSelectData = new HashMap<>();


    public FormModel(){
        this.textField = "text area";
        this.checkBox = false;
        this.datePicked = new Date();
        this.fetchSelectFieldData();
        this.fetchMultiSelectData();

        String list = "2,4";

        this.selectedData = this.selectFieldData.get(3);
        this.multiSelectedData = this.getFromMultiSelectData(list);
    }


    public FormModel(String txtField,
                     Boolean chkBox,
                     Date date,
                     int indexOfSelectedData,
                     String indexesOfMultiselect){
        this.textField = txtField;
        this.checkBox = chkBox;
        this.datePicked = date;
        this.fetchMultiSelectData();
        this.fetchSelectFieldData();
        this.selectedData = selectFieldData.get(indexOfSelectedData);
        this.multiSelectedData = this.getFromMultiSelectData(indexesOfMultiselect);
    }

    public void fetchSelectFieldData(){
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
        this.selectFieldData = data;
    }

    public void fetchMultiSelectData(){
        HashMap<String,String> data = new HashMap<>();
        data.put("1","value1");
        data.put("2","value2");
        data.put("5","value3");
        data.put("4","value4");
        data.put("8","value5");
        data.put("6","value6");
        data.put("7","value7");
        this.multiSelectData = data;
    }

    public List<String> getFromMultiSelectData(String indexes ){
        AtomicReference<List<String>> selected = new AtomicReference<>();
        selected.set(new ArrayList<>());
        List<String> list = Arrays.stream(indexes.split(",")).toList();
        list.forEach((index)->{
            selected.get().add(this.multiSelectData.get(index));
        });
        return selected.get();
    }

    public Map<String,Object> render(){
        HashMap<String,Object> _TEMP = new HashMap<>();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat DATE_TEMP = new SimpleDateFormat(pattern);
        _TEMP.put("textField",this.textField);
        _TEMP.put("checkBox",this.checkBox);
        _TEMP.put("selctedData",this.selectedData);
        _TEMP.put("pickedDate",DATE_TEMP.format(this.datePicked));
        _TEMP.put("multiSelectedData",this.multiSelectedData);
        _TEMP.put("multiSelectData",this.multiSelectData);
        _TEMP.put("selectFieldData",this.selectFieldData);
        return _TEMP;
    }

    @Override
    public String toString(){
        return
                "{" +
                    "\"textField\":\"" +this.textField+"\","+
                    "\"checkBox\":\"" +this.checkBox+"\","+
                    "\"selectedData\":"+this.selectedData+","+
                    "\"pickedDate\":" +"\""+this.datePicked+"\","+
                    "\"multiSelectedData\":\""+this.multiSelectedData+"\""+
                "}";
    }
}
