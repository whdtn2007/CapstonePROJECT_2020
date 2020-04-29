package com.example.caloriesnculture;

import androidx.appcompat.app.AppCompatActivity;

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

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.StringTokenizer;

public class MainAcivity_cal_aditl extends AppCompatActivity {

    SharedPreferences pref;
    String foodname_l_edit="";
    String day="";
    String nickdata="";
    Button btn_calsearchplus_save3;
    TextView txt_calsearchplus_fooname3,txt_calsearchplus_kcal3;
    EditText txt_calsearchplus2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_aditl);

        btn_calsearchplus_save3 = (Button) findViewById(R.id.btn_calsearchplus_save3);
        btn_calsearchplus_save3.setOnClickListener(btnListener1);
        txt_calsearchplus_fooname3 = (TextView) findViewById(R.id.txt_calsearchplus_fooname3);
        txt_calsearchplus_kcal3 = (TextView) findViewById(R.id.txt_calsearchplus_kcal3);
        txt_calsearchplus2 = (EditText) findViewById(R.id.txt_calsearchplus2);

        pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
        foodname_l_edit=pref.getString("foodname_l_edit","error");

        pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
        day=pref.getString("inputdate_cal","error");

        pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
        nickdata=pref.getString("nickname","error");


        try {
            String result = new CustomTask().execute("0", foodname_l_edit,"0","0","lunch_edit_kcal").get();

            if (result.equals("ok")) {
                Toast.makeText(MainAcivity_cal_aditl.this, result + "연결ok", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainAcivity_cal_aditl.this, result + "연결ok", Toast.LENGTH_SHORT).show();
                StringTokenizer st = new StringTokenizer(result, "&");
                int n = st.countTokens();
                String[] array = new String[st.countTokens()];
                int j = 0;
                while (st.hasMoreElements()) {
                    array[j++] = st.nextToken();
                }
                String a = "";
                String b = "";
                String stst = Integer.toString(n);
                txt_calsearchplus_fooname3.setText(foodname_l_edit);
                txt_calsearchplus_kcal3.setText(array[0]);

            }
        } catch (Exception e) {
        }


    }
    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg1, receiveMsg1;
        ResultSet rs;
        String sendMsg2;
        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://106.241.33.158:1080/EditFoodL.jsp");//바꿔주세요//"http://192.168.56.1:8080/Cap_Connection_2/join_pra.jsp"
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

                case R.id.btn_calsearchplus_save3:

                    String search_m_g = txt_calsearchplus2.getText().toString();
                    //Toast.makeText(MainActivity_cal_searchplusm.this, search_mdnick+foodnamem+search_mdate+search_m_g, Toast.LENGTH_SHORT).show();


                    try {
                        String result = new CustomTask().execute(nickdata,foodname_l_edit,day,search_m_g,"search_editl").get();

                        if (result.equals("ok")) {
                            Toast.makeText(MainAcivity_cal_aditl.this, "연결ok", Toast.LENGTH_SHORT).show();
                            Intent intent_btn_calday_lunch_save=new Intent(MainAcivity_cal_aditl.this, MainActivity_cal_day_lunch.class);
                            startActivity(intent_btn_calday_lunch_save);
                        }
                    } catch (Exception e) {
                    }

                    break;

            }
        }
    };
}
