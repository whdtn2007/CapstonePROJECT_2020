package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_cal_main extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_main);


        Button btn_calmain_menu=findViewById(R.id.btn_calmain_menu);
        btn_calmain_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calmain_menu=new Intent(MainActivity_cal_main.this, MainActivity_main.class);
                startActivity(intent_btn_calmain_menu);
            }
        });

        CalendarView calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                Toast.makeText(MainActivity_cal_main.this, "" + year + "/" +
                        (month + 1) + "/" + dayOfMonth,Toast.LENGTH_LONG ).show();
                Intent intent= new Intent(MainActivity_cal_main.this, MainActivity_cal_day.class);
                startActivity(intent);
            }
        });


    }
}
