package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.care.database.SenileThingDAO;
import com.example.care.model.SenileThing;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CheckThing extends AppCompatActivity {

    private static final String TAG = "CheckThing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_thing);

        ListView listView = findViewById(R.id.listView);


        // TODO: change subURL for checking senilething
        globalVars.httpHandler.Request(Request.Method.GET, globalVars.subURL.INFOSENILETHING.getURL() + globalVars.ID
            , null, new Response.Listener<Object>() {
                @Override
                public void onResponse(Object response) {
                    try {
                        JSONObject obj = (JSONObject) response;
                        System.out.println(((JSONObject) response).toString());
                        obj.getString("tid");
                        // TODO: change text view
                    } catch (JSONException e) {
                        e.printStackTrace();
                        // TODO: Handle ERROR
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.w(TAG, "onErrorResponse: ", error);
                }
            });

//        SenileThingDAO senileThingDAO = new SenileThingDAO();
//        List<SenileThing> senileThingList = null;
//        try {
//            senileThingList = senileThingDAO.findAll();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        for (SenileThing senileThing :
//                senileThingList) {
//            TextView textView = new TextView(this);
//            textView.setText(senileThing.getThingName() + ": " + senileThing.getCount());
//            listView.addView(textView);
//        }
    }
}