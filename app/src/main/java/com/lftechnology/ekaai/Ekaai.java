package com.lftechnology.ekaai;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/24/16.
 */

/**
 * Base application class
 */
public class Ekaai extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
