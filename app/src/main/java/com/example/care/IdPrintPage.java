package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IdPrintPage extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_print_page);

        // 이름 출력
        //findViewById(R.id.etName_idPrintPage).setText(이름);

        // 아이디 출력
        //findViewById(R.id.etId_idPrintPage).setText(아이디);

        // home 버튼 클릭 시 메인 화면으로 이동
        findViewById(R.id.btnHome_idPrintPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(IdPrintPage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}