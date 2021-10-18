package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SenilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senile_page);

        ImageButton btnThingList_senilePage = findViewById(R.id.btnThingList_senilePage);
        ImageButton btnThing_senilePage = findViewById(R.id.btnThing_senilePage);
        ImageButton btnSenileInfo = (ImageButton) findViewById(R.id.btnMyInfo_senilePage);

        btnThingList_senilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SenilePage.this, CheckThing.class);
                startActivity(intent);
            }
        });

        btnThing_senilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SenilePage.this, ApplicationThing.class);
                startActivity(intent);
            }
        });

        btnSenileInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SenilePage.this, MyInfo.class);
                startActivity(intent);
            }
        });
    }
}