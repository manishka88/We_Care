package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.DatabaseMetaData;

public class Register extends AppCompatActivity {


    EditText edUsename,edmail,edpassword,edcpassword;
    Button b1;
   TextView tv;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsename = findViewById(R.id.editTextRegUsername);
        edpassword= findViewById(R.id.editTextRegPassword);
        edmail= findViewById(R.id.editTextRegEmail);
        edcpassword= findViewById(R.id.editTextRegConfirmPassword);
        b1=findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textViewExistingUser);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,login.class));
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsename.getText().toString();
                String email = edmail.getText().toString();
                String password = edpassword.getText().toString();
                String confirm = edcpassword.getText().toString();
                database db=new database(getApplicationContext(),"healthcare",null,1);

                if(username.length()==0 || password.length()==0 || email.length()==0 || confirm.length()==0){
                    Toast.makeText(Register.this, "Please fill all the details", Toast.LENGTH_SHORT).show();

                }else {
                    if(password.compareTo(confirm)==0){
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(Register.this, "Record  inserted ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,login.class));

                        }
                        else{
                            Toast.makeText(Register.this, "Password must contain atleast 8 characters", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(Register.this, "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }
    public static boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length() < 8){
            return false;
        }else{
            for (int p=0;p<passwordhere.length();p++){
                if(Character.isLetter((passwordhere.charAt(p)))){
                    f1=1;
                }
            }
            for(int r=0;r<passwordhere.length();r++){
                if (Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<passwordhere.length();s++){
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }

    }
}