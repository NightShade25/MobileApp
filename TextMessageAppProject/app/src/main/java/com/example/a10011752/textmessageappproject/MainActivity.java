package com.example.a10011752.textmessageappproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver;
    Bundle babybundle;
    SmsMessage[] smsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            babybundle = intent.getExtras();
           Object[] objPdus = (Object[]) babybundle.getSerializable("pdus");
            smsList = new SmsMessage[objPdus.length];
            for(int i = 0; i < objPdus.length; i++){
            }
        }
    };

    }
}
