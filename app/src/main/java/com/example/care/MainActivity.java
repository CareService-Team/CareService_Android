package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.Request;
import com.example.care.model.Senile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    String sJoinKey = "SenileJoinSuccess";
    String wJoinKey = "WelfareWorkerJoinSuccess";

       @Override
    protected void onCreate(Bundle savedInstanceState) {
//           StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//           StrictMode.setThreadPolicy(policy);

           super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        globalVars.httpHandler = new HttpHandler(getApplicationContext(), "http://54.180.156.89:8080");
        // TODO: Check if API Server is online

        // TODO: login and use token rather than storing id in globalVars
        globalVars.ID = "111";
        globalVars.type = globalVars.UserType.SENILE;

        Button joinGo = findViewById(R.id.btnJoin_main);
        Button go = (Button) findViewById(R.id.btnLogin_main);

        joinGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectJoinType.class);
                startActivity(intent);
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SenilePage.class);
                //intent = new Intent(getApplicationContext(), Worker.class);
                startActivity(intent);
            }
        });

        // 회원 가입 후 회원 정보 db에 저장 하는 코드 작성 필요
        Intent intent = getIntent();
        String sData = intent.getStringExtra(sJoinKey);
        String wData = intent.getStringExtra(wJoinKey);
    }

    /*public void onClick(View v) {
        Intent intent;
           switch (v.getId()){
               // 회원가입 버튼 클릭 시 가입 유형 페이지로 넘어감
               case R.id.btnJoin_main:
//                   intent = new Intent(MainActivity.this, SelectJoinType.class);
//                   startActivity(intent);
                   break;

               // 로그인 성공 조건 만족하면, 각 유형 별 로그인 페이지로 이동
               case R.id.btnLogin_main:
                   RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroup);
                   int id = rg.getCheckedRadioButtonId();
                   RadioButton rb = (RadioButton)findViewById(id);

                   if(rb.equals("rbWelfareWorker")){
                       intent = new Intent(MainActivity.this, WelfareWorkerPage.class);
                       startActivity(intent);
                   }else if(rb.equals("rbSenile")){
                       intent = new Intent(MainActivity.this, SenilePage.class);
                       startActivity(intent);
                   }
                   break;

               // id 찾기 페이지로 넘어감
               case R.id.btnFindId_main:
                   intent = new Intent(MainActivity.this, FindIdPage.class);
                   startActivity(intent);
                   break;

               // 비밀번호 찾기 페이지로 넘어감
               case R.id.btnFindPwd_main:
                   intent = new Intent(MainActivity.this, FindPwdPage.class);
                   startActivity(intent);
                   break;
           }

    }*/
}