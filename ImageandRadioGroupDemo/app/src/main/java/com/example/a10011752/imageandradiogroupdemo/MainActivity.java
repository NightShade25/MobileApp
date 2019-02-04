package com.example.a10011752.imageandradiogroupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogroup;
    ImageView lukeImage, vaderImage;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.id_textView);
        radiogroup = findViewById(R.id.id_radioGroup);
        lukeImage = findViewById(R.id.id_vaderImage);
        vaderImage = findViewById(R.id.id_lukeImage);
        vaderImage.setImageResource(R.drawable.darthvader);
        lukeImage.setImageResource(R.drawable.lukeskywalker);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.id_radioLuke)
                    textview.setText("Luke");
                if (checkedId == R.id.id_radioVader){
                    textview.setText("Vader");
                Toast myToast = Toast.makeText(MainActivity.this, "Darth Vader", Toast.LENGTH_SHORT);
                myToast.show();
                }
            }
        });
    }
}
