package com.example.caloriesnculture;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_main extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_logout=findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_logout=new Intent(MainActivity_main.this, MainActivity_login.class);
                startActivity(intent_btn_logout);
            }
        });

        Button btn_main_calorie=findViewById(R.id.btn_main_calorie);
        btn_main_calorie.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_main_calorie=new Intent(MainActivity_main.this, MainActivity_cal_main.class);
                startActivity(intent_btn_main_calorie);
            }
        });


        Button btn_edit=findViewById(R.id.btn_edit);
        btn_edit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_edit=new Intent(MainActivity_main.this, MainActivity_join.class);
                startActivity(intent_btn_edit);
            }
        });
        Button btn_main_culture=findViewById(R.id.btn_main_culture);
        btn_main_culture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_main_culture=new Intent(MainActivity_main.this, MainActivity_culture_main.class);
                startActivity(intent_btn_main_culture);
            }
        });

    }

}
