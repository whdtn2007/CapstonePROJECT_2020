package com.example.caloriesnculture;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;

public class MainActivity_cal_searchplusd extends AppCompatActivity {

    String foodname_d="";
    String day="";
    String nickdata="";
    SharedPreferences pref;

    TextView txt_calsearchplus_foonamed2,txt_calsearchplusd_kcal2;
    EditText txt_calsearchplus5;
    Button btn_calsearchplusd_save2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_searchplusd);

        txt_calsearchplus_foonamed2=(TextView)findViewById(R.id.txt_calsearchplus_foonamed2);
        pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
        foodname_d=pref.getString("foodname_d","error");
        txt_calsearchplus_foonamed2.setText(foodname_d);

        txt_calsearchplus5=(EditText)findViewById(R.id.txt_calsearchplus5);

        pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
        day=pref.getString("inputdate_cal","error");
        pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
        nickdata=pref.getString("nickname","error");

        btn_calsearchplusd_save2=(Button)findViewById(R.id.btn_calsearchplusd_save2);
        btn_calsearchplusd_save2.setOnClickListener(btnListener1);

        txt_calsearchplusd_kcal2=(TextView)findViewById(R.id.txt_calsearchplusd_kcal2);
        try {
            String result = new CustomTask().execute("0", foodname_d,"0","0","dinner_kcal").get();

            if (result.equals("ok")) {
                Toast.makeText(MainActivity_cal_searchplusd.this, result + "연결ok", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity_cal_searchplusd.this, result + "연결ok", Toast.LENGTH_SHORT).show();
                /*StringTokenizer st = new StringTokenizer(result, "&");
                int n = st.countTokens();
                String[] array = new String[st.countTokens()];
                int j = 0;
                while (st.hasMoreElements()) {
                    array[j++] = st.nextToken();
                }
                String a = "";
                String b = "";
                String stst = Integer.toString(n);
                for (int i = 0; i < n; i++) {
                    list_calday_listView_morning.add(i, array[i]);
                }

                adapter_calday_listView_morning.notifyDataSetChanged();*?
                 */
                String kcal_morning=result;
                txt_calsearchplusd_kcal2.setText(kcal_morning);

            }
        } catch (Exception e) {
        }


       /* Button btn_calsearchplusd_save2=findViewById(R.id.btn_calsearchplusd_save2);
        btn_calsearchplusd_save2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_btn_calsearchplusd_save2=new Intent(MainActivity_cal_searchplusd.this, MainActivity_cal_searchd.class);
                startActivity(intent_btn_calsearchplusd_save2);
            }
        });*/

    }
    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg1, receiveMsg1;
        ResultSet rs;
        String sendMsg2;
        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://106.241.33.158:1080/AddFoodD.jsp");//바꿔주세요//"http://192.168.56.1:8080/Cap_Connection_2/join_pra.jsp"
                // "http://106.241.33.158:1080/join.jsp"
                //
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg1 = "search_mnick="+strings[0]+"&search_mname="+strings[1]+"&search_mdate="+strings[2]+"&search_mgram="+strings[3]+"&type="+strings[4];
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

                case R.id.btn_calsearchplusd_save2:

                    String search_m_g = txt_calsearchplus5.getText().toString();
                    //Toast.makeText(MainActivity_cal_searchplusm.this, search_mdnick+foodnamem+search_mdate+search_m_g, Toast.LENGTH_SHORT).show();


                    try {
                        String result = new CustomTask().execute(nickdata,foodname_d,day,search_m_g,"searchd_add").get();

                        if (result.equals("ok")) {

                            Toast.makeText(MainActivity_cal_searchplusd.this, "연결ok", Toast.LENGTH_SHORT).show();
                            Intent intent_btn_calsearchplus_save=new Intent(MainActivity_cal_searchplusd.this, MainActivity_cal_searchd.class);
                            startActivity(intent_btn_calsearchplus_save);

                        }
                    } catch (Exception e) {
                    }
                    ;
                    break;

            }
        }
    };
}
