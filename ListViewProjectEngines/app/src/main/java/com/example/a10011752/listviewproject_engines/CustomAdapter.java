package com.example.a10011752.listviewproject_engines;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<SteamEngine> {
   Context context;
    int resource;
    List<SteamEngine> list;

    public CustomAdapter( @NonNull Context context, int resource, @NonNull List<SteamEngine> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(final int position,  @Nullable View convertView,  @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View adapterView = layoutInflater.inflate(resource, null);

        TextView textView = adapterView.findViewById(R.id.id_textView);
        ImageView imageView = adapterView.findViewById(R.id.id_imageView);
        TextView contents = adapterView.findViewById(R.id.id_contentTextView);
        TextView prices = adapterView.findViewById(R.id.id_priceTextView);

        if(prices != null) {
            prices.setText(list.get(position).price);
        }
        if(textView!= null) {
            textView.setText(list.get(position).name);
        }
        if(textView!= null) {
            textView.setText(list.get(position).name);
        }

        imageView.setImageResource(list.get(position).trainImageId);
        final Button button = adapterView.findViewById(R.id.id_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        return adapterView;
    }
}
