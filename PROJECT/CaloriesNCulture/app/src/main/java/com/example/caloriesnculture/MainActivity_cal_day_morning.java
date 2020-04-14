package com.example.caloriesnculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_cal_day_morning extends AppCompatActivity {
    String date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_day_morning);
        //오늘의 날짜
        Intent intent_calday_morning=getIntent();
        date=intent_calday_morning.getStringExtra("today");


        Button btn_caldaym_search=findViewById(R.id.btn_caldaym_search);
        btn_caldaym_search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_caldaym_search=new Intent(MainActivity_cal_day_morning.this, MainActivity_cal_searchm.class);
                startActivity(intent_btn_caldaym_search);
            }
        });

        Button btn_caldaym_back=findViewById(R.id.btn_caldaym_back);
        btn_caldaym_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_caldaym_back=new Intent(MainActivity_cal_day_morning.this, MainActivity_cal_day.class);
                startActivity(intent_btn_caldaym_back);
            }
        });

        ListView calday_listView_morning = (ListView)findViewById(R.id.calday_listView_morning);
        List<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        calday_listView_morning.setAdapter(adapter);

       /* calday_listView_morning.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                //클릭한 아이템의 문자열을 가져옴
                String selected_item = (String)adapterView.getItemAtPosition(position);

                //텍스트뷰에 출력
                selected_item_textview.setText(selected_item);
            }
        });*/


        //리스트뷰에 보여질 아이템을 추가
        list.add("사과");
        list.add("배");
        list.add("귤");
        list.add("바나나");

    }
}
