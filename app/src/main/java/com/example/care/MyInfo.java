package com.example.care;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.care.database.UserDAO;
import com.example.care.model.User;

public class MyInfo extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        Button button = findViewById(R.id.button);
        EditText nameInput = findViewById(R.id.nameEditText);
        EditText passwordInput = findViewById(R.id.passwordEditText);
        EditText addrInput = findViewById(R.id.addrEditText);

        User userInfo = null;
        UserDAO userDAO = new UserDAO();
        try{
            // 사용자 이름으로 사용자정보를 가져오는 코드
            userInfo = userDAO.findUser("admin");
        }catch (Exception e){
            e.printStackTrace();
        }

        nameInput.setText(userInfo.getUserId());
        passwordInput.setText(userInfo.getPassword());
        addrInput.setText(userInfo.getAddress());



//        System.out.println(nameInput.getText());
//        System.out.println(passwordInput.getText());
//        System.out.println(addrInput.getText());
    }
}
