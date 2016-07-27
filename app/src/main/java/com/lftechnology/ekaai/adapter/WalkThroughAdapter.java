package com.lftechnology.ekaai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lftechnology.ekaai.fragment.WalkThroughFragment;

public class WalkThroughAdapter extends FragmentStatePagerAdapter {
    public static final int DATA_COUNT = 2;

    public WalkThroughAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       return WalkThroughFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return DATA_COUNT;
    }
}