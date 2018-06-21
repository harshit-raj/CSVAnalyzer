package com.raj.validity.CSVAnalyzer.Service;

import com.raj.validity.CSVAnalyzer.Model.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class CSVHandlerImpl implements CSVHandler {
    @Override
    public List<Person> parseCSV(MultipartFile csvFile) {
        List<Person> personList;
        try {
            CSVParser data = CSVFormat.EXCEL.withHeader().parse(new InputStreamReader(csvFile.getInputStream()));
            personList = StreamSupport.stream(data.spliterator(),false)
                    .map(this :: parseFields)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            personList =null;
            e.printStackTrace();
        }


        return personList;
    }

    private Person parseFields(CSVRecord rec){
        Person p = new Person(rec.get(0),rec.get(1),rec.get(2),rec.get(3),rec.get(4),rec.get(5),rec.get(6),rec.get(7),rec.get(8),rec.get(9),rec.get(10),rec.get(11));
        return p;


    }
}
