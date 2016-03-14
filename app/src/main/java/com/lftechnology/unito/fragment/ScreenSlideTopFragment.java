package com.lftechnology.unito.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.lftechnology.unito.R;
import com.lftechnology.unito.bus.ConvertedValue;
import com.lftechnology.unito.bus.EventBus;
import com.lftechnology.unito.bus.PageScrollPosition;
import com.lftechnology.unito.utils.AutoResizeFontTextView;
import com.lftechnology.unito.utils.SoftKeyBoard;
import com.squareup.otto.Subscribe;

import timber.log.Timber;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlideTopFragment extends BaseFragment {

    private static final String POSITION = "position";
    private static final String DATASET = "dataset";
    private int mVisibleFragmentPosition;
    private int mPosition;
    private String[] mDataset;

    ViewGroup mRootView;
    EditText mFromUnit;

    public ScreenSlideTopFragment() {
    }


    public static ScreenSlideTopFragment newInstance(int position, String[] dataset) {
        ScreenSlideTopFragment fragment = new ScreenSlideTopFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        args.putStringArray(DATASET, dataset);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
            mDataset = getArguments().getStringArray(DATASET);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_slider_top, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView tv = (TextView) mRootView.findViewById(R.id.scroll_top);
        tv.setText(mDataset[mPosition]);

        mFromUnit = (EditText) mRootView.findViewById(R.id.from_unit);
        if (mPosition == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    EventBus.post(new ConvertedValue(mFromUnit.getText().toString().trim(), mDataset[mPosition], mPosition));
                }
            }, 2);
        }

        mFromUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                AutoResizeFontTextView.changeFontSize(s, mFromUnit);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mPosition == mVisibleFragmentPosition) {
                    EventBus.post(new ConvertedValue(s.toString().trim(), mDataset[mPosition], mPosition));
                }
            }
        });

        mFromUnit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                SoftKeyBoard.hideSoftKeyboard(getContext(), v);
            }
        });
    }

    @Subscribe
    public void syncValueAcrossAllPages(final ConvertedValue val) {
        if (!(val.value.equals(mFromUnit.getText().toString())) && val.position != mPosition) {
            mVisibleFragmentPosition = val.position;
            mFromUnit.setText(val.value);
        }
    }

    public void changeVisibleFragmentPosition(int position) {
        mVisibleFragmentPosition = position;
    }

    @Subscribe
    public void syncOnPageScroll(final PageScrollPosition pageScrollPosition) {
        Timber.e("***************************");
        Timber.e("mPosition Fragment:" + mPosition);
        int pos = pageScrollPosition.position;
        Timber.e("Current Visible Position:" + pos);
        Timber.e("mDataset length:" + mDataset.length);
        Timber.e("***************************");

        changeVisibleFragmentPosition(pos);

        EventBus.post(new ConvertedValue(mFromUnit.getText().toString().trim(), mDataset[pos], pos));
    }
}