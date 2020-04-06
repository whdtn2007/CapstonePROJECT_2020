package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_day_lunch extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_day_lunch);


        Button btn_caldayl_back=findViewById(R.id.btn_caldayl_back);
        btn_caldayl_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_caldayl_back=new Intent(MainActivity_cal_day_lunch.this, MainActivity_cal_day.class);
                startActivity(intent_btn_caldayl_back);
            }
        });

        Button btn_caldayl_search=findViewById(R.id.btn_caldayl_search);
        btn_caldayl_search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_caldayl_search=new Intent(MainActivity_cal_day_lunch.this, MainActivity_cal_searchl.class);
                startActivity(intent_btn_caldayl_search);
            }
        });
    }
}
