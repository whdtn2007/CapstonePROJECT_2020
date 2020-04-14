package com.example.caloriesnculture;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity_cal_searchm extends AppCompatActivity {
    Button btnsearch;
    Button btn_calsearch_plus;
    Button btn_calsearch_home;
    EditText txt_calsearch_search;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchm);

        txt_calsearch_search=(EditText)findViewById(R.id.txt_calsearch_search);

        btnsearch = (Button) findViewById(R.id.btn_calsearch_search);
        btnsearch.setOnClickListener(btnListener1);

        btn_calsearch_plus=findViewById(R.id.btn_calsearch_plus);
        btn_calsearch_plus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_plus=new Intent(MainActivity_cal_searchm.this, MainActivity_cal_searchplusm.class);
                startActivity(intent_btn_calsearch_plus);
            }
        });

        btn_calsearch_home=findViewById(R.id.btn_calsearch_home);
        btn_calsearch_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearch_home=new Intent(MainActivity_cal_searchm.this, MainActivity_cal_day_morning.class);
                startActivity(intent_btn_calsearch_home);
            }
        });

    }
    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg1;
        String receiveMsg1;
        String sendMsg2;
        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://192.168.56.1:8080/Cap_Connection_2/join_pra.jsp");//바꿔주세요//http://106.241.33.158:1080/login.jsp
                // 192.168.56.1
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg1 = "foodname="+strings[0]+"&type="+strings[1];
                osw.write(sendMsg1);
                osw.flush();
                if(conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg1 = buffer.toString();

                } else {
                    Log.i("통신 결과", conn.getResponseCode()+"에러");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg1;
        }
    }
    View.OnClickListener btnListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view1) {



        }
    };
}

