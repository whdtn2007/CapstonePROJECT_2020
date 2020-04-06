package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_day_dinner extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_day_dinner);

        Button btn_caldayd_back=findViewById(R.id.btn_caldayd_back);
        btn_caldayd_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_caldayd_back=new Intent(MainActivity_cal_day_dinner.this, MainActivity_cal_day.class);
                startActivity(intent_btn_caldayd_back);
            }
        });

        Button btn_caldayd_search=findViewById(R.id.btn_caldayd_search);
        btn_caldayd_search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_caldayd_search=new Intent(MainActivity_cal_day_dinner.this, MainActivity_cal_searchd.class);
                startActivity(intent_btn_caldayd_search);
            }
        });

    }
}
