package com.example.a10011752.spinnerpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText name;
    TextView nameOutput;
    ArrayList<String> list;
    ArrayList<String> Finallist;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    spinner = findViewById(R.id.id_spinner);
    name = findViewById(R.id.id_editTextName);
    nameOutput=  findViewById(R.id.id_textView);
    add = findViewById(R.id.id_button);
    list= new ArrayList<>();
    Finallist= new ArrayList<>();

    list.add("Mrs. ");
    list.add("Mr. ");
    list.add("Ms. ");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(arrayAdapter);

    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            nameOutput.setText(list.get(position)+name);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Finallist.add((String)(nameOutput.getText()));

        }
    });

    }


}
