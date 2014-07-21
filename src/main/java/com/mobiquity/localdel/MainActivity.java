package com.mobiquity.localdel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.example.LocalDel.R;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    /**
     * Called when the context is first created.
     */

    private String[] drawerTitles;
    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawerList;


    private String mTitle;
    private String mDrawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        InfoListAdapter cityListAdapter = new InfoListAdapter(getApplicationContext(), new ArrayList<BaseInfo>(Arrays.asList(new CityInfo[]{
             CityFactory.createCity("CityOne","CountryOne","This is the first!"),  CityFactory.createCity("CityTwo","CountryOne","This is the second!"),
                 CityFactory.createCity("CityFour","CountryTwo","This is the third!"), CityFactory.createCity("CityThree","CountryTwo","This is the fourth!")
        })));
        ListView cityList = (ListView) findViewById(R.id.CityList);

        cityList.setAdapter(cityListAdapter);

        InfoListAdapter delicacyListAdapter = new InfoListAdapter(getApplicationContext(), new ArrayList<BaseInfo>(Arrays.asList(new DelicacyInfo[]{
                DelicacyFactory.createDelicacy("Baklava","I have no idea whatsoever"),DelicacyFactory.createDelicacy("Baklava","I have no idea whatsoever"),
                        DelicacyFactory.createDelicacy("Baklava","I have no idea whatsoever")})));
        ListView delicacyList = (ListView) findViewById(R.id.CityList);

        cityList.setAdapter(delicacyListAdapter);

        drawerTitles = new String[]{getString(R.string.drawer_location),getString(R.string.drawer_delicacy)};

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (LinearLayout) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        /*mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, drawerTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                MainActivity.activateActivity(getApplicationContext());
                //DelicacyActivity.activateActivity(getApplicationContext());
            }

        });*/

        findViewById(R.id.city_drawer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.activateActivity(getApplicationContext());
            }
        });

        findViewById(R.id.delicacy_drawer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DelicacyActivity.activateActivity(getApplicationContext());
            }
        });

        mTitle = mDrawerTitle = getTitle().toString();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);



    }

    public static void activateActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        //menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


}
