package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_categorymain3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_categorymain3);

        Button btn_culture_categorymain3_plus=findViewById(R.id.btn_culture_categorymain3_plus);

        btn_culture_categorymain3_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_categorymain3_plus = new Intent(MainActivity_culture_categorymain3.this, MainActivity_culture_reviewwrite3.class);
                startActivity(intent_btn_culture_categorymain3_plus);
            }
        });

        Button btn_culture_categorymain3_back=findViewById(R.id.btn_culture_categorymain3_back);

        btn_culture_categorymain3_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_categorymain3_back = new Intent(MainActivity_culture_categorymain3.this, MainActivity_culture_main.class);
                startActivity(intent_btn_culture_categorymain3_back);
            }
        });

    }
}
