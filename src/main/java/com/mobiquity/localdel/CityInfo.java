package com.mobiquity.localdel;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.LocalDel.R;

/**
 * Created by dalexander on 7/18/14.
 */
public class CityInfo implements BaseInfo{

    String description;
    String shortDescription; //currently unused
    String name;
    int id;

    //we need to switch to using constants for the state and country name for database goodness later
    String state;
    String country;

    public CityInfo() {

    }

    public CityInfo(String name, String country, String desc, int id) {
        description = desc;
        this.name = name;
        this.country = country;
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSubtitleString() {
        return name+", "+country;
    }

    @Override
    public void view(Context context){
        Intent intent = new Intent(context, DetailViewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("InfoId",id);
        context.startActivity(intent);
    }

    //likely not all that useful-- but here in case it's needed in the future
    public void populateView(TextView location, TextView desc, ImageView image) {
        desc.setText(getDescription());
        location.setText(getSubtitleString());
        image.setImageResource(R.drawable.taj_mahal);
    }

    @Override
    public int getDrawable(){
        return R.drawable.taj_mahal;
    }

}
