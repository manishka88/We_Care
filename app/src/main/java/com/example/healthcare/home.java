package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedprefrences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        String username = sharedprefrences.getString("username","").toString();

        Toast.makeText(this, "Welcome "+username, Toast.LENGTH_SHORT).show();
       CardView exit = findViewById(R.id.cardExit);
       exit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SharedPreferences.Editor editor = sharedprefrences.edit();
               editor.clear();
               editor.apply();
               startActivity(new Intent(home.this,login.class));
           }
       });

        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,FindDoctor.class));
            }
        });
        CardView labTest= findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,LabTest.class));
            }
        });
        CardView buyMedicine = findViewById(R.id.cardBuyMedicinet);
        buyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,BuyMedicine.class));
            }
        });
        CardView orderDetails = findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,OrderDetails.class));
            }
        });
        CardView health=findViewById(R.id.cardHealthDoctor);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this,HealthArticles.class));
            }
        });



    }
}