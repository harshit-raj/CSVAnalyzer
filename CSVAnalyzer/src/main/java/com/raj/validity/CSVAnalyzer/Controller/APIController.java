package com.raj.validity.CSVAnalyzer.Controller;

import com.raj.validity.CSVAnalyzer.Model.Person;
import com.raj.validity.CSVAnalyzer.Service.CSVHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    CSVHandler csvHandler;


    @RequestMapping("/uploadFile")
    List<Person> upload (@RequestParam("file")MultipartFile mpf){
        List<Person> personList = csvHandler.parseCSV(mpf);
        return  personList;

    }

}
