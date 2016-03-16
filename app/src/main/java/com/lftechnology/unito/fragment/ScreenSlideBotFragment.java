package com.lftechnology.unito.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lftechnology.unito.R;
import com.lftechnology.unito.bus.ConvertedValue;
import com.lftechnology.unito.constant.AppConstant;
import com.lftechnology.unito.conversions.Length;
import com.lftechnology.unito.conversions.Temperature;
import com.lftechnology.unito.conversions.Time;
import com.lftechnology.unito.conversions.Volume;
import com.lftechnology.unito.conversions.Weight;
import com.lftechnology.unito.utils.AutoResizeFontTextView;
import com.squareup.otto.Subscribe;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlideBotFragment extends BaseFragment {

    private static final String POSITION = "position";
    private static final String DATASET = "dataset";
    private static final String FRAGMENT_NAME = "fragmentName";

    // TODO: Rename and change types of parameters
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
        tv.setText(String.valueOf(returnValue));
        AutoResizeFontTextView.changeFontSize(String.valueOf(returnValue), tv);
    }

    private Double applyConversion(double currentValue, String mFragmentName, String from) {
        String to = mDataset[mPosition];
        Double returnValue;
        switch (mFragmentName) {
            case AppConstant.LENGTH:
                returnValue = lengthConversion(currentValue, from, to);
                break;
            case AppConstant.TEMPERATURE:
                returnValue = temperatureConversion(currentValue, from, to);
                break;
            case AppConstant.TIME:
                returnValue = timeConversion(currentValue, from, to);
                break;
            case AppConstant.WEIGHT:
                returnValue = weightConversion(currentValue, from, to);
                break;
            case AppConstant.VOLUME:
                returnValue = volumeConversion(currentValue, from, to);
                break;
            default:
                returnValue = 0.0;
                break;
        }
        return returnValue;
    }

    private Double lengthConversion(double currentValue, String from, String to) {
        Length length = new Length(currentValue, from, to);
        return length.convert();
    }

    private Double temperatureConversion(double currentValue, String from, String to) {
        Temperature temperature = new Temperature(currentValue, from, to);
        return temperature.convert();
    }

    private Double timeConversion(double currentValue, String from, String to) {
        Time time = new Time(currentValue, from, to);
        return time.convert();
    }

    private Double volumeConversion(double currentValue, String from, String to) {
        Volume volume = new Volume(currentValue, from, to);
        return volume.convert();
    }

    private Double weightConversion(double currentValue, String from, String to) {
        Weight weight = new Weight(currentValue, from, to);
        return weight.convert();
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