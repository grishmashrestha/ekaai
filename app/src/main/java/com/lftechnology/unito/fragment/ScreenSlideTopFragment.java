package com.lftechnology.unito.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lftechnology.unito.R;
import com.lftechnology.unito.bus.ConvertedValue;
import com.lftechnology.unito.bus.EventBus;

import timber.log.Timber;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlideTopFragment extends BaseFragment {

    private static final String POSITION = "position";
    private static final String DATASET = "dataset";

    // TODO: Rename and change types of parameters
    private int mPosition;
    private String[] mDataset;

    public ScreenSlideTopFragment() {
    }


    public static ScreenSlideTopFragment newInstance(int position, String[] dataset) {
        ScreenSlideTopFragment fragment = new ScreenSlideTopFragment();
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
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_slider_top, container, false);

        final TextView tv = (TextView) rootView.findViewById(R.id.scroll_top);
        tv.setText(mDataset[mPosition]);

        final EditText fromUnit = (EditText) rootView.findViewById(R.id.from_unit);

        fromUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                changeFontSize(s, fromUnit);
            }

            @Override
            public void afterTextChanged(Editable s) {
                EventBus.post(new ConvertedValue(s.toString().trim(), mDataset[mPosition]));
            }
        });
        return rootView;
    }

    private void changeFontSize(CharSequence s, EditText et) {
        float stringLength = s.length();
        Timber.d(String.valueOf(stringLength));
        float fontSize;
        if (stringLength <= 6) {
            fontSize = 100;
        } else if (stringLength <= 7) {
            fontSize = 90;
        } else if (stringLength <= 8) {
            fontSize = 80;
        } else if (stringLength <= 9) {
            fontSize = 70;
        } else if (stringLength <= 10) {
            fontSize = 60;
        } else if (stringLength <= 12) {
            fontSize = 50;
        } else {
            fontSize = 20;
        }
        Timber.d(String.valueOf(fontSize));
        et.setTextSize(fontSize);
    }

}