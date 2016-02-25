package com.lftechnology.unito;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/25/16.
 */
public class LengthSlideScreenTopFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_length_slider_top, container, false);
        return rootView;
    }
}
