package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_searchplusd extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchplusd);

        Button btn_calsearchplusd_save2=findViewById(R.id.btn_calsearchplusd_save2);
        btn_calsearchplusd_save2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearchplusd_save2=new Intent(MainActivity_cal_searchplusd.this, MainActivity_cal_searchd.class);
                startActivity(intent_btn_calsearchplusd_save2);
            }
        });

    }
}
