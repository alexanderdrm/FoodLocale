package com.mobiquity.localdel;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.example.LocalDel.R;


import java.util.ArrayList;

import static android.view.View.OnClickListener;

public class CityListAdapter implements ListAdapter {

    Context context;

    ArrayList<CityInfo> cities;

    public CityListAdapter(Context con, ArrayList<CityInfo> cities) {
        this.context = con;
        this.cities = cities;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return cities.size();
    }

    CityInfo defaultCity = new CityInfo("Defaultness", "Defaulte", "This is the default city!  It's round!",999);
    @Override
    public CityInfo getItem(int position) {
        //return null;
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final CityInfo city = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.city_list_element, parent, false);
        }

        // Lookup view for data population
        TextView filenameView = (TextView) convertView.findViewById(R.id.CityDescription);
        // Populate the data into the template view using the data object
        filenameView.setText(city.getSubtitleString());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.CityImage);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.taj_mahal));

        // city.populateView(filenameView, null, imageView); //this is one option, but it doesn't save us much trouble

        final ImageView heart = (ImageView) convertView.findViewById(R.id.favIcon);
        heart.setOnClickListener(new OnClickListener() {
            boolean isFilled = false;
            public void onClick(View v) {
                if(isFilled) {
                    heart.setImageResource(R.drawable.heart_outline);
                } else {
                    heart.setImageResource(R.drawable.heart_filled);
                }
                isFilled = !isFilled;
            }
        });

        //attach onClick to view image for each list item
        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                city.view(context);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return position < getCount();
    }
}
