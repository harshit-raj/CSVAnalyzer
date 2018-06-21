package com.raj.validity.CSVAnalyzer.Controller;

import com.raj.validity.CSVAnalyzer.Model.Person;
import com.raj.validity.CSVAnalyzer.Model.PersonAndDuplicate;
import com.raj.validity.CSVAnalyzer.Service.CSVHandler;
import com.raj.validity.CSVAnalyzer.Service.CheckCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    CSVHandler csvHandler;

    @Autowired
    CheckCSV checkCSV;


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    PersonAndDuplicate upload (@RequestParam("file")MultipartFile mpf, @RequestParam("threshold")int threshold){
        List<Person> personList = csvHandler.parseCSV(mpf);
        List<List<Person>> dupList = checkCSV.getDuplicate(personList,threshold);
        PersonAndDuplicate personAndDuplicate = new PersonAndDuplicate(personList,dupList);
        return  personAndDuplicate;

    }

}
