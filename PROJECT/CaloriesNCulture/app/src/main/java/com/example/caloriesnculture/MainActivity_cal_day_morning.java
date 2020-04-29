package com.example.caloriesnculture;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity_cal_day_morning extends AppCompatActivity {
    String day = "";
    String nickdata = "";
    TextView nickname;
    SharedPreferences pref;
    ListView calday_listView_morning;
    List<String> list_calday_listView_morning;
    ArrayAdapter<String> adapter_calday_listView_morning;
    String morning_item = "";
    SharedPreferences.Editor editor;
    public static Context mContext;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_day_morning);
        //오늘의 날짜
        pref = getSharedPreferences("staticFILE", MODE_PRIVATE);
        day = pref.getString("inputdate_cal", "error");

        //Intent intent_calday_morning=getIntent();
        //date=intent_calday_morning.getStringExtra("today");
        //nick2=intent_calday_morning.getStringExtra("nick2");
        nickname = (TextView) findViewById(R.id.txt_caldaym_name);
        pref = getSharedPreferences("staticFILE", MODE_PRIVATE);
        nickdata = pref.getString("nickname", "error");
        nickname.setText(nickdata);
        Button btn_caldaym_search = findViewById(R.id.btn_caldaym_search);
        btn_caldaym_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btn_caldaym_search = new Intent(MainActivity_cal_day_morning.this, MainActivity_cal_searchm.class);
                // intent_btn_caldaym_search.putExtra("datedate",date);
                // intent_btn_caldaym_search.putExtra("nicknick",nick2);
                startActivity(intent_btn_caldaym_search);
            }
        });

        Button btn_caldaym_back = findViewById(R.id.btn_caldaym_back);
        btn_caldaym_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent_btn_caldaym_back = new Intent(MainActivity_cal_day_morning.this, MainActivity_cal_day.class);
                startActivity(intent_btn_caldaym_back);
            }
        });

        mContext = this;

        calday_listView_morning = (ListView) findViewById(R.id.calday_listView_morning);
        list_calday_listView_morning = new ArrayList<String>();
        adapter_calday_listView_morning = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_calday_listView_morning);
        calday_listView_morning.setAdapter(adapter_calday_listView_morning);

        calday_listView_morning.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                //클릭한 아이템의 문자열을 가져옴
                morning_item = (String) adapterView.getItemAtPosition(position);
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(MainActivity_cal_day_morning.this);
                alert_confirm.setMessage("어떤작업을 수행하실건가요?").setCancelable(false).setPositiveButton("수정",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent_selected_item = new Intent(MainActivity_cal_day_morning.this, MainAcivity_cal_aditm.class);
                                pref=getSharedPreferences("staticFILE",MODE_PRIVATE);
                                editor=pref.edit();
                                editor.putString("foodname_m_edit",morning_item);
                                editor.commit();
                                startActivity(intent_selected_item);
                                finish();

                            }
                        }).setNegativeButton("삭제",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 'No'
                                //Toast.makeText(MainActivity_cal_day_morning.this, "삭제", Toast.LENGTH_SHORT).show();

                                try {
                                    String result = new CustomTask().execute("morning_del", nickdata, day,morning_item).get();

                                    if (result.equals("ok")) {
                                        Toast.makeText(MainActivity_cal_day_morning.this, "삭제완료", Toast.LENGTH_SHORT).show();
                                        //((MainActivity_cal_day_morning)(MainActivity_cal_day_morning.mContext)).onResume();
                                        try {
                                            String result2 = new CustomTask().execute("morning", nickdata, day,"0").get();
                                            list_calday_listView_morning.clear();
                                            if (result.equals("ok")) {
                                                Toast.makeText(MainActivity_cal_day_morning.this, result2 + "연결ok", Toast.LENGTH_SHORT).show();
                                                list_calday_listView_morning.add(0, "데이터가 없습니다");
                                                adapter_calday_listView_morning.notifyDataSetChanged();
                                            } else {
                                                Toast.makeText(MainActivity_cal_day_morning.this, result2 + "연결ok", Toast.LENGTH_SHORT).show();
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
                                                for (int i = 0; i < n; i++) {
                                                    list_calday_listView_morning.add(i, array[i]);
                                                }

                                                adapter_calday_listView_morning.notifyDataSetChanged();

                                            }
                                        } catch (Exception e) {
                                        }
                                    } else {
                                        Toast.makeText(MainActivity_cal_day_morning.this, "error", Toast.LENGTH_SHORT).show();


                                    }
                                } catch (Exception e) {
                                }
                                return;
                            }
                        });

                AlertDialog alert = alert_confirm.create();
                alert.show();
                //Intent intent_selected_item = new Intent(MainActivity_cal_day_morning.this, MainActivity_cal_searchplusm.class);
                //startActivity(intent_selected_item);
                //finish();


            }



        });


        try {
            String result = new CustomTask().execute("morning", nickdata, day,"0").get();

            if (result.equals("ok")) {
                Toast.makeText(MainActivity_cal_day_morning.this, result + "연결ok", Toast.LENGTH_SHORT).show();
                list_calday_listView_morning.add(0, "데이터가 없습니다");
                adapter_calday_listView_morning.notifyDataSetChanged();
            } else {
                Toast.makeText(MainActivity_cal_day_morning.this, result + "연결ok", Toast.LENGTH_SHORT).show();
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
                for (int i = 0; i < n; i++) {
                    list_calday_listView_morning.add(i, array[i]);
                }

                adapter_calday_listView_morning.notifyDataSetChanged();

            }
        } catch (Exception e) {
        }


    }

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

    class CustomTask extends AsyncTask<String, Void, String> {
        String sendMsg1, receiveMsg1;
        ResultSet rs;
        String sendMsg2;

        @Override
        protected String doInBackground(String... strings) {
            try {
                String str;
                URL url = new URL("http://106.241.33.158:1080/SelectMorning.jsp");//바꿔주세요//"http://192.168.56.1:8080/Cap_Connection_2/join_pra.jsp"
                // "http://106.241.33.158:1080/join.jsp"
                //http://106.241.33.158:1080/SelectMorning.jsp
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                sendMsg1 = "type=" + strings[0] + "&nickname=" + strings[1] + "&date=" + strings[2]+"&foodnumber="+strings[3];
                osw.write(sendMsg1);
                osw.flush();

                if (conn.getResponseCode() == conn.HTTP_OK) {
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);
                    StringBuffer buffer = new StringBuffer();
                    while ((str = reader.readLine()) != null) {
                        buffer.append(str);
                    }
                    receiveMsg1 = buffer.toString();


                } else {
                    Log.i("통신 결과", conn.getResponseCode() + "에러");
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return receiveMsg1;
        }
    }
}
