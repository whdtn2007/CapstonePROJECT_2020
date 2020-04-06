package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_main);

        Button btn_culture_main_plus = findViewById(R.id.btn_culture_main_plus);

        btn_culture_main_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_main_plus = new Intent(MainActivity_culture_main.this , MainActivity_culture_addculture.class);
                startActivity(intent_btn_culture_main_plus);//액티비티 이동
                //finish();
            }
        });

        Button btn_culture_main_back = findViewById(R.id.btn_culture_main_back);

        btn_culture_main_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_main_back =new Intent(MainActivity_culture_main.this , MainActivity_main.class);
                startActivity(intent_btn_culture_main_back);
                //finish();
            }
        });

        Button btn_culrue_main_movie = findViewById(R.id.btn_culrue_main_movie);

        btn_culrue_main_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culrue_main_movie =new Intent(MainActivity_culture_main.this , MainActivity_culture_categorymain1.class);
                startActivity(intent_btn_culrue_main_movie);
                //finish();
            }
        });
        Button btn_culrue_main_book = findViewById(R.id.btn_culrue_main_book);

        btn_culrue_main_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culrue_main_book =new Intent(MainActivity_culture_main.this , MainActivity_culture_categorymain2.class);
                startActivity(intent_btn_culrue_main_book);
                //finish();
            }
        });
        Button btn_culrue_main_trip = findViewById(R.id.btn_culrue_main_trip);

        btn_culrue_main_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culrue_main_trip =new Intent(MainActivity_culture_main.this , MainActivity_culture_categorymain3.class);
                startActivity(intent_btn_culrue_main_trip);
                //finish();
            }
        });
        Button btn_culrue_main_diary = findViewById(R.id.btn_culrue_main_diary);

        btn_culrue_main_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culrue_main_diary =new Intent(MainActivity_culture_main.this , MainActivity_culture_categorymain4.class);
                startActivity(intent_btn_culrue_main_diary);
                //finish();
            }
        });

    }
}
