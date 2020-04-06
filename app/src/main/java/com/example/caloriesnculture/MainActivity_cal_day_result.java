package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_day_result extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_day_result);

        Button btn_calday_result_back=findViewById(R.id.btn_calday_result_back);
        btn_calday_result_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calday_result_back=new Intent(MainActivity_cal_day_result.this, MainActivity_cal_day.class);
                startActivity(intent_btn_calday_result_back);
            }
        });
    }
}
