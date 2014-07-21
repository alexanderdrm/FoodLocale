package com.mobiquity.localdel;

/**
 * Created by dalexander on 7/21/14.
 */

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import com.squareup.otto.Bus;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import com.mobiquity.localdel.BaseEvent;
import com.squareup.otto.Bus;

/**
 * Created by dalexander on 7/15/14.
 */
public class DelicacyApplication extends Application {

    private static DelicacyApplication instance = new DelicacyApplication();

    private static final String TAG = "Lifecycle " + DelicacyApplication.class.getName();

    /*private CalculatorApplication() {

    }*/

    public static DelicacyApplication getInstance() {
        return instance;
    }

    /*private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public static void postToBus( BaseEvent event) {
        getInstance().getBus().post( event );
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.instance.bus = new Bus();

        Log.d(TAG, "onCreate()");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.d(TAG, "onTerminate()");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, "onConfigurationChanged()");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Log.d(TAG, "onLowMemory()");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        Log.d(TAG, "onTrim()");
    }*/

}
