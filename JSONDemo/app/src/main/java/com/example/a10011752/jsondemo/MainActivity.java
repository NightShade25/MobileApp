package com.example.a10011752.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject studentInfo = new JSONObject();

        try {
            studentInfo.put("name", "steve");
            studentInfo.put("grade level", 12);
            studentInfo.put("id", 10012345);
        } catch (JSONException e) {
            e.printStackTrace();
        }

     //   Log.d("TAGTAG", studentInfo.toString());

        JSONObject mathJSON = new JSONObject();

        try {
            mathJSON.put("Grade", "A");
            mathJSON.put("Percent", 94);
            mathJSON.put("block", "1A");
            studentInfo.put("Math Course", mathJSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }
     //   Log.d("TAGTAG", studentInfo.toString());

        JSONArray clubList = new JSONArray();
        clubList.put("FBLA");
        clubList.put("JSA");
        clubList.put(123);

        try {
            studentInfo.put("Clubs", clubList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("TAGTAG", studentInfo.toString());

        try {
            JSONObject findCourse = studentInfo.getJSONObject("Math Course");
            Log.d("TAGTAG", findCourse.getString("block"));

            Log.d("TAGTAG", findCourse.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
