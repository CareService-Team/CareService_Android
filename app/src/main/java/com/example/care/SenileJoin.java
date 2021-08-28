package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SenileJoin extends AppCompatActivity {
    String sJoinKey = "SenileJoinSuccess";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senile_join);
    }

    public void onClick(View v){
        //String msg = "노약자 회원 데이터 db에 저장 코드 추가";

        switch(v.getId()){
            // 회원 가입 완료하면 MainActivity로 이동
            case R.id.btnOk_senileJoin:
                Intent intent = new Intent(SenileJoin.this, MainActivity.class);
               // intent.putExtra(sJoinKey, msg);
                Toast.makeText(this, R.string.joinSuccess, Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            // 회원 가입 취소하면 가입 유형 선택 페이지로 이동
            case R.id.btnCancel_senileJoin:
                Toast.makeText(this, R.string.joinCancel, Toast.LENGTH_SHORT).show();
                //setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}