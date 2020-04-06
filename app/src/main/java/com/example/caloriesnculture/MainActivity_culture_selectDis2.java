package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_selectDis2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_select_dis2);

        Button btn_culture_select_genre2 = findViewById(R.id.btn_culture_select_genre2);

        btn_culture_select_genre2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_select_genre2 = new Intent(MainActivity_culture_selectDis2.this, MainActivity_culture_reviewwrite2.class);
                startActivity(intent_btn_culture_select_genre2);
                //finish();
            }
        });

    }
}
