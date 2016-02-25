package com.lftechnology.unito;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/25/16.
 */
public class LengthSlideScreenBotFragment extends Fragment {
    private static final String POSITION = "position";

    // TODO: Rename and change types of parameters
    private int mPosition;

    public LengthSlideScreenBotFragment() {
        // Required empty public constructor
    }

    public static LengthSlideScreenBotFragment newInstance(int position) {
        LengthSlideScreenBotFragment fragment = new LengthSlideScreenBotFragment();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_length_slider_bot, container, false);
        TextView tv = (TextView) rootView.findViewById(R.id.length_scroll_bot);
        tv.setText(""+mPosition+"");
        return rootView;
    }
}
