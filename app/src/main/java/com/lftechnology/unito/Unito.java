package com.lftechnology.unito;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by grishma on 2/24/16.
 */
public class Unito extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
