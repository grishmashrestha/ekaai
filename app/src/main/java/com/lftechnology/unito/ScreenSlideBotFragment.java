package com.lftechnology.unito;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlideBotFragment  extends Fragment {

    private static final String POSITION = "position";
    private static final String DATASET = "dataset";

    // TODO: Rename and change types of parameters
    private int mPosition;
    private String[] mDataset;

    public ScreenSlideBotFragment() {
        // Required empty public constructor
    }

    public static ScreenSlideBotFragment newInstance(int position, String[] dataset) {
        ScreenSlideBotFragment fragment = new ScreenSlideBotFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        args.putStringArray(DATASET, dataset);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
            mDataset = getArguments().getStringArray(DATASET);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_slider_bot, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.scroll_bot);
        tv.setText(mDataset[mPosition]);
        return rootView;
    }
}