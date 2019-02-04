package com.example.a10011752.listviewproject_engines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<SteamEngine> arrayList;
    ArrayList<String> stringArrayList;

    public static final String KEY = "MakeAKey";

 //   TextView contentset;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, arrayList);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.id_listView);
   //     contentset = findViewById(R.id.id_contentTextView)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startActivity(new Intent(MainActivity.this, PopUp.class));
       //         contentset.setText(arrayList.get(position).content);


            }
        });

        if(savedInstanceState == null) {

            arrayList = new ArrayList<>();
            stringArrayList = new ArrayList<>();

            SteamEngine engine262 = new SteamEngine("CGR 2nd Class TT", R.drawable.twosixtwo, "blah blah 1", "$100");
            arrayList.add(engine262);

            SteamEngine engine462 = new SteamEngine("China Railways", R.drawable.yongbao, "blah blah 2", "$200");
            arrayList.add(engine462);

            SteamEngine engine4884 = new SteamEngine("Big Boy", R.drawable.bigboy, "blah blah 3", "$300");
            arrayList.add(engine4884);

            SteamEngine enginemallard = new SteamEngine("Mallard", R.drawable.mallard, "bb4", "$400");
            arrayList.add(enginemallard);

            SteamEngine engine082 = new SteamEngine("Nilgiri X Class", R.drawable.chukchuknilgiri, "bb5", "$500");
            arrayList.add(engine082);


        }
        else{
            arrayList = (ArrayList)savedInstanceState.getSerializable(KEY);
        }
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_layout, arrayList);
        listView.setAdapter(customAdapter);

        if(arrayList.get(0) == null){
            //make a toast saying Removed all Trains!
        }
    }
}
