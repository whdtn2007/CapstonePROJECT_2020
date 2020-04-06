package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_reviewwrite4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_reviewwrite4);

        Button btn_culture_review4_genre = findViewById(R.id.btn_culture_review4_genre);
        btn_culture_review4_genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_review4_genre = new Intent(MainActivity_culture_reviewwrite4.this , MainActivity_culture_selectDis4.class);
                startActivity(intent_btn_culture_review4_genre);//액티비티 이동

            }
        });

        Button btn_culture_review4_save = findViewById(R.id.btn_culture_review4_save);
        btn_culture_review4_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_review4_save = new Intent(MainActivity_culture_reviewwrite4.this , MainActivity_culture_categorymain4.class);
                startActivity(intent_btn_culture_review4_save);//액티비티 이동

            }
        });
    }
}
