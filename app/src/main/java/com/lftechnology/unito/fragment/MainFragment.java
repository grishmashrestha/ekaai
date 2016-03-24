package com.lftechnology.unito.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lftechnology.unito.R;
import com.lftechnology.unito.Unito;
import com.lftechnology.unito.adapter.ScreenSlidePageAdapter;
import com.lftechnology.unito.bus.EventBus;
import com.lftechnology.unito.bus.NavigationMenuChangeDetails;
import com.lftechnology.unito.bus.PageScrollPosition;
import com.lftechnology.unito.bus.SwapFragment;
import com.lftechnology.unito.constant.AppConstant;
import com.lftechnology.unito.helper.OnStartDragListener;
import com.squareup.otto.Subscribe;

import timber.log.Timber;

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
    private PagerAdapter mPagerAdapterTop, mPagerAdapterBottom;

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
        mPagerAdapterTop = new ScreenSlidePageAdapter(getFragmentManager(), true, mSelectedConversion);
        mPagerTop.setAdapter(mPagerAdapterTop);
        mPagerTop.setOffscreenPageLimit(mDataCount);
        mPagerTop.addOnPageChangeListener(this);

        mPagerBottom = (ViewPager) view.findViewById(R.id.pagerBottom);
        mPagerAdapterBottom = new ScreenSlidePageAdapter(getFragmentManager(), false, mSelectedConversion);
        mPagerBottom.setAdapter(mPagerAdapterBottom);
        mPagerBottom.setOffscreenPageLimit(mDataCount);
        mPagerBottom.setCurrentItem(1);

        mPagerBottom.setBackgroundResource(mBottomBackgroundColor);
        ImageView swapButton = (ImageView) view.findViewById(R.id.swapButton);
        swapButton.setBackgroundResource(mSwapButtonColor);

        return view;
    }

    private void setBackgroundColorAndLengthBySelectedConversion() {
        switch (mSelectedConversion) {
            case AppConstant.LENGTH:
                mDataCount = Unito.getContext().getResources().getStringArray(R.array.length_options).length;
                mBottomBackgroundColor = R.color.colorLengthLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_blue;
                break;
            case AppConstant.TEMPERATURE:
                mDataCount = Unito.getContext().getResources().getStringArray(R.array.temperature_options).length;
                mBottomBackgroundColor = R.color.colorTemperatureLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_red;
                break;
            case AppConstant.TIME:
                mDataCount = Unito.getContext().getResources().getStringArray(R.array.time_options).length;
                mBottomBackgroundColor = R.color.colorTimeLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_yellow;
                break;
            case AppConstant.VOLUME:
                mDataCount = Unito.getContext().getResources().getStringArray(R.array.volume_options).length;
                mBottomBackgroundColor = R.color.colorVolumeLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_purple;
                break;
            case AppConstant.WEIGHT:
                mDataCount = Unito.getContext().getResources().getStringArray(R.array.weight_options).length;
                mBottomBackgroundColor = R.color.colorWeightLight;
                mSwapButtonColor = R.drawable.swap_btn_cont_green;
                break;
            default:
                mDataCount = Unito.getContext().getResources().getStringArray(R.array.length_options).length;
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
//            Timber.e("This is Manas. Trying to be Barbie Girl!");
//            mPagerAdapterTop.notifyDataSetChanged();
//            mPagerAdapterBottom.notifyDataSetChanged();
            mPagerAdapterTop = new ScreenSlidePageAdapter(getFragmentManager(), true, mSelectedConversion);
            mPagerTop.setAdapter(mPagerAdapterTop);
        }
    }
}
