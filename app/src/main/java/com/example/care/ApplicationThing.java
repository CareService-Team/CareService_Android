package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.care.database.SenileThingDAO;
import com.example.care.database.ThingDAO;
import com.example.care.model.SenileThing;
import com.example.care.model.Thing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ApplicationThing extends AppCompatActivity {

    private static final String TAG = "ApplicationThing";

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
            TISSUE(new Thing(R.id.checkBox, "1", "휴지", 1)),
            RICE(new Thing(R.id.checkBox2, "2", "쌀", 1)),
            WATER(new Thing(R.id.checkBox3, "3", "물", 1)),
            MASK(new Thing(R.id.checkBox4, "4", "마스크", 1)),
            HOMEFIX(new Thing(R.id.checkBox5, "5", "마스크", 1)),
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
        
        EditText extraEditText = findViewById(R.id.extraThingEditText);
        Button button = findViewById(R.id.button);

        extraEditText.setEnabled(false);

        ((CheckBox)findViewById(ChkBoxID.ID.EXTRA.getChkBoxID())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extraEditText.setEnabled(((CheckBox)findViewById(ChkBoxID.ID.EXTRA.getChkBoxID())).isChecked());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Thing> things = new ArrayList<>();
                for (CheckBox chkBox :
                        checkBoxes) {
                    if (chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.TISSUE.getChkBoxID()) {
                        things.add(ChkBoxID.ID.TISSUE.thing);
                        continue;
                    }
                    if(chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.RICE.getChkBoxID()){
                        things.add(ChkBoxID.ID.RICE.thing);
                        continue;
                    }
                    if(chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.WATER.getChkBoxID()){
                        things.add(ChkBoxID.ID.WATER.thing);
                        continue;
                    }
                    if(chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.MASK.getChkBoxID()){
                        things.add(ChkBoxID.ID.MASK.thing);
                        continue;
                    }
                    if(chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.HOMEFIX.getChkBoxID()){
                        things.add(ChkBoxID.ID.HOMEFIX.thing);
                        continue;
                    }
                    if(chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.NOODLE.getChkBoxID()){
                        things.add(ChkBoxID.ID.NOODLE.thing);
                        continue;
                    }
                    if(chkBox.isChecked() && chkBox.getId() == ChkBoxID.ID.EXTRA.getChkBoxID()){
                        int len = 0;
                        String t_id = "";
                        String temp = extraEditText.getText().toString();
                        if(temp.trim().isEmpty())
                            continue;

                        // 물품 추가
                        globalVars.httpHandler.Request(Request.Method.GET, globalVars.subURL.ALLTHING.getURL()
                            ,null, new Response.Listener<Object>() {
                                @Override
                                public void onResponse(Object response) {
                                    try {
                                        JSONArray obj = (JSONArray) response;
                                        int max = -1;
//                                            System.out.println(obj.toString());

                                        for(int i = 0; !obj.isNull(i); i++){
                                            JSONObject elem = obj.getJSONObject(i);
                                            System.out.println(elem.toString());
                                            System.out.println(elem.get("t_id"));
                                            try {
                                                System.out.println("Integer: " + Integer.parseInt(((String) elem.get("t_id")).substring(1)));
                                                if (Integer.parseInt(((String) elem.get("t_id")).substring(1)) > max) {
                                                    max = Integer.parseInt(((String) elem.get("t_id")).substring(1));
                                                }
                                            }catch ( NumberFormatException numberFormatException){
                                                numberFormatException.printStackTrace();
                                            }
                                        }

                                        System.out.println(obj.getJSONObject(0).getString("t_id"));
//                                            System.out.println(obj.getString("t_name"));
//                                            System.out.println(obj.getString("t_remain"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.w(TAG, "onErrorResponse: ", error);
                                }
                            });
//                        things.add(new Thing(-1, max, extraEditText.getText(), 1));
                    }
                }
//
//                String data = "";
//
//
//                // 물품 신청 후 페이지 넘기기!
//                globalVars.httpHandler.Request(Request.Method.POST, globalVars.subURL.ADDREQSENILETHING.getURL() + globalVars.address + "/" + System.currentTimeMillis() / 1000L
//                    ,null, new Response.Listener<Object>() {
//                        @Override
//                        public void onResponse(Object response) {
//                            try {
//                                JSONArray obj = (JSONArray) response;
////                                            System.out.println(obj.toString());
//
//                                for(int i = 0; !obj.isNull(i); i++){
//                                    JSONObject elem = obj.getJSONObject(i);
//                                    System.out.println(elem.toString());
//                                    System.out.println(elem.get("t_id"));
//                                    try {
//                                        System.out.println("Integer: " + Integer.parseInt((String) elem.get("t_id")));
//                                    }catch ( NumberFormatException numberFormatException){
//                                        numberFormatException.printStackTrace();
//                                    }
//                                }
//
//                                System.out.println(obj.getJSONObject(0).getString("t_id"));
////                                            System.out.println(obj.getString("t_name"));
////                                            System.out.println(obj.getString("t_remain"));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.w(TAG, "onErrorResponse: ", error);
//                        }
//                    });
            }
        });
    }
}