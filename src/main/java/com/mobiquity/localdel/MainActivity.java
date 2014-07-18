package com.mobiquity.localdel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.LocalDel.R;

import java.util.ArrayList;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        CityListAdapter listAdapter = new CityListAdapter(this);
        ListView cityList = (ListView) findViewById(R.id.CityList);

        cityList.setAdapter(listAdapter);
    }
}
