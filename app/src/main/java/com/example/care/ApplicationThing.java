package com.example.care;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ApplicationThing extends AppCompatActivity {

    private static final String TAG = "ApplicationThing";
    EditText extraEditText;
    Button btnApplication;

    static class Thing{
        private int chkBoxID;
        private String id;
        private String name;
        private int count;

        Thing(int chkBoxID, String id, String name, int count){
            this.chkBoxID = chkBoxID;
            this.id = id;
            this.name = name;
            this.count = count;
        }

        public int getChkBoxID() {
            return chkBoxID;
        }

        public int getCount() {
            return count;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String toString(){
            return "{\"t_id\":\""+ id +"\",\"t_name\":\""+name+"\",\"t_remain\":\""+count+"\"}";
        }
    }

    static class ChkBoxID{
        private static int numChkBox;

        static void addChkBox(){
            numChkBox += 1;
        }

        static int getNumChkBox(){
            return numChkBox;
        }

        private enum ID{
            TISSUE(new Thing(R.id.checkBox, "t1", "휴지", 1)),
            RICE(new Thing(R.id.checkBox2, "2", "쌀", 1)),
            WATER(new Thing(R.id.checkBox3, "t2", "물", 1)),
            MASK(new Thing(R.id.checkBox4, "t3", "마스크", 1)),
            HOMEFIX(new Thing(R.id.checkBox5, "5", "가전", 1)),
            NOODLE(new Thing(R.id.checkBox6, "6", "라면", 1)),
            EXTRA(new Thing(R.id.checkBox7, "0", "기타", 1));

            ID(Thing thing){
                this.thing = thing;
                ChkBoxID.addChkBox();
            }

            private Thing thing;
            public int getChkBoxID(){return thing.getChkBoxID();}
            public String getThingID(){return thing.getId();}
            public String getName(){return thing.getName();}
            public int getCount(){return thing.getCount();}
            public void setCount(int cnt){thing.count = cnt;}
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_thing);

        List<CheckBox> checkBoxes = new ArrayList<>();

        for (ChkBoxID.ID chkBoxID: ChkBoxID.ID.values()
        ) {
            checkBoxes.add(findViewById(chkBoxID.getChkBoxID()));
        }

        extraEditText = findViewById(R.id.extraThingEditText);
        btnApplication = findViewById(R.id.btnApplication_applicationThing);

        extraEditText.setEnabled(false);

        ((CheckBox)findViewById(ChkBoxID.ID.EXTRA.getChkBoxID())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extraEditText.setEnabled(((CheckBox)findViewById(ChkBoxID.ID.EXTRA.getChkBoxID())).isChecked());
            }
        });

        btnApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(ApplicationThing.this);
                dlg.setTitle("신청")
                        .setMessage("물품을 신청하시겠습니까?")
                        .setP