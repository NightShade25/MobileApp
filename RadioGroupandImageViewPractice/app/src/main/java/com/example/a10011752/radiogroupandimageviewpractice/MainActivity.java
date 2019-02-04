package com.example.a10011752.radiogroupandimageviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    RadioGroup radiogroup;
    ImageView image;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.id_textView);
        radiogroup = findViewById(R.id.id_radiogroup);
        image = findViewById(R.id.id_imageView);

        image.setImageResource(R.drawable.avatarlogo);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.id_airbending){
                    image.setImageResource(R.drawable.airbending);
                        toast = Toast.makeText(MainActivity.this, "AIR BENDING", Toast.LENGTH_SHORT);
                        toast.show();
                }
                if(checkedId == R.id.id_earthbending){
                    image.setImageResource(R.drawable.earthbending);
                    toast = Toast.makeText(MainActivity.this, "EARTH BENDING", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if(checkedId == R.id.id_waterbending){
                    image.setImageResource(R.drawable.waterbending);
                    toast = Toast.makeText(MainActivity.this, "WATER BENDING", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}
