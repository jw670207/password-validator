/*
 * This is for Assignment2 of Dalhousie University CSCI 3130 Class.
 * Make simple input interface, then check the unit test with Junit.
 *
 * Checking Order
 *  1. Longer than 8 characters
 *  2. Not same with password
 *  3. Shorter than 13 characters
 *  4. Contain at least one of Lower, Upper case and number
 *  5. Not contain a whitespace
 *
 *  Add Espresso UI test
 *
 * @author Jaewoong Kang
 * @version 1.03
 * @since 2018-06-09
 */

package com.example.paper.csci3130_a2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Validator extends Activity {

    private String passwords;
    private EditText pwInput;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.validator_main);

        pwInput = findViewById(R.id.pwET);
        submitButton = findViewById(R.id.submitBT);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPasswords(pwInput.getText().toString());

                if (validChecking(passwords) == 0){
                    Toast.makeText(getApplicationContext(), "This password is valid",Toast.LENGTH_SHORT).show();
                }
                else if (validChecking(passwords) == 1){
                    Toast.makeText(getApplicationContext(), "Password must be longer than 8 characters",Toast.LENGTH_SHORT).show();
                }
                else if (validChecking(passwords) == 2){
                    Toast.makeText(getApplicationContext(), "Password must not be 'password'",Toast.LENGTH_SHORT).show();
                }
                else if (validChecking(passwords) == 3){
                    Toast.makeText(getApplicationContext(), "Password must be shorter than 13 characters",Toast.LENGTH_SHORT).show();
                }
                else if (validChecking(passwords) == 4){
                    Toast.makeText(getApplicationContext(), "Password must contain at least one of upper, lower case and number",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password must not contain a whitespace",Toast.LENGTH_SHORT).show();
                }
            }
        });

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
     * @return 0(Succeed) / else(Error)
     */
    public int validChecking (String inpassword){
        setPasswords(inpassword);
        if(passwords.length() < 8){
            return 1;
        }
        else if (passwords.equalsIgnoreCase("password")){
            return 2;
        }

        //extra conditions in stage2

        //(less than 13 length)
        else if(passwords.length() > 12){
            return 3;
        }

        //including at lease one of lower/upper case alphabet and number
        else if (!passwords.matches("(.*[A-Z].*)") || !passwords.matches("(.*[a-z].*)") ||
                !passwords.matches("(.*[0-9].*)")){
            return 4;
        }

        //not including whitespace
        else if (passwords.matches("(.*\\s.*)")){
            return 5;
        }
        return 0;
    }
}
