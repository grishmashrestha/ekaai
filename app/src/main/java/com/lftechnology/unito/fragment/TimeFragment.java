package com.lftechnology.unito.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lftechnology.unito.R;
import com.lftechnology.unito.adapter.ScreenSlidePageAdapter;
import com.lftechnology.unito.bus.EventBus;
import com.lftechnology.unito.bus.PageScrollPosition;

import timber.log.Timber;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment implements ViewPager.OnPageChangeListener {
    ViewPager mPager1, mPager2;
    PagerAdapter mPagerAdapter1, mPagerAdapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        mPager1 = (ViewPager) view.findViewById(R.id.pager);
        mPagerAdapter1 = new ScreenSlidePageAdapter(getFragmentManager(), true);
        mPager1.setAdapter(mPagerAdapter1);
        mPager1.setOffscreenPageLimit(13);
        mPager1.addOnPageChangeListener(this);

        mPager2 = (ViewPager) view.findViewById(R.id.pager2);
        mPagerAdapter2 = new ScreenSlidePageAdapter(getFragmentManager(), false);
        mPager2.setAdapter(mPagerAdapter2);
        mPager2.setOffscreenPageLimit(13);
        mPager2.setCurrentItem(1);

        return  view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        EventBus.post(new PageScrollPosition(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
