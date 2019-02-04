package com.example.a10011752.guessinggamequizradiogroupwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button play;
    RadioGroup mychoice;
    ImageView cpuchoice;
    TextView score, winorlose;
    int me = 0;
    int computer = 0;
    int result = 0;
    Toast frenchToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play = findViewById(R.id.id_buttonPlay);
        mychoice = findViewById(R.id.id_RadiGroupOneorTwo);
        cpuchoice = findViewById(R.id.id_cpuImage);
        score = findViewById(R.id.id_total);
        winorlose = findViewById(R.id.id_Result);

        mychoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cpuchoice.setImageResource(R.drawable.computericon);
                score.setText("Total");
                winorlose.setText("Result");

                if(checkedId == R.id.id_radButton1)
                    me = 1;
                if(checkedId == R.id.id_radButton2)
                    me = 2;
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computer = (int)(Math.random()*2+1);
                result = computer + me;
                if(me == 0){
                    frenchToast = Toast.makeText(MainActivity.this, "MAKE A CHOICE YOU INDECISIVE FOOL", Toast.LENGTH_SHORT);
                    frenchToast.show();
                }else if(me == 1 || me == 2){
                    score.setText("The Total is " + result);
                    if(computer == 1){
                        cpuchoice.setImageResource(R.drawable.numberone);
                    }else if(computer == 2){
                        cpuchoice.setImageResource(R.drawable.numbertwo);
                    }



                    if(result % 2 == 0){
                        winorlose.setText("You Win");
                    }else if(result % 2 == 1){
                        winorlose.setText("Computer Wins");
                    }
                }





            }
        });

    }
}
