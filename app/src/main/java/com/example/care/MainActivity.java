package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    String sJoinKey = "SenileJoinSuccess";
    String wJoinKey = "WelfareWorkerJoinSuccess";

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Button go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Worker.class);
                startActivity(intent);
            }
        });
        */

        // 회원 가입 후 회원 정보 db에 저장 하는 코드 작성 필요
        Intent intent = getIntent();
        String sData = intent.getStringExtra(sJoinKey);
        String wData = intent.getStringExtra(wJoinKey);
    }

    public void onClick(View v) {
        Intent intent;
           switch (v.getId()){
               // 회원가입 버튼 클릭 시 가입 유형 페이지로 넘어감
               case R.id.btnJoin:
                   intent = new Intent(MainActivity.this, SelectJoinType.class);
                   startActivity(intent);
                   break;

               // 로그인 성공 조건 만족하면, 각 유형 별 로그인 페이지로 이동
               case R.id.btnLogin:
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
               case R.id.btnFindId:
                   intent = new Intent(MainActivity.this, FindIdPage.class);
                   startActivity(intent);
                   break;

               // 비밀번호 찾기 페이지로 넘어감
               case R.id.btnFindPwd:
                   intent = new Intent(MainActivity.this, FindPwdPage.class);
                   startActivity(intent);
                   break;
           }

    }

}