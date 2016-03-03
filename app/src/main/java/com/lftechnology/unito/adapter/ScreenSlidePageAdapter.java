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
    private int mPages = 5;
    private Boolean isTop;
    private String[] mDataset;
    private String mCurrentFragmentName;
    private  String fragmentName;

    public ScreenSlidePageAdapter(FragmentManager fm, Boolean isTop) {
        super(fm);
        this.isTop = isTop;
        mCurrentFragmentName = fm.getFragments().get(0).getClass().getName();
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
        String[] dataset;
        switch (mCurrentFragmentName) {
            case AppConstant.LENGTH_FRAGMENT_NAME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.length_options);
                fragmentName = AppConstant.LENGTH;
                break;
            case AppConstant.TEMPERATURE_FRAGMENT_NAME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.temperature_options);
                fragmentName = AppConstant.TEMPERATURE;
                break;
            case AppConstant.TIME_FRAGMENT_NAME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.time_options);
                fragmentName =  AppConstant.TIME;
                break;
            case AppConstant.VOLUME_FRAGMENT_NAME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.volume_options);
                fragmentName =  AppConstant.VOLUME;
                break;
            case AppConstant.WEIGHT_FRAGMENT_NAME:
                dataset = Unito.getContext().getResources().getStringArray(R.array.weight_options);
                fragmentName =  AppConstant.WEIGHT;
                break;
            default:
                dataset = Unito.getContext().getResources().getStringArray(R.array.length_options);
                fragmentName =  AppConstant.LENGTH;
                break;
        }
        mDataset = dataset;
        mPages = mDataset.length;
    }
}
