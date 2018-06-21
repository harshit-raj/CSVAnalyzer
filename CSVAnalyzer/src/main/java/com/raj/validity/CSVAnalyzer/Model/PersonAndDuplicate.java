package com.raj.validity.CSVAnalyzer.Model;

import java.util.List;

public class PersonAndDuplicate {

    List<Person> personList;
    List<List<Person>> duplicateList;

    public PersonAndDuplicate() {
    }

    public PersonAndDuplicate(List<Person> personList, List<List<Person>> duplicateList) {
        this.personList = personList;
        this.duplicateList = duplicateList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<List<Person>> getDuplicateList() {
        return duplicateList;
    }

    public void setDuplicateList(List<List<Person>> duplicateList) {
        this.duplicateList = duplicateList;
    }

}
