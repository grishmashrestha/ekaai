package com.lftechnology.unito;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import timber.log.Timber;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
    private int mPages = 5;
    Fragment fragment;
    private Boolean isTop;
    private String[] mDataset;

    public ScreenSlidePageAdapter(FragmentManager fm, Fragment fragment, Boolean isTop) {
        super(fm);
        this.fragment = fragment;
        this.isTop = isTop;
        setDatasetAndPageCount();
    }

    @Override
    public Fragment getItem(int position) {
        if (isTop) {
            return ScreenSlideTopFragment.newInstance(position, mDataset);
        } else {
            return ScreenSlideBotFragment.newInstance(position, mDataset);
        }
    }

    @Override
    public int getCount() {
        return mPages;
    }

    private void setDatasetAndPageCount() {
        String className = fragment.getClass().getName();
        String[] dataset;
        switch (className) {
            case "com.lftechnology.unito.LengthFragment":
                dataset = fragment.getResources().getStringArray(R.array.length_options);
                break;
            case "com.lftechnology.unito.TemperatureFragment":
                dataset = fragment.getResources().getStringArray(R.array.temperature_options);
                break;
            case "com.lftechnology.unito.TimeFragment":
                dataset = fragment.getResources().getStringArray(R.array.time_options);
                break;
            case "com.lftechnology.unito.VolumeFragment":
                dataset = fragment.getResources().getStringArray(R.array.volume_options);
                break;
            case "com.lftechnology.unito.WeightFragment":
                dataset = fragment.getResources().getStringArray(R.array.weight_options);
                break;
            default:
                dataset = fragment.getResources().getStringArray(R.array.time_options);
                break;
        }
        mDataset = dataset;
        mPages = mDataset.length;
    }
}
