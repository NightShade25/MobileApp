package com.example.a10011752.radiogroupandimageview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup volume, rps;
    ImageView rpsImage;
    Button play;
    TextView winorlose, score;
    Toast frenchToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volume =findViewById(R.id.id_RadioGroup_Volume);
        rps =        findViewById(R.id.id_rockPaperScissorsRadioGroup);
        rpsImage =findViewById(R.id.id_playedImage);
        play =findViewById(R.id.id_button_play);
        winorlose =findViewById(R.id.id_winOrlose);
        score = findViewById(R.id.id_score);

        volume.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.id_radioButton_100){
                    frenchToast = Toast.makeText(MainActivity.this, "High Volume Can Damage Hearing", Toast.LENGTH_SHORT);
                    frenchToast.show();
                }
            }
        });


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {




    }


}
