package com.example.a10011752.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumberActivity extends AppCompatActivity {

    EditText enterNumber;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        enterNumber = findViewById(R.id.editText);
        close = findViewById(R.id.id_close);

        Toast.makeText(this, getIntent().getStringExtra("TEST"), Toast.LENGTH_SHORT).show();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendInfoBack = new Intent();
                sendInfoBack.putExtra(MainActivity.TAG_NUMBER, enterNumber.getText().toString());
                setResult(RESULT_OK, sendInfoBack);

                finish();
            }
        });


    }
}
