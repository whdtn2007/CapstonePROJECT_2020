package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity_cal_day extends AppCompatActivity {
    TextView date;
    String day;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_day);
        date=(TextView)findViewById(R.id.txt_calday_date);
        Intent intent_calday_date=getIntent();
        day=intent_calday_date.getStringExtra("today");
        date.setText(day);

        Button btn_calday_menu=findViewById(R.id.btn_calday_menu);
        btn_calday_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calday_menu=new Intent(MainActivity_cal_day.this, MainActivity_cal_main.class);
                startActivity(intent_btn_calday_menu);
            }
        });
        Button btn_calday_morning=findViewById(R.id.btn_calday_morning);
        btn_calday_morning.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calday_morning=new Intent(MainActivity_cal_day.this, MainActivity_cal_day_morning.class);
                intent_btn_calday_morning.putExtra("today",day);
                startActivity(intent_btn_calday_morning);
            }
        });
        Button btn_calday_lunch=findViewById(R.id.btn_calday_lunch);
        btn_calday_lunch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calday_lunch=new Intent(MainActivity_cal_day.this, MainActivity_cal_day_lunch.class);
                startActivity(intent_btn_calday_lunch);
            }
        });
        Button btn_calday_dinner=findViewById(R.id.btn_calday_dinner);
        btn_calday_dinner.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calday_dinner=new Intent(MainActivity_cal_day.this, MainActivity_cal_day_dinner.class);
                startActivity(intent_btn_calday_dinner);
            }
        });
        Button btn_calday_result=findViewById(R.id.btn_calday_result);
        btn_calday_result.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calday_result=new Intent(MainActivity_cal_day.this, MainActivity_cal_day_result.class);
                startActivity(intent_btn_calday_result);
            }
        });


    }
}
