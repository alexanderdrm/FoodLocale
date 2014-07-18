package com.mobiquity.localdel;

import android.content.Context;
import android.content.Intent;

/**
 * Created by dalexander on 7/18/14.
 */
public class CityInfo {

    String description;
    String shortDescription; //currently unused
    String name;

    //we need to switch to using constants for the state and country name for database goodness later
    String state;
    String country;

    public CityInfo() {
    }

    public CityInfo(String name, String country, String desc) {
        description = desc;
        this.name = name;
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getName() {
        return name;
    }

    public String getSubtitleString() {
        return name+", "+country;
    }

    public void view(Context context){
        Intent intent = new Intent(context, CityInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

}
