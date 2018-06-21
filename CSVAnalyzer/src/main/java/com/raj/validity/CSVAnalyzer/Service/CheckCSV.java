package com.raj.validity.CSVAnalyzer.Service;

import com.raj.validity.CSVAnalyzer.Model.Person;

import java.util.List;

public interface CheckCSV {
    List<List<Person>> getDuplicate(List<Person> personList, double threshold);
}
