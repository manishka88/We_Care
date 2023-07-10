package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    private String[][] doctor_details1= {
            {"Doctor NAme : Ajit Saste", "Hospital Address:Pimpri", "Exp:Syrs", "Mobile No:993889933", "600"},
            {"Doctor NAme : PRaseas bedb","Hospital Address:Nigdi","EXp:15yrs","Mobile No:82787397","900"},
            {"Doctor NAme : Swapnil KAli","Hospital address:Pune","EXp:8yrs","Mobile No:83983347","789"},
            {"Doctor NAme : Deepash Deshmukh","Hospital address:chindad","EXp:6yrs","Mobile No:7725155241","456"},
            {"Doctor NAme : Ashok Panda","Hospital address:Katraj","EXp:7yrs","Mobile No:789456122","800"}
    };
    private String[][] doctor_details2= {
            {"Doctor NAme : Ajit Saste", "Hospital Address:Pimpri", "Exp:Syrs", "Mobile No:993889933", "600"},
            {"Doctor NAme : PRaseas bedb","Hospital Address:Nigdi","EXp:15yrs","Mobile No:82787397","900"},
            {"Doctor NAme : Swapnil KAli","Hospital address:Pune","EXp:8yrs","Mobile No:83983347","789"},
            {"Doctor NAme : Deepash Deshmukh","Hospital address:chindad","EXp:6yrs","Mobile No:7725155241","456"},
            {"Doctor NAme : Ashok Panda","Hospital address:Katraj","EXp:7yrs","Mobile No:789456122","800"}
    };
    private String[][] doctor_details3= {
            {"Doctor NAme : Ajit Saste", "Hospital Address:Pimpri", "Exp:Syrs", "Mobile No:993889933", "600"},
            {"Doctor NAme : PRaseas bedb","Hospital Address:Nigdi","EXp:15yrs","Mobile No:82787397","900"},
            {"Doctor NAme : Swapnil KAli","Hospital address:Pune","EXp:8yrs","Mobile No:83983347","789"},
            {"Doctor NAme : Deepash Deshmukh","Hospital address:chindad","EXp:6yrs","Mobile No:7725155241","456"},
            {"Doctor NAme : Ashok Panda","Hospital address:Katraj","EXp:7yrs","Mobile No:789456122","800"}
    };
    private String[][] doctor_details4= {
            {"Doctor NAme : Ajit Saste", "Hospital Address:Pimpri", "Exp:Syrs", "Mobile No:993889933", "600"},
            {"Doctor NAme : PRaseas bedb","Hospital Address:Nigdi","EXp:15yrs","Mobile No:82787397","900"},
            {"Doctor NAme : Swapnil KAli","Hospital address:Pune","EXp:8yrs","Mobile No:83983347","789"},
            {"Doctor NAme : Deepash Deshmukh","Hospital address:chindad","EXp:6yrs","Mobile No:7725155241","456"},
            {"Doctor NAme : Ashok Panda","Hospital address:Katraj","EXp:7yrs","Mobile No:789456122","800"}
    };
    private String[][] doctor_details5= {
            {"Doctor NAme : Ajit Saste", "Hospital Address:Pimpri", "Exp:Syrs", "Mobile No:993889933", "600"},
            {"Doctor NAme : PRaseas bedb","Hospital Address:Nigdi","EXp:15yrs","Mobile No:82787397","900"},
            {"Doctor NAme : Swapnil KAli","Hospital address:Pune","EXp:8yrs","Mobile No:83983347","789"},
            {"Doctor NAme : Deepash Deshmukh","Hospital address:chindad","EXp:6yrs","Mobile No:7725155241","456"},
            {"Doctor NAme : Ashok Panda","Hospital address:Katraj","EXp:7yrs","Mobile No:789456122","800"}
    };


    TextView t1;
    Button b1;
    String[][] doctor_details = {};
    ArrayList  list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        t1=findViewById(R.id.textViewDDTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        t1.setText(title);
        b1=findViewById(R.id.ButtonBack);
        if (title.compareTo("Family Physicians")==0){
            doctor_details=doctor_details1;
        }
        else if (title.compareTo("Dietician")==0) {
            doctor_details=doctor_details2;
        }
        else if (title.compareTo("Dentist")==0) {
            doctor_details=doctor_details3;
        }
        else if (title.compareTo("Surgeon")==0) {
            doctor_details=doctor_details4;
        }
        else doctor_details=doctor_details5;


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DoctorDetails.this,FindDoctor.class));

            }
        });
        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","cons fees:"+doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line 3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetails.this,BookAppointment.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][2]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });
    }
}