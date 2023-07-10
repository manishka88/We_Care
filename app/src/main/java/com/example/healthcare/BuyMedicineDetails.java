package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BuyMedicineDetails extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnBack,btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);
        tvPackageName=findViewById(R.id.textViewBMDPackageName);
        edDetails=findViewById(R.id.editTextTextBMDMultiLine);
        edDetails.setKeyListener(null);
        tvTotalCost=findViewById(R.id.textViewBMDTotalCost);
        btnAddToCart=findViewById(R.id.buttonBMDAddToCart);
        btnBack=findViewById(R.id.buttonBMDBackBuy);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost: "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetails.this,BuyMedicine.class));

            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
                float price=Float.parseFloat(intent.getStringExtra("text3").toString());

                database db=new database(getApplicationContext(),"healthcare",null,1);
                db.addCart(username,product,price,"medicine");
                Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicineDetails.this,BuyMedicine.class));
//                if(db.checkCart(username,product)==1){
//                    Toast.makeText(getApplicationContext(), "PRoduct Already added", Toast.LENGTH_SHORT).show();
//                }
//                else{
//
//                    db.addCart(username,product,price,"medicine");
//                    Toast.makeText(getApplicationContext(), "Recorded Inserted to Cart", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(BuyMedicineDetails.this,BuyMedicine.class));
//                }
;            }
        });
    }
}