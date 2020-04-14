package com.example.caloriesnculture;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;


public class MainActivity_join extends AppCompatActivity {
    EditText join_id, join_pw;
    Button btn_join,join_idbtn;
    RadioGroup rg;
    ArrayAdapter <CharSequence> adspin1,adspin2,adspin3;
    Spinner sp; String text="";//년도변수
    Spinner sp2; String text2="";//년도변수
    Spinner sp3; String text3="";//년도변수
    String rbtext="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        sp = (Spinner)findViewById(R.id.spinner_birth);
        sp2 = (Spinner)findViewById(R.id.spinner_height);
        sp3 = (Spinner)findViewById(R.id.spinner_weight);

        join_id = (EditText) findViewById(R.id.join_id);
        join_pw = (EditText) findViewById(R.id.join_pw);
        btn_join = (Button) findViewById(R.id.btn_join);
        btn_join.setOnClickListener(btnListener1);
        join_idbtn = (Button) findViewById(R.id.join_idbtn);
        join_idbtn.setOnClickListener(btnListener1);


        adspin1 = ArrayAdapter.createFromResource(this, R.array.birth, android.R.layout.simple_spinner_dropdown_item);

        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adspin1);

        adspin2 = ArrayAdapter.createFromResource(this, R.array.height, android.R.layout.simple_spinner_dropdown_item);

        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adspin2);

        adspin3 = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_dropdown_item);

        adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adspin3);

       /*Button btn_join=findViewById(R.id.btn_join);
        btn_join.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_join=new Intent(MainActivity_join.this, MainActivity_login.class);
                startActivity(intent_btn_join);
            }
        });*/



        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                text=adspin1.getItem(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                text2=adspin2.getItem(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                text3=adspin3.getItem(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






    }
    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg1, receiveMsg1;
        ResultSet rs;
        String sendMsg2;
        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://106.241.33.158:1080/join.jsp");//바꿔주세요//http://192.168.56.1:8080/Cap_Connection_2/join_pra.jsp"
                // 192.168.56.1
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg1 = "id="+strings[0]+"&pwd="+strings[1]+"&gender="+strings[2]+"&birth="+strings[3]+"&height="+strings[4]+"&weight="+strings[5]+"&type="+strings[6];
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

            int id = rg.getCheckedRadioButtonId();



            switch (view1.getId()) {
                case R.id.btn_join : // 회원가입
                    RadioButton rb = (RadioButton) findViewById(id);
                    rbtext=rb.getText().toString();
                    String joinid = join_id.getText().toString();
                    String joinpwd = join_pw.getText().toString();

                    try {
                        String result  = new CustomTask().execute(joinid,joinpwd,rbtext,text,text2,text3,"join").get();
                        if(result.equals("idd")) {
                            Toast.makeText(MainActivity_join.this,joinid+joinpwd+rbtext+text+text2+text3,Toast.LENGTH_SHORT).show();
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

                        String result  = new CustomTask().execute(joinid1,"0","0","0","0","0","over").get();
                        if(result.equals("idd")) {
                            Toast.makeText(MainActivity_join.this,"중복된ID입니다",Toast.LENGTH_SHORT).show();
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
