package com.lftechnology.Dunite.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.google.gson.Gson;
import com.lftechnology.Dunite.Dunite;
import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.constant.AppConstant;
import com.lftechnology.Dunite.fragment.ScreenSlideBotFragment;
import com.lftechnology.Dunite.fragment.ScreenSlideTopFragment;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */

/**
 * PageAdapter for ViewPager
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
            return ScreenSlideTopFragment.newInstance(position, mDataset, mSelectedConversion);
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
        SharedPreferences sharedPref = Dunite.getContext().getSharedPreferences("Dunite", Context.MODE_PRIVATE);
        String preference = sharedPref.getString(mSelectedConversion, "N/A");
        if (preference.equals("N/A")) {
            switch (mSelectedConversion) {
                case AppConstant.LENGTH:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.length_options);
                    fragmentName = AppConstant.LENGTH;
                    break;
                case AppConstant.TEMPERATURE:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.temperature_options);
                    fragmentName = AppConstant.TEMPERATURE;
                    break;
                case AppConstant.TIME:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.time_options);
                    fragmentName = AppConstant.TIME;
                    break;
                case AppConstant.VOLUME:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.volume_options);
                    fragmentName = AppConstant.VOLUME;
                    break;
                case AppConstant.WEIGHT:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.weight_options);
                    fragmentName = AppConstant.WEIGHT;
                    break;
                default:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.length_options);
                    fragmentName = AppConstant.LENGTH;
                    break;
            }
        }
        else {
            Gson gson = new Gson();
            String[] arrayList = gson.fromJson(preference, String[].class);
            dataset = arrayList;
            fragmentName = mSelectedConversion;
        }
        mDataset = dataset;
    }
}
