package com.example.a10011752.widgetquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText pass1;
    EditText pass2;

    TextView passwordUsed;

    String password1;
    String password2;

    Button ok;
    Switch match;

    ArrayList<String> storage = new ArrayList<>();

    boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass1 = findViewById(R.id.id_password1);
        pass2 = findViewById(R.id.id_password2);
        ok = findViewById(R.id.id_ok);
        match = findViewById(R.id.id_switch1);

        password1 = " ";

        storage.add("test");
        storage.add("123");
        storage.add("password");
        storage.add("abc");

        passwordUsed = findViewById(R.id.id_passwordUsed);

        b = true;

        pass1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                        password1 = s.toString();
                            for (int i = 0; i < storage.size(); i++) {
                                if (password1.equals(storage.get(i))) {
                                    passwordUsed.setText("YOU FOOL! password used!");
                                    b = false;
                                    break;
                                }else{
                                    passwordUsed.setText("password is not used");
                                    b = true;
                                }
                            }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password2 = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        match.setClickable(false);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password1.equals(password2) && b != false){
                    match.setChecked(true);
                    match.setText("MATCH");
                }else{
                    match.setChecked(false);
                    match.setText("DOES NOT MATCH");
                }

            }
        });


    }

}
