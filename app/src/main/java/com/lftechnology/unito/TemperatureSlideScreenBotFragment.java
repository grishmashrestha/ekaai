package com.lftechnology.unito;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/25/16.
 */
public class TemperatureSlideScreenBotFragment extends Fragment {
    private static final String POSITION = "position";

    private String[] mDataset;
    private int mPosition;

    public TemperatureSlideScreenBotFragment() {

    }

    public static TemperatureSlideScreenBotFragment newInstance(int position) {
        TemperatureSlideScreenBotFragment fragment = new TemperatureSlideScreenBotFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mDataset = getActivity().getResources().getStringArray(R.array.temperature_options);
        View view = inflater.inflate(R.layout.fragment_temperature_slider_bot, container, false);
        TextView tv = (TextView) view.findViewById(R.id.temperature_scroll_bot);
        tv.setText(mDataset[mPosition]);
        return view;
    }
}
