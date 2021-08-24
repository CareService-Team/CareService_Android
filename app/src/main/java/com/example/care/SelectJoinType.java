package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SelectJoinType extends AppCompatActivity {
    final static int WELFARE_JOIN_ACTIVITY_CODE = 100;
    final static int SENILE_JOIN_ACTIVITY_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_join_type);

    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            // 각 유형 별 회원 가입 페이지로 넘어감
            case R.id.btnWelfareWorkerJoin:
                intent = new Intent(SelectJoinType.this, WelfareWorkerJoin.class);
                startActivity(intent);
              //  startActivityForResult(intent, WELFARE_JOIN_ACTIVITY_CODE);
                break;
            case R.id.btnSenileJoin:
                intent = new Intent(SelectJoinType.this, SenileJoin.class);
                startActivity(intent);
              //  startActivityForResult(intent, SENILE_JOIN_ACTIVITY_CODE);
                break;
        }
    }

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 반환 결과가 RESULT_CANCLED이면 회원 가입 취소 메세지 띄움
        String message = "회원 가입 취소";
        switch (requestCode) {
            case WELFARE_JOIN_ACTIVITY_CODE:
            case SENILE_JOIN_ACTIVITY_CODE:
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }*/
}