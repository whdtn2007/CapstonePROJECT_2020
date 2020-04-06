package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_searchm extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchm);

        Button btn_calsearch_plus=findViewById(R.id.btn_calsearch_plus);
        btn_calsearch_plus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_plus=new Intent(MainActivity_cal_searchm.this, MainActivity_cal_searchplusm.class);
                startActivity(intent_btn_calsearch_plus);
            }
        });
        Button btn_calsearch_home=findViewById(R.id.btn_calsearch_home);
        btn_calsearch_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_home=new Intent(MainActivity_cal_searchm.this, MainActivity_cal_day_morning.class);
                startActivity(intent_btn_calsearch_home);
            }
        });

    }
}
