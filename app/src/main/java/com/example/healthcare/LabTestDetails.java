package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetails extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
   Button buttonAddToCart,buttonBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        tvPackageName = findViewById(R.id.textViewLDPackageName);
        edDetails=findViewById(R.id.editTextLDTextMultiLine);
        tvTotalCost=findViewById(R.id.textViewLDTotalCost);
        edDetails.setKeyListener(null);
        buttonAddToCart = findViewById(R.id.buttonLDAddToCart);
        buttonBack=findViewById(R.id.buttonLDGoBack);


        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost:"+intent.getStringExtra("text3")+"/-");

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetails.this, LabTest.class));
            }
        });
        buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
               String username=sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
               float price=Float.parseFloat(intent.getStringExtra("text3").toString());

                database db=new database(getApplicationContext(),"healthcare",null,1);
                db.addCart(username,product,price,"lab");
                Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestDetails.this,LabTest.class));
//                if(db.checkCart(username,product)==1){
//                    Toast.makeText(LabTestDetails.this, "Product already added", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    db.addCart(username,product,price,"lab");
//                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LabTestDetails.this,LabTest.class));
//                }
            }
        });


    }
}