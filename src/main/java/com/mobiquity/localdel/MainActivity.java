package com.mobiquity.localdel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.example.LocalDel.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    /**
     * Called when the context is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        CityListAdapter listAdapter = new CityListAdapter(getApplicationContext(), new ArrayList<CityInfo>(Arrays.asList(new CityInfo[]{
             CityFactory.createCity("CityOne","CountryOne","This is the first!"),  CityFactory.createCity("CityTwo","CountryOne","This is the second!"),
                 CityFactory.createCity("CityFour","CountryTwo","This is the third!"), CityFactory.createCity("CityThree","CountryTwo","This is the fourth!")
        })));
        ListView cityList = (ListView) findViewById(R.id.CityList);

        cityList.setAdapter(listAdapter);
    }
}
