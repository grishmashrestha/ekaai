package com.lftechnology.ekaai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.adapter.ScreenSlidePageAdapter;
import com.lftechnology.ekaai.bus.EventBus;
import com.lftechnology.ekaai.bus.PageScrollPosition;
import com.lftechnology.ekaai.bus.SwapFragment;
import com.lftechnology.ekaai.constant.AppConstant;
import com.lftechnology.ekaai.helper.OnDatasetChangedListener;
import com.lftechnology.ekaai.utils.ApplicationThemeAndDataset;
import com.squareup.otto.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener, ScreenSlideTopFragment.CustomEditTextOnTouch, OnDatasetChangedListener {
    private static final String SELECTED_CONVERSION = "selectedConversion";

    private String mSelectedConversion;
    private int mBottomBackgroundColor, mSwapButtonColor, mDataCount;
    private ViewPager mPagerTop, mPagerBottom;
    private ScreenSlidePageAdapter mPagerAdapterTop, mPagerAdapterBottom;
    private ImageView mSwapButton;

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

        mSwapButton = (ImageView) view.findViewById(R.id.swapButton);
        mSwapButton.setBackgroundResource(mSwapButtonColor);

        ScreenSlideTopFragment.setCustomEditTextOnTouch(this);

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

    @Override
    public void updateViewpagersOnNavigationMenuDatasetChange(String selectedConversion) {
        if (mSelectedConversion.equals(selectedConversion)) {
            setAdapters();
        }
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

    @Override
    public void editTextOnTouch() {
        // hide swap button
        if (mSwapButton.getVisibility() == View.VISIBLE) {
            mSwapButton.clearAnimation();
            Animation scaleOut = new ScaleAnimation(1, 0, 1, 0, mSwapButton.getWidth() / 2, mSwapButton.getHeight() / 2);
            scaleOut.setInterpolator(new AccelerateInterpolator());
            scaleOut.setStartOffset(0); // Start fading out after 500 milli seconds
            scaleOut.setDuration(AppConstant.SWAP_BUTTON_ANIMATION_TIME_800); // Fadeout duration should be 1000 milli seconds
            Animation fadeOut = new AlphaAnimation(1, 0);  // the 1, 0 here notifies that we want the opacity to go from opaque (1) to transparent (0)
            fadeOut.setInterpolator(new AccelerateInterpolator());
            fadeOut.setStartOffset(0); // Start fading out after 500 milli seconds
            fadeOut.setDuration(AppConstant.SWAP_BUTTON_ANIMATION_TIME_800); // Fadeout duration should be 1000 milli seconds

            AnimationSet animation = new AnimationSet(false); // change to false
            animation.addAnimation(scaleOut);
            animation.addAnimation(fadeOut);
            animation.setRepeatCount(1);
            mSwapButton.setAnimation(animation);
            mSwapButton.setVisibility(View.INVISIBLE);
        }
    }


}
