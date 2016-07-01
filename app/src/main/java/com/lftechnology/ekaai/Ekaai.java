package com.lftechnology.ekaai;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

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

    /**
     * Gives the {@link Context} of the app
     *
     * @return {@link Context} the app belongs to
     */
    public static Context getContext() {
        return context;
    }
}
