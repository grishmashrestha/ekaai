package com.lftechnology.unito;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.lftechnology.unito.bus.EventBus;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/2/16.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.unregister(this);
    }
}
