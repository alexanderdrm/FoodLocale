package com.mobiquity.localdel;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.LocalDel.R;

import java.util.ArrayList;

/**
 * Created by rsampath on 7/21/14.
 */
public class DelicacyInfo  implements BaseInfo{
    String description;
    String shortDescription; //currently unused
    String name;
    int id;
    ArrayList<Integer> cityIds = new ArrayList<Integer>();

    public DelicacyInfo() {

    }

    public DelicacyInfo(String name, String desc, int id) {
        description = desc;
        this.name = name;
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
        return name;
    }

    @Override
    public void view(Context context){
        Intent intent = new Intent(context, CityInfoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("DelicacyId",id);
        context.startActivity(intent);
    }

    //likely not all that useful-- but here in case it's needed in the future
    public void populateView(TextView location, TextView desc, ImageView image) {
        desc.setText(getDescription());
        location.setText(getSubtitleString());
        image.setImageResource(R.drawable.baklava);
    }

    @Override
    public int getDrawable(){
        return R.drawable.baklava;
    }
}
