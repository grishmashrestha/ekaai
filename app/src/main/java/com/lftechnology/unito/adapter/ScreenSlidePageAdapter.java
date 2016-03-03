package com.lftechnology.unito.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lftechnology.unito.R;
import com.lftechnology.unito.Unito;
import com.lftechnology.unito.fragment.ScreenSlideBotFragment;
import com.lftechnology.unito.fragment.ScreenSlideTopFragment;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
    private int mPages = 5;
    private Boolean isTop;
    private String[] mDataset;
    private  String fragmentName;

    public ScreenSlidePageAdapter(FragmentManager fm, Boolean isTop) {
        super(fm);
        this.isTop = isTop;
        setDatasetAndPageCount();
    }

    @Override
    public Fragment getItem(int position) {
        if (isTop) {
            return ScreenSlideTopFragment.newInstance(position, mDataset);
        } else {
            return ScreenSlideBotFragment.newInstance(position, mDataset, fragmentName);
        }
    }

    @Override
    public int getCount() {
        return mPages;
    }

    private void setDatasetAndPageCount() {
        String className = Unito.getContext().getClass().getName();
        String[] dataset;
        switch (className) {
            case "com.lftechnology.unito.fragment.LengthFragment":
                dataset = Unito.getContext().getResources().getStringArray(R.array.length_options);
                fragmentName = "Length";
                break;
            case "com.lftechnology.unito.fragment.TemperatureFragment":
                dataset = Unito.getContext().getResources().getStringArray(R.array.temperature_options);
                fragmentName = "Length";
                break;
            case "com.lftechnology.unito.fragment.TimeFragment":
                dataset = Unito.getContext().getResources().getStringArray(R.array.time_options);
                break;
            case "com.lftechnology.unito.fragment.VolumeFragment":
                dataset = Unito.getContext().getResources().getStringArray(R.array.volume_options);
                break;
            case "com.lftechnology.unito.fragment.WeightFragment":
                dataset = Unito.getContext().getResources().getStringArray(R.array.weight_options);
                break;
            default:
                dataset = Unito.getContext().getResources().getStringArray(R.array.time_options);
                break;
        }
        mDataset = dataset;
        mPages = mDataset.length;
    }
}
