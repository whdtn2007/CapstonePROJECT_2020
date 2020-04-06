package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_reviewwrite3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_reviewwrite3);

        Button btn_culture_review3_genre = findViewById(R.id.btn_culture_review3_genre);
        btn_culture_review3_genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_review3_genre = new Intent(MainActivity_culture_reviewwrite3.this , MainActivity_culture_selectDis3.class);
                startActivity(intent_btn_culture_review3_genre);//액티비티 이동

            }
        });

        Button btn_culture_review3_save = findViewById(R.id.btn_culture_review3_save);
        btn_culture_review3_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_review3_save = new Intent(MainActivity_culture_reviewwrite3.this , MainActivity_culture_categorymain3.class);
                startActivity(intent_btn_culture_review3_save);//액티비티 이동

            }
        });
    }
}
