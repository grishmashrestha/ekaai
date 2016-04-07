package com.lftechnology.Dunite.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lftechnology.Dunite.Dunite;
import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.adapter.ScreenSlidePageAdapter;
import com.lftechnology.Dunite.bus.EventBus;
import com.lftechnology.Dunite.bus.NavigationMenuChangeDetails;
import com.lftechnology.Dunite.bus.PageScrollPosition;
import com.lftechnology.Dunite.bus.SwapFragment;
import com.lftechnology.Dunite.constant.AppConstant;
import com.squareup.otto.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private static final String SELECTED_CONVERSION = "selectedConversion";

    private String mSelectedConversion;
    private int mBottomBackgroundColor, mSwapButtonColor, mDataCount;
    private ViewPager mPagerTop, mPagerBottom;
    private ScreenSlidePageAdapter mPagerAdapterTop, mPagerAdapterBottom;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String selectedConversion) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(SELECTED_CONVERSION, selectedConversion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSelectedConversion = getArguments().getString(SELECTED_CONVERSION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        setBackgroundColorAndLengthBySelectedConversion();

        mPagerTop = (ViewPager) view.findViewById(R.id.pagerTop);
        mPagerBottom = (ViewPager) view.findViewById(R.id.pagerBottom);

        setAdapters();

        ImageView swapButton = (ImageView) view.findViewById(R.id.swapButton);
        swapButton.setBackgroundResource(mSwapButtonColor);

        return view;
    }

    private void setBackgroundColorAndLengthBySelectedConversion() {
        switch (mSelectedConversion) {
            case AppConstant.LENGTH:
                mDataCount = Dunite.getContext().getResources().getStringArray(R.array.length_options).length;
                mBottomBackgroundColor = R.color.colorLengthLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_blue;
                break;
            case AppConstant.TEMPERATURE:
                mDataCount = Dunite.getContext().getResources().getStringArray(R.array.temperature_options).length;
                mBottomBackgroundColor = R.color.colorTemperatureLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_red;
                break;
            case AppConstant.TIME:
                mDataCount = Dunite.getContext().getResources().getStringArray(R.array.time_options).length;
                mBottomBackgroundColor = R.color.colorTimeLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_yellow;
                break;
            case AppConstant.VOLUME:
                mDataCount = Dunite.getContext().getResources().getStringArray(R.array.volume_options).length;
                mBottomBackgroundColor = R.color.colorVolumeLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_purple;
                break;
            case AppConstant.WEIGHT:
                mDataCount = Dunite.getContext().getResources().getStringArray(R.array.weight_options).length;
                mBottomBackgroundColor = R.color.colorWeightLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_green;
                break;
            default:
                mDataCount = Dunite.getContext().getResources().getStringArray(R.array.length_options).length;
                mBottomBackgroundColor = R.color.colorLengthLight;
                mSwapButtonColor = R.color.colorLengthDark;
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        EventBus.post(new PageScrollPosition(position, mSelectedConversion));
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Subscribe
    public void swapFragments(SwapFragment swapFragment) {
        if (swapFragment.swapFlag) {
            int initialTopFragmentPosition = mPagerTop.getCurrentItem();
            int initialBottomFragmentPosition = mPagerBottom.getCurrentItem();
            mPagerTop.setCurrentItem(initialBottomFragmentPosition);
            mPagerBottom.setCurrentItem(initialTopFragmentPosition);
        }
    }

    @Subscribe
    public void updateViewpagers(NavigationMenuChangeDetails navigationMenuChangeDetails) {
        if (mSelectedConversion.equals(navigationMenuChangeDetails.getSelectedConversion())) {
            setAdapters();
//            updateAdapters();
        }
    }

    private void updateAdapters() {
        mPagerAdapterTop.updateDataset(getDataset(mSelectedConversion));
        mPagerAdapterBottom.updateDataset(getDataset(mSelectedConversion));
    }

    public void setAdapters() {
        mPagerTop.removeOnPageChangeListener(this);
        mPagerAdapterTop = new ScreenSlidePageAdapter(getFragmentManager(), true, mSelectedConversion, getDataset(mSelectedConversion));
        mPagerTop.setAdapter(mPagerAdapterTop);
        mPagerTop.setOffscreenPageLimit(mDataCount);
        mPagerTop.addOnPageChangeListener(this);

        mPagerAdapterBottom = new ScreenSlidePageAdapter(getFragmentManager(), false, mSelectedConversion, getDataset(mSelectedConversion));
        mPagerBottom.setAdapter(mPagerAdapterBottom);
        mPagerBottom.setOffscreenPageLimit(mDataCount);
        mPagerBottom.setCurrentItem(1);

        mPagerBottom.setBackgroundResource(mBottomBackgroundColor);
    }

    private String[] getDataset(String mSelectedConversion) {
        String[] dataset;
        SharedPreferences sharedPref = Dunite.getContext().getSharedPreferences(AppConstant.DUNITE, Context.MODE_PRIVATE);
        String preference = sharedPref.getString(mSelectedConversion, AppConstant.NOT_AVAILABLE);
        if (preference.equals(AppConstant.NOT_AVAILABLE)) {
            switch (mSelectedConversion) {
                case AppConstant.LENGTH:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.length_options);
                    break;
                case AppConstant.TEMPERATURE:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.temperature_options);
                    break;
                case AppConstant.TIME:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.time_options);
                    break;
                case AppConstant.VOLUME:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.volume_options);
                    break;
                case AppConstant.WEIGHT:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.weight_options);
                    break;
                default:
                    dataset = Dunite.getContext().getResources().getStringArray(R.array.length_options);
                    break;
            }
        } else {
            Gson gson = new Gson();
            String[] arrayList = gson.fromJson(preference, String[].class);
            dataset = arrayList;
        }
        return dataset;
    }
}
