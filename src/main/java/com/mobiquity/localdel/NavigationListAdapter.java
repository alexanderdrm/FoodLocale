package com.mobiquity.localdel;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.example.LocalDel.R;

import java.util.ArrayList;

/**
 * Created by rsampath on 7/21/14.
 */
public class NavigationListAdapter implements ListAdapter {
    Context context;



    public NavigationListAdapter(Context context) {
        this.context = context;

    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public Object getItem(int position) {
        return null;

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
        //final CityInfo city = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.drawer_list_item, parent, false);
        }

        // Lookup view for data population
        TextView desc = (TextView) convertView.findViewById(R.id.DrawerItemDescription);
        // Populate the data into the template view using the data object
            desc.setText(R.string.drawer_location);
//       switch


        // city.populateView(filenameView, null, imageView); //this is one option, but it doesn't save us much trouble

       // final ImageView heart = (ImageView) convertView.findViewById(R.id.favIcon);


        //attach onClick to view image for each list item
        convertView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.activateActivity(context);
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

