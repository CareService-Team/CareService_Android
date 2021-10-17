package com.example.care;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.care.database.UserDAO;
import com.example.care.model.User;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class MyInfo extends AppCompatActivity {

    private static String TAG = "MyInfo";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        Button button = findViewById(R.id.button);
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

//        System.out.println(nameInput.getText());
//        System.out.println(passwordInput.getText());
//        System.out.println(addrInput.getText());
    }
}
