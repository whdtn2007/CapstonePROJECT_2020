package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_searchl extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchl);

        Button btn_calsearch_plus2=findViewById(R.id.btn_calsearch_plus2);
        btn_calsearch_plus2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_plus2=new Intent(MainActivity_cal_searchl.this, MainActivity_cal_searchplusl.class);
                startActivity(intent_btn_calsearch_plus2);
            }
        });
        Button btn_calsearch_home2=findViewById(R.id.btn_calsearch_home2);
        btn_calsearch_home2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_home2=new Intent(MainActivity_cal_searchl.this, MainActivity_cal_day_lunch.class);
                startActivity(intent_btn_calsearch_home2);
            }
        });

    }
}
