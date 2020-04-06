package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_categorymain1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_categorymain1);

        Button btn_culture_categorymain1_plus=findViewById(R.id.btn_culture_categorymain1_plus);

        btn_culture_categorymain1_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_categorymain1_plus = new Intent(MainActivity_culture_categorymain1.this, MainActivity_culture_reviewwrite1.class);
                startActivity(intent_btn_culture_categorymain1_plus);
            }
        });

        Button btn_culture_categorymain_back=findViewById(R.id.btn_culture_categorymain_back);

        btn_culture_categorymain_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_categorymain_back = new Intent(MainActivity_culture_categorymain1.this, MainActivity_culture_main.class);
                startActivity(intent_btn_culture_categorymain_back);
            }
        });

    }
}
