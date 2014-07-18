package com.mobiquity.localdel;

import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.example.LocalDel.R;


public class CityListAdapter implements ListAdapter {

    Activity activity;

    public CityListAdapter(Activity act) {
        this.activity = act;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 10;
    }

    CityInfo defaultCity = new CityInfo("Defaultness", "This is the default city!  It's round!");
    @Override
    public CityInfo getItem(int position) {
        //return null;
        return defaultCity;
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.city_list_element, parent, false);
        }

        // Lookup view for data population
        TextView filenameView = (TextView) convertView.findViewById(R.id.CityDescription);
        // Populate the data into the template view using the data object
        filenameView.setText(city.getName());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.CityImage);
        imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.circle));

        //attach onClick to view image for each list item
        /*convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //viewCity(city)
            }
        });*/

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
