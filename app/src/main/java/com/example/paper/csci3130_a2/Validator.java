/*
 * This is for Assignment2 of Dalhousie University CSCI 3130 Class.
 * Make simple input interface, then check the unit test with Junit.
 *
 * @author Jaewoong Kang
 * @version 1.01
 * @since 2018-06-09
 */

package com.example.paper.csci3130_a2;

import android.app.Activity;
import android.os.Bundle;

public class Validator extends Activity {

    private String passwords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setPasswords(String passwords){
        this.passwords = passwords;
    }

    public String getPasswords(){
        return passwords;
    }

    /**
     * For the testing, temporarily use String variable, inpassword
     * @param inpassword
     * @return 0(Error) / 1(Succeed)
     */
    public int validChecking (String inpassword){
        setPasswords(inpassword);
        if(passwords.length() < 8){
            return 0;
        }
        else if (passwords.equalsIgnoreCase("password")){
            return 0;
        }

        //extra conditions in stage2

        //(less than 13 length)
        else if(passwords.length() > 12){
            return 0;
        }

        //including at lease one of lower/upper case alphabet and number
        else if (!passwords.matches("(.*[A-Z].*)") || !passwords.matches("(.*[a-z].*)") ||
                !passwords.matches("(.*[0-9].*)")){
            return 0;
        }

        //not including whitespace
        else if (passwords.matches("(.*\\s.*)")){
            return 0;
        }
        return 1;
    }
}
