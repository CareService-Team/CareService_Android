package com.example.care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindPwdPage extends AppCompatActivity {
    AlertDialog.Builder builder;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd_page);

        builder = new AlertDialog.Builder(this);

        // 아이디 버튼 클릭
        findViewById(R.id.btnId_findPwd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FindPwdPage.this, FindIdPage.class);
                startActivity(intent);
                finish();
            }
        });

        // 비밀번호 버튼 클릭
        findViewById(R.id.btnPwd_findPwd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(FindPwdPage.this, FindPwdPage.class);
                startActivity(intent);
                finish();
            }
        });

        // 확인 버튼 클릭
        findViewById(R.id.btnOk_findId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. DB에서 이름 & 아이디 확인
                /* builder.setTitle("비밀번호 찾기")
                        .setMessage("이름 또는 아이디가 존재하지 않습니다.")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                intent = new Intent(FindIdPage.this, FindPwdPage.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .show(); */

                // 2. 인증 번호 확인


                // 3. 둘 다 success면 비밀번호 변경 페이지로 넘어감
                intent = new Intent(FindPwdPage.this, ChangePwdPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}