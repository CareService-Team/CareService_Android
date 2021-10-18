package com.example.care;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class MyInfo extends AppCompatActivity {

    private static String TAG = "MyInfo";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        Button btnUpdate = findViewById(R.id.btnUpdate_myInfo);
        EditText nameInput = findViewById(R.id.nameEditText);
        EditText passwordInput = findViewById(R.id.passwordEditText);
        EditText addrInput = findViewById(R.id.addrEditText);

        globalVars.httpHandler.Request(Request.Method.GET, "/" + globalVars.type.name().toLowerCase() + "/" + globalVars.ID
                , null, new Response.Listener<Object>() {
                    @Override
                    public void onResponse(Object response) {
                        try {
                            JSONObject obj = (JSONObject) response;
                            nameInput.setText(obj.getString("s_name"));
                            passwordInput.setText(obj.getString("s_password"));
                            addrInput.setText(obj.getString("s_address"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            nameInput.setText("");
                            passwordInput.setText("");
                            addrInput.setText("");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.w(TAG, "onErrorResponse: ", error);
                    }
                });

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MyInfo.this);

                dlg.setTitle("수정")
                        .setMessage("정보를 수정하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 디비 수정 작업 필요

                                Toast.makeText(MyInfo.this, "수정이 완료되었습니다.", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });

//        System.out.println(nameInput.getText());
//        System.out.println(passwordInput.getText());
//        System.out.println(addrInput.getText());
    }
}
