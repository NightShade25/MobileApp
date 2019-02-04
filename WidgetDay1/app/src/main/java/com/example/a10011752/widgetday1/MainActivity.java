package com.example.a10011752.widgetday1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch switch2;
    EditText editText;
    SeekBar seekBar;

    TextView switchText, editTextText, seekText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekText = findViewById(R.id.id_seekText);
        seekBar = findViewById(R.id.id_seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekText.setText(seekBar.getProgress()+"@");             //this one can be alone
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //seekText.setText(seekBar.getProgress()+"@");                //this and
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //seekText.setText(seekBar.getProgress()+"@");                //this and the one above have to be uncommented at the same time
            }
        });


        switch2 = findViewById(R.id.id_switch);
        switchText = findViewById(R.id.id_switchText);

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    switchText.setText("ON");
                if (!isChecked)
                    switchText.setText("OFF");
            }
        });


        editText = findViewById(R.id.id_editText);
        editTextText = findViewById(R.id.id_editTextText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextText.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
