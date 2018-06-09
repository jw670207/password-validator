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

    //checking for shorter than 8 length input
    @Test
    public void shorterthan8() {
        tests = "Bb1234";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for longer than 12 length input
    @Test
    public void longerthan12() {
        tests = "Bb12345678910";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for no lowercase
    @Test
    public void lowerCaseCheck() {
        tests = "B12345678";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for no upper case
    @Test
    public void upperCaseCheck() {
        tests = "b12345678";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for no number
    @Test
    public void numberCheck() {
        tests = "ABCDefgh";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for including whitespace
    @Test
    public void whitespaceCheck() {
        tests = "Bb 1234567";
        results = valid.validChecking(tests);
        assertEquals(0,results);
    }

    //checking for valid input
    @Test
    public void pwSucceed() {
        tests = "Bb123456";
        results = valid.validChecking(tests);
        assertEquals(1,results);
    }

}