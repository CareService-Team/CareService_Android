package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectJoinType extends AppCompatActivity {
    final static int WELFARE_JOIN_ACTIVITY_CODE = 100;
    final static int SENILE_JOIN_ACTIVITY_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_join_type);

        Button welfareType = findViewById(R.id.btnWelfareWorker_selectJoinType);
        Button senileType = findViewById(R.id.btnSenile_selectJoinType);

        welfareType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectJoinType.this, WelfareWorkerJoin.class);
                startActivity(intent);
            }
        });

        senileType.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectJoinType.this, SenileJoin.class);
                startActivity(intent);
            }
        });

    }
//    public void onClick(View v) {
//        Intent intent;
//        switch (v.getId()){
//            // 각 유형 별 회원 가입 페이지로 넘어감
//            case R.id.btnWelfareWorker_selectJoinType:
//
//              //  startActivityForResult(intent, WELFARE_JOIN_ACTIVITY_CODE);
//                break;
//            case R.id.btnSenile_selectJoinType:
//                intent = new Intent(SelectJoinType.this, SenileJoin.class);
//                startActivity(intent);
//              //  startActivityForResult(intent, SENILE_JOIN_ACTIVITY_CODE);
//                break;
//        }
//    }

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