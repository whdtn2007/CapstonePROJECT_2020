package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_selectDis4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_select_dis4);

        Button btn_culture_select_genre4 = findViewById(R.id.btn_culture_select_genre4);

        btn_culture_select_genre4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_select_genre4 = new Intent(MainActivity_culture_selectDis4.this, MainActivity_culture_reviewwrite4.class);
                startActivity(intent_btn_culture_select_genre4);
                //finish();
            }
        });

    }
}
