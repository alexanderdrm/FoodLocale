package com.mobiquity.localdel;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.LocalDel.R;

/**
 * Created by rsampath on 7/21/14.
 */
public class DrawerFragment extends Fragment {

    public DrawerLayout mDrawerLayout;
    public LinearLayout mDrawerList;
//    private String mTitle;
//    private String mDrawerTitle;
    public ActionBarDrawerToggle mDrawerToggle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.drawer, container, false);

        mDrawerList = (LinearLayout)view.findViewById(R.id.left_drawer);

        view.findViewById(R.id.city_drawer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.activateCityView(view.getContext().getApplicationContext());
            }
        });

        view.findViewById(R.id.delicacy_drawer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.activateDelicacyView(view.getContext().getApplicationContext());
            }
        });

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        getActivity().getActionBar().setHomeButtonEnabled(true);

      return view;
    }



}
