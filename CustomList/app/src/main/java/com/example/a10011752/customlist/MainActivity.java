package com.example.a10011752.customlist;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    listView = findViewById(R.id.id_listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                toast = toast.makeText(getApplicationContext(), "Entry " + position+" was clicked!", Toast.LENGTH_SHORT);
                toast.show();

            }
        });



    arrayList = new ArrayList<>();

    arrayList.add("Bob");
    arrayList.add("Bob");
    arrayList.add("Bob");
    arrayList.add("Bob");
    arrayList.add("Bob");
    arrayList.add("Bob");
    arrayList.add("Bob");
    arrayList.add("Bob");


    CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_layout, arrayList);
    listView.setAdapter(customAdapter);



    }

    public class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        int resource;
        List<String> list;


        public CustomAdapter( @NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            list = objects;



        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = layoutInflater.inflate(resource, null);

            TextView textView = adapterView.findViewById(R.id.id_textView);
            ImageView imageView = adapterView.findViewById(R.id.id_imageView);
            final Button button = adapterView.findViewById(R.id.id_button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });


            textView.setText(list.get(position)+ " " + position);
            return adapterView;
        }

    }

}
