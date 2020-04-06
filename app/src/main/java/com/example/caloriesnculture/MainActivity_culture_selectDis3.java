package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_selectDis3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_select_dis3);

        Button btn_culture_select_genre3 = findViewById(R.id.btn_culture_select_genre3);

        btn_culture_select_genre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_select_genre3= new Intent(MainActivity_culture_selectDis3.this, MainActivity_culture_reviewwrite3.class);
                startActivity(intent_btn_culture_select_genre3);
                //finish();
            }
        });

    }
}
