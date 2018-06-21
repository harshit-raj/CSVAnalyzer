package com.raj.validity.CSVAnalyzer.Service;

import com.raj.validity.CSVAnalyzer.Model.Person;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CheckCSVImpl implements CheckCSV {
    @Override
    public List<List<Person>> getDuplicate(List<Person> personList) {
        List<List<Person>> dupList = new ArrayList<List<Person>>();
        for(int i = 0; i<personList.size()-1;i++){
            boolean hasDuplicates = false;
            List<Person> duplicates = new ArrayList<Person>();
            for (int j = i+1; j<personList.size();j++){
                float n = difPercent(personList.get(i),personList.get(j));
                if(n<50) {
                    if(!hasDuplicates){
                        duplicates.add(personList.get(i));
                        hasDuplicates = true;
                    }
                    duplicates.add(personList.get(j));

                }
            }
            if(hasDuplicates){
                dupList.add(duplicates);
            }

        }

        return dupList;    }

    public float difPercent(Person pd1, Person pd2) {
        float difPercent = 0;
        int difCount = 10;
        if(levenDist(pd1.getEmail(),pd2.getEmail())==0){
            return 0; //assuming identical
        }
        else{
            //difCount++;
            difPercent += levenDist(pd1.getEmail(),pd2.getEmail());
            if(levenDist(pd1.getPhone(),pd2.getPhone())==0){
                return 0; //assuming identical

            }
            else{
                //difCount++;
                difPercent = (difPercent + levenDist(pd1.getPhone(),pd2.getPhone()));
                difPercent = (difPercent + levenDist(pd1.getFirstName(),pd2.getFirstName()));
                difPercent = (difPercent + levenDist(pd1.getLastName(),pd2.getLastName()));
                difPercent = (difPercent + levenDist(pd1.getCompany(),pd2.getCompany()));
                if(!(pd1.getAddress1() == "" || pd2.getAddress1()== "")) {
                    difPercent = (difPercent + levenDist(pd1.getAddress1(), pd2.getAddress1()));
                }
                else{
                    difCount--;
                }
                if(!(pd1.getAddress2() == "" || pd2.getAddress2()== "")){
                    difPercent = (difPercent + levenDist(pd1.getAddress2(),pd2.getAddress2()));
                }
                else{
                    difCount--;
                }
                if(!(pd1.getZip() == "" || pd2.getZip()== "")) {
                    difPercent = (difPercent + levenDist(pd1.getZip(), pd2.getZip()));
                }
                else{
                    difCount--;
                }
                if(!(pd1.getState() == "" || pd2.getState()== "")) {
                    difPercent = (difPercent + levenDist(pd1.getState(), pd2.getState()));
                }
                else{
                    difCount--;
                }

                difPercent /= difCount;

            }
        }
        return difPercent;
    }



    public float levenDist(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        float d = StringUtils.getLevenshteinDistance(s1,s2);
        int maxLength = (s1.length()>s2.length())?s1.length():s2.length(); //using max length to keep pecent value within 100%

        float result = (d/maxLength) *100;

        return result;

    }

}
