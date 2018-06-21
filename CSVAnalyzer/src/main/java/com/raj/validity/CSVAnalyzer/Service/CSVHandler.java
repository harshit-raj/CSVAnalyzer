package com.raj.validity.CSVAnalyzer.Service;

import com.raj.validity.CSVAnalyzer.Model.Person;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CSVHandler {
    List<Person> parseCSV(MultipartFile csvFile);
}
