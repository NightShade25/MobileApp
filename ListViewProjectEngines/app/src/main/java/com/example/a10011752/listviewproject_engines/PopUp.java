package com.example.a10011752.listviewproject_engines;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class PopUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.75),(int)(height*0.5));

    }
}
