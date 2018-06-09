package com.example.paper.csci3130_a2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    int results;
    String tests;
    Validator valid = new Validator();

    //checking for the case input "password"
    @Test
    public void pwErrorCheck() {
        tests = "pasSwOrd";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for less than 8 length input
    @Test
    public void lengthErrorCheck() {
        tests = "1234567";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for valid input
    @Test
    public void pwSucceed() {
        tests = "12345678";
        results = valid.validChecking(tests);
        assertEquals(1,results);
    }

}