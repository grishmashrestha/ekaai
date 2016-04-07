package com.lftechnology.Dunite.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lftechnology.Dunite.fragment.ScreenSlideBotFragment;
import com.lftechnology.Dunite.fragment.ScreenSlideTopFragment;

import timber.log.Timber;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */

/**
 * PageAdapter for ViewPager
 */
public class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {
    private Boolean isTop;
    private String[] mDataset;
    private String mSelectedConversion;

    public ScreenSlidePageAdapter(FragmentManager fm, Boolean isTop, String selectedConversion, String[] dataset) {
        super(fm);
        this.isTop = isTop;
        mSelectedConversion = selectedConversion;
        mDataset = dataset;
    }

    @Override
    public Fragment getItem(int position) {
        if (isTop) {
            return ScreenSlideTopFragment.newInstance(position, mDataset, mSelectedConversion);
        } else {
            return ScreenSlideBotFragment.newInstance(position, mDataset, mSelectedConversion);
        }
    }

    @Override
    public int getCount() {
        return mDataset.length;
    }

    public void updateDataset(String[] dataset) {
        mDataset = dataset;
        notifyDataSetChanged();
    }
}
