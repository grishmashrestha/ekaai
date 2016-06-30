package com.lftechnology.ekaai.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.bus.ConvertedValue;
import com.lftechnology.ekaai.bus.EventBus;
import com.lftechnology.ekaai.bus.PageScrollPosition;
import com.lftechnology.ekaai.constant.AppConstant;
import com.lftechnology.ekaai.utils.AutoResizeFontTextView;
import com.lftechnology.ekaai.utils.CustomEditText;
import com.squareup.otto.Subscribe;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 2/26/16.
 */
public class ScreenSlideTopFragment extends BaseFragment {

    private static final String POSITION = "position";
    private static final String DATASET = "dataset";
    private static final String SELECTED_CONVERSION = "selectedConversion";

    private int mVisibleFragmentPosition;
    private int mPosition;
    private String[] mDataset;
    private ViewGroup mRootView;
    private CustomEditText mFromUnit;
    private String mSelectedConversion;
    private static CustomEditTextOnTouch mCustomEditTextOnTouch;

    public ScreenSlideTopFragment() {
    }

    public static ScreenSlideTopFragment newInstance(int position, String[] dataset, String selectedConversion) {
        ScreenSlideTopFragment fragment = new ScreenSlideTopFragment();
        Bundle args = new Bundle();
        args.putInt(POSITION, position);
        args.putStringArray(DATASET, dataset);
        args.putString(SELECTED_CONVERSION, selectedConversion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(POSITION);
            mDataset = getArguments().getStringArray(DATASET);
            mSelectedConversion = getArguments().getString(SELECTED_CONVERSION);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_slider_top, container, false);
        CustomEditText fromUnit = (CustomEditText) mRootView.findViewById(R.id.from_unit);
        if (mSelectedConversion.equals(AppConstant.TEMPERATURE))
            fromUnit.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);


//        View gestureView = mRootView.findViewById(R.id.content_top);
//        gestureView.setClickable(true);
//        gestureView.setFocusable(true);
//        GestureDetector.SimpleOnGestureListener gestureListener = new GestureListener();
//        final GestureDetector gd = new GestureDetector(getActivity(), gestureListener);
//        assert gestureView != null;
//        gestureView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                gd.onTouchEvent(motionEvent);
//                return false;
//            }
//        });

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView tv = (TextView) mRootView.findViewById(R.id.scroll_top);
        tv.setText(Html.fromHtml(mDataset[mPosition]));

        mFromUnit = (CustomEditText) mRootView.findViewById(R.id.from_unit);
        if (mPosition == 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    EventBus.post(new ConvertedValue(mFromUnit.getText().toString().trim(), mDataset[mPosition], mPosition, mSelectedConversion));
                }
            }, 2);
        }

        mFromUnit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    mCustomEditTextOnTouch.editTextOnTouch();
                }
                return false;
            }
        });

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
                    EventBus.post(new ConvertedValue(s.toString().trim(), mDataset[mPosition], mPosition, mSelectedConversion));
                }
            }
        });

        // Disable copy/paste in the editText
        mFromUnit.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    /**
     * syncValueAcrossAllPages
     *
     * @param val is an object of ConvertedValue class.
     *            This method listens for EventBus which is posted when the editText in ScreenSlideTopFragment is changed.
     *            It updates all other instances of ScreenSlideTopFragment with the passed value of ConverterValue object.
     */
    @Subscribe
    public void syncValueAcrossAllPages(final ConvertedValue val) {
        if (!(val.getValue().equals(mFromUnit.getText().toString())) && val.getPosition() != mPosition && val.getSelectedConversion().equals(mSelectedConversion)) {
            mVisibleFragmentPosition = val.getPosition();
            mFromUnit.setText(val.getValue());
        }
    }

    /**
     * changeVisibleFragmentPosition
     *
     * @param position denotes the position of fragment which is currently visible/selected by the user from the viewpager
     *                 it sets the mVisibleFragmentPosition as the position mentioned above
     */

    public void changeVisibleFragmentPosition(int position) {
        mVisibleFragmentPosition = position;
    }

    /**
     * syncOnPageScroll
     *
     * @param pageScrollPosition has two attribute, position and selectedConversion
     *                           position denotes which is the selected page, visible in the view
     *                           selectedConversion denotes from which conversion method this was invoked,
     *                           viz. length, temperature, time, weight or volume.
     *                           if the invoking selectecConversion and the fragments mSelectedConversion matches,
     *                           then only it will invoke the EventBus.
     */
    @Subscribe
    public void syncOnPageScroll(PageScrollPosition pageScrollPosition) {
        if (mSelectedConversion.equals(pageScrollPosition.getSelectedConversion())) {
            int pos = pageScrollPosition.getPosition();
            changeVisibleFragmentPosition(pos);
            EventBus.post(new ConvertedValue(mFromUnit.getText().toString().trim(), mDataset[pos], pos, mSelectedConversion));
        }
    }

    public static void setCustomEditTextOnTouch(CustomEditTextOnTouch test) {
        mCustomEditTextOnTouch = test;
    }

    public interface CustomEditTextOnTouch {
        void editTextOnTouch();
    }


}