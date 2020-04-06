package com.example.caloriesnculture;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity_join extends AppCompatActivity {
    EditText join_id, join_pw;
    Button btn_join,join_idbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_id = (EditText) findViewById(R.id.join_id);
        join_pw = (EditText) findViewById(R.id.join_pw);
        btn_join = (Button) findViewById(R.id.btn_join);
        btn_join.setOnClickListener(btnListener1);
        join_idbtn = (Button) findViewById(R.id.join_idbtn);
        join_idbtn.setOnClickListener(btnListener1);

       /*Button btn_join=findViewById(R.id.btn_join);
        btn_join.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_join=new Intent(MainActivity_join.this, MainActivity_login.class);
                startActivity(intent_btn_join);
            }
        });*/
    }
    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg1, receiveMsg1;
        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://106.241.33.158:1080/data.jsp");//바꿔주세요
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg1 = "id="+strings[0]+"&pwd="+strings[1]+"&type="+strings[2];
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

            switch (view1.getId()) {
                case R.id.btn_join : // 회원가입
                    String joinid = join_id.getText().toString();
                    String joinpwd = join_pw.getText().toString();

                    try {
                        String result  = new CustomTask().execute(joinid,joinpwd,"join").get();
                        if(result.equals("idd")) {
                            Toast.makeText(MainActivity_join.this,"ID중복체크를 진행해주세요",Toast.LENGTH_SHORT).show();
                            join_id.setText("");
                            join_pw.setText("");
                        } else if(result.equals("ok")) {
                            join_id.setText("");
                            join_pw.setText("");
                            Toast.makeText(MainActivity_join.this,"회원가입을 축하합니다.",Toast.LENGTH_SHORT).show();
                            Intent intent_btn_join= new Intent(MainActivity_join.this, MainActivity_login.class);
                            startActivity(intent_btn_join);
                            finish();
                        }
                    }catch (Exception e) {}
                    break;
                case R.id.join_idbtn : // 중복체크

                    String joinid1= join_id.getText().toString();
                    String joinpwd1 = join_pw.getText().toString();

                    try {

                        String result  = new CustomTask().execute(joinid1,joinpwd1,"over").get();
                        if(result.equals("idd")) {
                            Toast.makeText(MainActivity_join.this,"존재하는 아이디입니다.",Toast.LENGTH_SHORT).show();
                            join_id.setText("");

                        }
                        else if(result.equals("false")) {
                            Toast.makeText(MainActivity_join.this,"가입할 ID를 입력하세요",Toast.LENGTH_SHORT).show();

                        }else if(result.equals("ok")) {
                            Toast.makeText(MainActivity_join.this,"사용가능한 ID입니다",Toast.LENGTH_SHORT).show();

                        }
                    }catch (Exception e) {}
                    break;

            }
        }
    };
}
