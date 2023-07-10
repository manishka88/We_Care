package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTest extends AppCompatActivity {
    private String[][] packages=
    {
        {"Package 1:Full Body Checkup","","","","999"},
        {"Package 2:Full Body Glucose fasting","","","","999"},
        {"Package 3:Covid-19 Antibody","","","","900"},
        {"Package 4:Thyroid check","","","","970"},
        {"Package 5:Immunity Check","","","","999"}
    };
    private String[] package_details = {
            "Blood Flucose Fasting\n"+"HbA1c\n"+"Iron Studies\n"+"Kidney Function Test\n"+
            "LDH LActate Dehydrogenase,Serum\n"+"Lipid Profile\n"+"Liver Function Test","Blood Glucose Fasting","COVID-19 Antibody-IgG","Thyroid Profile-Total(T3,T4 &TSH Ultra-sensitive)","Complete Hemogram\n"+
            "CRP(C Reactive PRotien) Quantitative,Serum\n"+"IRon Studies\n"+"Kidney Function Test\n"+"Vitamin D Total-25 Hydroxy\n"+"Liver Function Test\n"+"Lipid Profile"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        lst=findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGoToCart=findViewById(R.id.buttonBMGoToCart);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LabTest.this,home.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[] {"line1","line2","line 3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});


        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(LabTest.this,LabTestDetails.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTest.this,CartLab.class));
            }
        });
    }
}