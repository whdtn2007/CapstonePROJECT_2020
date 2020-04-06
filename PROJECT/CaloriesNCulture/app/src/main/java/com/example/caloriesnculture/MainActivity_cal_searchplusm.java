package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_searchplusm extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchplusm);

        Button btn_calsearchplus_save=findViewById(R.id.btn_calsearchplus_save);
        btn_calsearchplus_save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearchplus_save=new Intent(MainActivity_cal_searchplusm.this, MainActivity_cal_searchm.class);
                startActivity(intent_btn_calsearchplus_save);
            }
        });

    }
}
