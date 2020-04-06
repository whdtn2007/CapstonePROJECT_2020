package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_culture_addculture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_addculture);

        Button btn_culture_addculture_save = findViewById(R.id.btn_culture_addculture_save);

        btn_culture_addculture_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_btn_culture_addculture_save =new Intent(MainActivity_culture_addculture.this , MainActivity_culture_main.class);
                startActivity(intent_btn_culture_addculture_save);
                //finish();
            }
        });
    }
}
