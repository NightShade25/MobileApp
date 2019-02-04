package com.example.a10011752.orientationdemo;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, land, port;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.id_textView);
        land = findViewById(R.id.id_land);
        port = findViewById(R.id.id_port);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            port.setText("PORT");
        }
        Log.d("TAG", getResources().getConfiguration().orientation+" ");
    }
}
