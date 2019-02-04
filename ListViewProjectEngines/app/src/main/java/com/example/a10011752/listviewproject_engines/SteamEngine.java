package com.example.a10011752.listviewproject_engines;

import android.widget.ImageView;

import java.io.Serializable;

public class SteamEngine implements Serializable {

    public String name;
    public int trainImageId;
    public String content;
    public String price;

    public SteamEngine(String name, int trainImageId, String content, String price){
        this.name = name;
        this.trainImageId = trainImageId;
        this.content = content;
        this.price = price;
    }
}
