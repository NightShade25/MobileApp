package com.example.a10011752.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView number;
    Button launch;

    static final int NUMBER_CODE  = 1234;
    static final String TAG_NUMBER = "Number tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        number = findViewById(R.id.textView);
        launch = findViewById(R.id.id_launch);

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentToLaunchActivity = new Intent(MainActivity.this, NumberActivity.class);
                IntentToLaunchActivity.putExtra("TEXT", "This is a test");
            //    startActivity(IntentToLaunchActivity);
                startActivityForResult(IntentToLaunchActivity, NUMBER_CODE);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == NUMBER_CODE && resultCode == RESULT_OK)
                number.setText(data.getStringExtra(TAG_NUMBER));
    }
}

