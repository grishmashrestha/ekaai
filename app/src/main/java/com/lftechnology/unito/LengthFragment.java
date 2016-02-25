package com.lftechnology.unito;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LengthFragment extends Fragment {
    private int mPages;
    private ViewPager mPager1, mPager2;
    private PagerAdapter mPagerAdapter1, mPagerAdapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPages = getContext().getResources().getStringArray(R.array.length_options).length;
        View view = inflater.inflate(R.layout.fragment_length, container, false);

        mPager1 = (ViewPager) view.findViewById(R.id.pager);
        mPagerAdapter1 = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager1.setAdapter(mPagerAdapter1);

        mPager2 = (ViewPager) view.findViewById(R.id.pager2);
        mPagerAdapter2 = new ScreenSlideBotPagerAdapter(getFragmentManager());
        mPager2.setAdapter(mPagerAdapter2);


        return view;
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return LengthSlideScreenTopFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return mPages;
        }
    }

    private class ScreenSlideBotPagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlideBotPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return LengthSlideScreenBotFragment.newInstance(position);        }

        @Override
        public int getCount() {
            return mPages;
        }
    }
}
