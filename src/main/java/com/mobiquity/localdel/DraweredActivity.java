package com.mobiquity.localdel;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import com.example.LocalDel.R;

/**
 * Created by dalexander on 7/22/14.
 */
public class DraweredActivity extends Activity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private String appTitle;
    private String drawerTitle;
    DrawerFragment drawerFragment = new DrawerFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appTitle = drawerTitle = "LocalDel";
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(appTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                Log.d("com.mobiquity.localdel.DraweredActivity", "Drawer finished closing "+System.currentTimeMillis());
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(drawerToggle);

        //call the fragment here
        getFragmentManager().beginTransaction().add(drawerFragment,"Drawer_Fragment").commit();

        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    protected void closeDrawer() {
        Log.d("com.mobiquity.localdel.DraweredActivity", "Drawer starting to close "+System.currentTimeMillis());

        Handler h = new Handler(Looper.getMainLooper());

        //for some reason the drawer doesn't animate closing when closerDrawers() is directly called
        h.post(new Runnable() {
            public void run() {
                drawerLayout.closeDrawers();
            }
        });

    }

    @Override
    public void onResume()
    {
        super.onResume();
        DelicacyApplication.getInstance().getBus().register(this);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        DelicacyApplication.getInstance().getBus().unregister(this);
    }
}
