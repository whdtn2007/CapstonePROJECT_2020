package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_searchd extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchd);

        Button btn_calsearch_plus3=findViewById(R.id.btn_calsearch_plus3);
        btn_calsearch_plus3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_plus3=new Intent(MainActivity_cal_searchd.this, MainActivity_cal_searchplusd.class);
                startActivity(intent_btn_calsearch_plus3);
            }
        });
        Button btn_calsearch_home3=findViewById(R.id.btn_calsearch_home3);
        btn_calsearch_home3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_home3=new Intent(MainActivity_cal_searchd.this, MainActivity_cal_day_dinner.class);
                startActivity(intent_btn_calsearch_home3);
            }
        });

    }
}
