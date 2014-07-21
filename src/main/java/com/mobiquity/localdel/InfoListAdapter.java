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

import static android.view.View.OnClickListener;

public class InfoListAdapter implements ListAdapter {

    Context context;

    ArrayList<BaseInfo> infos;

    public InfoListAdapter(Context con, ArrayList<BaseInfo> cities) {
        this.context = con;
        this.infos = cities;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public BaseInfo getItem(int position) {
        //return null;
        return infos.get(position);
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
        final BaseInfo info = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.city_list_element, parent, false);
        }

        // Lookup view for data population
        TextView filenameView = (TextView) convertView.findViewById(R.id.CityDescription);
        // Populate the data into the template view using the data object
        filenameView.setText(info.getSubtitleString());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.CityImage);
        imageView.setImageDrawable(context.getResources().getDrawable(info.getDrawable()));

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
                info.view(context);
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
