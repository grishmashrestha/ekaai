package com.lftechnology.Dunite.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.adapter.ScreenSlidePageAdapter;
import com.lftechnology.Dunite.bus.EventBus;
import com.lftechnology.Dunite.bus.NavigationMenuChangeDetails;
import com.lftechnology.Dunite.bus.PageScrollPosition;
import com.lftechnology.Dunite.bus.SwapFragment;
import com.lftechnology.Dunite.utils.ApplicationThemeAndDataset;
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
        Integer[] themeDetails = ApplicationThemeAndDataset.getThemeDetails(mSelectedConversion);
        mDataCount = themeDetails[0];
        mBottomBackgroundColor = themeDetails[1];
        mSwapButtonColor = themeDetails[2];
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
        String[] dataset = ApplicationThemeAndDataset.getDataset(mSelectedConversion);
        mPagerAdapterTop.updateDataset(dataset);
        mPagerAdapterBottom.updateDataset(dataset);
    }

    public void setAdapters() {
        String[] dataset = ApplicationThemeAndDataset.getDataset(mSelectedConversion);
        mPagerTop.removeOnPageChangeListener(this);
        mPagerAdapterTop = new ScreenSlidePageAdapter(getFragmentManager(), true, mSelectedConversion, dataset);
        mPagerTop.setAdapter(mPagerAdapterTop);
        mPagerTop.setOffscreenPageLimit(mDataCount);
        mPagerTop.addOnPageChangeListener(this);

        mPagerAdapterBottom = new ScreenSlidePageAdapter(getFragmentManager(), false, mSelectedConversion, dataset);
        mPagerBottom.setAdapter(mPagerAdapterBottom);
        mPagerBottom.setOffscreenPageLimit(mDataCount);
        mPagerBottom.setCurrentItem(1);

        mPagerBottom.setBackgroundResource(mBottomBackgroundColor);
    }
}
