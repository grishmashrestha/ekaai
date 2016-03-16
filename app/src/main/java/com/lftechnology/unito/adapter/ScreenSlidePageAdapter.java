package com.lftechnology.unito.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lftechnology.unito.R;
import com.lftechnology.unito.Unito;
import com.lftechnology.unito.constant.AppConstant;
import com.lftechnology.unito.fragment.ScreenSlideBotFragment;
import com.lftechnology.unito.fragment.ScreenSlideTopFragment;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
    private Boolean isTop;
    private String[] mDataset;
    private String fragmentName;
    private String mSelectedConversion;

    public ScreenSlidePageAdapter(FragmentManager fm, Boolean isTop, String selectedConversion) {
        super(fm);
        this.isTop = isTop;
        mSelectedConversion = selectedConversion;
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
        return mDataset.length;
    }

    private void setDatasetAndPageCount() {
        String[] dataset;
        switch (mSelectedConversion) {
            case AppConstant.LENGTH:
                dataset = Unito.getContext().getResources().getStringArray(R.array.length_options);
                fragmentName = AppConstant.LENGTH;
                break;
            case AppConstant.TEMPERATURE:
                dataset = Unito.getContext().getResources().getStringArray(R.array.temperature_options);
                fragmentName = AppConstant.TEMPERATURE;
                break;
            case AppConstant.TIME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.time_options);
                fragmentName = AppConstant.TIME;
                break;
            case AppConstant.VOLUME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.volume_options);
                fragmentName = AppConstant.VOLUME;
                break;
            case AppConstant.WEIGHT:
                dataset = Unito.getContext().getResources().getStringArray(R.array.weight_options);
                fragmentName = AppConstant.WEIGHT;
                break;
            default:
                dataset = Unito.getContext().getResources().getStringArray(R.array.length_options);
                fragmentName = AppConstant.LENGTH;
                break;
        }
        mDataset = dataset;
    }
}
