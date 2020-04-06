package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_searchplusl extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchplusl);

        Button btn_calsearchplusl_save=findViewById(R.id.btn_calsearchplusl_save);
        btn_calsearchplusl_save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearchplusl_save=new Intent(MainActivity_cal_searchplusl.this, MainActivity_cal_searchl.class);
                startActivity(intent_btn_calsearchplusl_save);
            }
        });

    }
}
