package com.lftechnology.ekaai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lftechnology.ekaai.bus.ConvertedValue;
import com.lftechnology.ekaai.fragment.ScreenSlideBotFragment;
import com.lftechnology.ekaai.fragment.ScreenSlideTopFragment;
import com.lftechnology.ekaai.helper.OnInputValueChangeListener;

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
}
