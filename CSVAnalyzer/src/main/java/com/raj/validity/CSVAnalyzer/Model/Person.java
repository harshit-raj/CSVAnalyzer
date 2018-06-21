package com.raj.validity.CSVAnalyzer.Model;

import javax.annotation.Resource;

@Resource
public class Person {

    String id;
    String firstName;
    String lastName;
    String company;
    String email;
    String address1;
    String address2;
    String zip;
    String city;
    String StateLong;
    String State;
    String Phone;
    int missing = 0;




    public Person(String firstName, String lastName, String company, String email, String address1, String address2,
                  String zip, String city, String stateLong, String state, String phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
        this.city = city;
        StateLong = stateLong;
        State = state;
        Phone = phone;
    }
    public Person(String id, String firstName, String lastName, String company, String email, String address1,
                  String address2, String zip, String city, String stateLong, String state, String phone) {

        if(id.equals("")) {
            this.missing++;
        }
        this.id = id;
        if(firstName.equals("")) {
            this.missing++;
        }
        this.firstName = firstName;
        if(lastName.equals("")) {
            this.missing++;
        }
        this.lastName = lastName;
        if(company.equals("")) {
            this.missing++;
        }
        this.company = company;
        if(email.equals("")) {
            this.missing++;
        }
        this.email = email;
        if(address1.equals("")) {
            this.missing++;
        }
        this.address1 = address1;
        if(address2.equals("")) {
            this.missing++;
        }
        this.address2 = address2;
        if(zip.equals("")) {
            this.missing++;
        }
        this.zip = zip;
        if(city.equals("")) {
            this.missing++;
        }
        this.city = city;
        if(stateLong.equals("")) {
            this.missing++;
        }
        StateLong = stateLong;
        if(state.equals("")) {
            this.missing++;
        }

        State = state;
        if(phone.equals("")) {
            this.missing++;
        }
        Phone = phone;
    }

    public Person(String[] st) {

        this.id = st[0];
        this.firstName = st[1];
        this.lastName = st[2];
        this.company = st[3];
        this.email = st[4];
        this.address1 = st[5];
        this.address2 = st[6];
        this.zip = st[7];
        this.city = st[8];
        StateLong = st[9];
        State = st[10];
        Phone = st[11];
    }




    public int getMissing() {
        return missing;
    }
    public void setMissing(int missing) {
        this.missing = missing;
    }
    public Person() {

    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateLong() {
        return StateLong;
    }
    public void setStateLong(String stateLong) {
        StateLong = stateLong;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    @Override
    public String toString() {
        return "PersonData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
                + ", email=" + email + ", address1=" + address1 + ", address2=" + address2 + ", zip=" + zip + ", city="
                + city + ", StateLong=" + StateLong + ", State=" + State + ", Phone=" + Phone + ", missing=" + missing
                + "]";
    }

    public String compactString() {

        return id +firstName + lastName +  company+ email +  address1 +  address2 + zip +  city +  StateLong +  State +Phone ;
    }
}
