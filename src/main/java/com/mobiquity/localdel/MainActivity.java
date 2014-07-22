package com.mobiquity.localdel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.example.LocalDel.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends DraweredActivity{
    /**
     * Called when the context is first created.
     */

    private static final String TAG = MainActivity.class.getName();
    private String[] drawerTitles;
    private static final int CITIES_VIEW = 0, DELICACIES_VIEW = 1;
    private static int activeView = 0;
    InfoListAdapter cityAdapter;
    InfoListAdapter delicacyAdapter;

    ListView infoList;

    @Subscribe
    public void onRequestDisplayChange(DisplayCitiesEvent dde) {
        activeView = CITIES_VIEW;
        infoList.setAdapter(cityAdapter);
    }

    @Subscribe
    public void onRequestDisplayChange(DisplayDelicaciesEvent dde) {
        activeView = DELICACIES_VIEW;
        infoList.setAdapter(delicacyAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        infoList = (ListView) findViewById(R.id.info_list);

        cityAdapter = new InfoListAdapter(getApplicationContext(), new ArrayList<BaseInfo>(Arrays.asList(new CityInfo[]{
             InfoFactory.createCity("CityOne","CountryOne","This is the first!"),  InfoFactory.createCity("CityTwo","CountryOne","This is the second!"),
                InfoFactory.createCity("CityFour","CountryTwo","This is the third!"), InfoFactory.createCity("CityThree","CountryTwo","This is the fourth!")
        })));

        delicacyAdapter = new InfoListAdapter(getApplicationContext(), new ArrayList<BaseInfo>(Arrays.asList(new DelicacyInfo[]{
                InfoFactory.createDelicacy("Baklava","I have no idea whatsoever"),InfoFactory.createDelicacy("Baklava","I have no idea whatsoever"),
                InfoFactory.createDelicacy("Baklava","I have no idea whatsoever")})));

        Intent intent = getIntent();


        if(intent == null || intent.getIntExtra("viewType", 0)==CITIES_VIEW) {
            activeView = CITIES_VIEW;
            infoList.setAdapter(cityAdapter);
        } else {
            activeView = DELICACIES_VIEW;
            infoList.setAdapter(delicacyAdapter);
        }

        DelicacyApplication.getInstance().setInListView();

    }

    public static void activateCityView(Context context) {
        if(DelicacyApplication.getInstance().isInListView()) {
            if(activeView == CITIES_VIEW) {
                return;
            } else {
                //"just" swap out the adapter...
                DelicacyApplication.postToBus(new DisplayCitiesEvent());
                return;
            }
        }
        Intent intent = createIntent(context, CITIES_VIEW);
        context.startActivity(intent);
    }

    public static void activateDelicacyView(Context context) {
        if(DelicacyApplication.getInstance().isInListView()) {
            if(activeView == DELICACIES_VIEW) {
                return;
            } else {
                DelicacyApplication.postToBus(new DisplayDelicaciesEvent());
                return;
            }
        }
        Intent intent = createIntent(context, DELICACIES_VIEW);
        context.startActivity(intent);
    }

    private static Intent createIntent(Context context, int viewType) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //for not saving history
        intent.putExtra("viewType", viewType);
        return intent;
    }




}
