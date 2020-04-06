package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_reviewwrite2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_reviewwrite2);

        Button btn_culture_review2_genre = findViewById(R.id.btn_culture_review2_genre);
        btn_culture_review2_genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentbtn_culture_review2_genre = new Intent(MainActivity_culture_reviewwrite2.this , MainActivity_culture_selectDis2.class);
                startActivity(intentbtn_culture_review2_genre);//액티비티 이동

            }
        });

        Button btn_culture_review2_save = findViewById(R.id.btn_culture_review2_save);
        btn_culture_review2_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_review2_save = new Intent(MainActivity_culture_reviewwrite2.this , MainActivity_culture_categorymain2.class);
                startActivity(intent_btn_culture_review2_save);//액티비티 이동

            }
        });
    }
}
