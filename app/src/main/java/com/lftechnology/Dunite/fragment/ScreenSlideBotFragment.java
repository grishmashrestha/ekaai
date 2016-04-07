package com.lftechnology.Dunite.fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.bus.ConvertedValue;
import com.lftechnology.Dunite.constant.AppConstant;
import com.lftechnology.Dunite.conversions.Length;
import com.lftechnology.Dunite.conversions.Temperature;
import com.lftechnology.Dunite.conversions.Time;
import com.lftechnology.Dunite.conversions.Unit;
import com.lftechnology.Dunite.conversions.Volume;
import com.lftechnology.Dunite.conversions.Weight;
import com.lftechnology.Dunite.helper.GestureListener;
import com.lftechnology.Dunite.utils.AutoResizeFontTextView;
import com.lftechnology.Dunite.utils.ResultFormatter;
import com.squareup.otto.Subscribe;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlideBotFragment extends BaseFragment {

    private static final String POSITION = "position";
    private static final String DATASET = "dataset";
    private static final String FRAGMENT_NAME = "fragmentName";

    private int mPosition;
    private String[] mDataset;
    private ViewGroup mView;
    private String mParentFragmentName;

    public ScreenSlideBotFragment() {
        // Required empty public constructor
    }

    @Subscribe
    public void answerAvailable(ConvertedValue val) {
        convertToCurrentUnit(val);
    }

    public static ScreenSlideBotFragment newInstance(int position, String[] dataset, String fragmentName) {
        ScreenSlideBotFragment fragment = new ScreenSlideBotFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        args.putStringArray(DATASET, dataset);
        args.putString(FRAGMENT_NAME, fragmentName);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
            mDataset = getArguments().getStringArray(DATASET);
            mParentFragmentName = getArguments().getString(FRAGMENT_NAME);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = (ViewGroup) inflater.inflate(R.layout.fragment_slider_bot, container, false);
//        View gestureView = mView.findViewById(R.id.content_bot);
//        gestureView.setClickable(true);
//        gestureView.setFocusable(true);
//        GestureDetector.SimpleOnGestureListener gestureListener = new GestureListener();
//        final GestureDetector gd = new GestureDetector(getActivity(), gestureListener);
//        assert gestureView != null;
//        gestureView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                gd.onTouchEvent(motionEvent);
//                return false;
//            }
//        });

        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = (TextView) mView.findViewById(R.id.scroll_bot);
        tv.setText(mDataset[mPosition]);
    }

    private void convertToCurrentUnit(ConvertedValue val) {
        double currentValue = changeToDouble(val.getValue());

        Double returnValue = applyConversion(currentValue, mParentFragmentName, val.getFrom());
        TextView tv = (TextView) mView.findViewById(R.id.to_unit);
        String result;
        if (mParentFragmentName.equals(AppConstant.TEMPERATURE)) {
            result = ResultFormatter.format(returnValue, 2);
        } else {
            result = ResultFormatter.format(returnValue, 3);
        }
        tv.setText(result);
        AutoResizeFontTextView.changeFontSize(result, tv);
    }

    private Double applyConversion(double currentValue, String mFragmentName, String from) {
        String to = mDataset[mPosition];
        Unit unit = null;
        switch (mFragmentName) {
            case AppConstant.LENGTH:
                unit = new Length(currentValue, from, to);
                break;
            case AppConstant.TEMPERATURE:
                unit = new Temperature(currentValue, from, to);
                break;
            case AppConstant.TIME:
                unit = new Time(currentValue, from, to);
                break;
            case AppConstant.WEIGHT:
                unit = new Weight(currentValue, from, to);
                break;
            case AppConstant.VOLUME:
                unit = new Volume(currentValue, from, to);
                break;
            default:
                break;
        }
        return unit.convert();
    }

    private Double changeToDouble(String val) {
        Double returnValue;
        try {
            returnValue = Double.parseDouble(val);
        } catch (NumberFormatException e) {
            returnValue = 0.0;
        }
        return returnValue;
    }

}