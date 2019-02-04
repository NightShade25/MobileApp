package com.example.a10011752.lifecycledemo;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    int counter = 0;
    public static final String COUNTER_KEY = "key1";



    public MainActivity() {
        super();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAG", "SAVING INFO LALALA");
        outState.putInt(COUNTER_KEY, counter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause()");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", "onCreate()");

    button=findViewById(R.id.id_button);
    textView=findViewById(R.id.id_textView);

    if(savedInstanceState != null) { //if its not the first run
        counter = savedInstanceState.getInt(COUNTER_KEY);
        textView.setText(counter + " clicks");
    }
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter++;
            textView.setText(counter + " clicks");
        }
    });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart()");

    }
}
