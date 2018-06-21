package com.raj.validity.CSVAnalyzer.Service;

import com.raj.validity.CSVAnalyzer.Model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class CheckCSVImplTest {
    CheckCSVImpl csi;

    @Before
    public void setUp() throws Exception {
        csi = new CheckCSVImpl();
        Person p1 = new Person("1","Jhon","Doe","Validity","jhon@validity.com","Boston","","02115","Boston","Mass","MA","123-456-7890");
        Person p2 = new Person("1","Jhon","Doe","Validity","jhon@validity.com","Boston","","02115","Boston","Mass","MA","123-456-7890");
        Person p3 = new Person("1","Jhon","","Validity","jhon@validity.com","Boston","","02115","Boston","Mass","MA","123-456-7890");
        Person p4 = new Person("1","Jhon","Doe","Validity","jhon@google.com","Boston","","02115","Boston","Mass","MA","123-456-7890");
        Person p5 = new Person("1","Jhon","Doe","Validity","jhon@google.com","Boston","","02115","Boston","Mass","MA","123-456-0987");
    }

    @Test
    public void test1(){
        Assert.assertEquals(0,csi.levenDist("Hello","Hello"),0.000001);
        Assert.assertEquals(25,csi.levenDist("ABCD","ABC"),0.000001);
        Assert.assertEquals(0,csi.levenDist("ABCD","abcd"),0.000001);


    }
    @Test
    public void test2(){
        Person p1 = new Person("1","Jhon","Doe","Validity","jhon@validity.com","Boston","","02115","Boston","Mass","MA","123-456-7890");
        Person p2 = new Person("1","Jhon","Doe","Validity","jhon@validity.com","Boston","","02115","Boston","Mass","MA","123-456-7890");
        Assert.assertEquals(0,csi.difPercent(p1,p2),0.000001);
        Person p3 = new Person("1","Jhon","Doe","Validity","jhon@google.com","Boston","","02115","Boston","Mass","MA","123-456-06543");
        Assert.assertTrue(csi.difPercent(p1,p3)>0);
    }
}