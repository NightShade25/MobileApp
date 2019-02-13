package com.example.a10011752.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    BroadcastReceiver battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.id_tv);

    }

    @Override
    protected void onResume() {
        super.onResume();
        battery = new BatteryMonitor();
        IntentFilter batteryFilter = new IntentFilter();
        batteryFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(battery, batteryFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public class BatteryMonitor extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "battery changed", Toast.LENGTH_SHORT).show();
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            if(status == -1){
                tv.setText("error");
            }if(status == 5){
                tv.setText("full charge");
            }if (status == 2){
                tv.setText("charging");
            }
        }
    }
}
