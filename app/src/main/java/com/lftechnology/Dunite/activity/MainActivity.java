package com.lftechnology.Dunite.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lftechnology.Dunite.R;
import com.lftechnology.Dunite.adapter.DrawerRecyclerViewAdapter;
import com.lftechnology.Dunite.bus.EventBus;
import com.lftechnology.Dunite.bus.FlingListener;
import com.lftechnology.Dunite.bus.NavigationMenuChangeDetails;
import com.lftechnology.Dunite.bus.ScrollListener;
import com.lftechnology.Dunite.bus.SwapFragment;
import com.lftechnology.Dunite.constant.AppConstant;
import com.lftechnology.Dunite.fragment.MainFragment;
import com.lftechnology.Dunite.helper.OnStartDragListener;
import com.lftechnology.Dunite.helper.SimpleItemTouchHelperCallback;
import com.lftechnology.Dunite.utils.GeneralUtils;
import com.lftechnology.Dunite.utils.OnKeyEvents;
import com.lftechnology.Dunite.utils.SoftKeyBoard;
import com.squareup.otto.Subscribe;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Handles all the interactions with the app as it is a one-page application
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnStartDragListener, OnKeyEvents {
    @Bind(R.id.toolbarContainer)
    LinearLayout mToolbarContainer;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.inflated_content_main)
    LinearLayout mLinearLayout;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nav_header)
    TextView mTv;
    @Bind(R.id.unito_option_spinner)
    Spinner mSpinner;

    private static int DY = 5; // increment/decrement of mToolbar on swipe up/down
    private static final int ROTATE_ANIMATION_DURATION = 300;
    private String mSelectedConversion;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDrawerRecyclerViewDataset;
    private ItemTouchHelper mItemTouchHelper;
    private boolean spinDirection = true;

    @Override
    public void onResume() {
        super.onResume();
        EventBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        setSpinner();
        setNavigationDrawer();
    }

    private void setSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unito_options, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SoftKeyBoard.hideSoftKeyboard(v.getContext(), v);
                return false;
            }
        });
        mSpinner.setOnItemSelectedListener(this);
    }

    private void setNavigationDrawer() {
        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private void setRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerRecyclerViewDataset = getDrawerRecyclerViewDataset();
        mAdapter = new DrawerRecyclerViewAdapter(mDrawerRecyclerViewDataset, this, mSelectedConversion);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private String[] getDrawerRecyclerViewDataset() {
        String[] drawerRecyclerViewDataset;
        SharedPreferences sharedPref = getBaseContext().getSharedPreferences(AppConstant.DUNITE, Context.MODE_PRIVATE);
        String preference = sharedPref.getString(mSelectedConversion, AppConstant.NOT_AVAILABLE);
        if (preference.equals(AppConstant.NOT_AVAILABLE)) {
            switch (mSelectedConversion) {
                case AppConstant.LENGTH:
                    drawerRecyclerViewDataset = getResources().getStringArray(R.array.length_options);
                    break;
                case AppConstant.TEMPERATURE:
                    drawerRecyclerViewDataset = getResources().getStringArray(R.array.temperature_options);
                    break;
                case AppConstant.TIME:
                    drawerRecyclerViewDataset = getResources().getStringArray(R.array.time_options);
                    break;
                case AppConstant.VOLUME:
                    drawerRecyclerViewDataset = getResources().getStringArray(R.array.volume_options);
                    break;
                case AppConstant.WEIGHT:
                    drawerRecyclerViewDataset = getResources().getStringArray(R.array.weight_options);
                    break;
                default:
                    drawerRecyclerViewDataset = new String[]{};
                    break;
            }
        } else {
            Gson gson = new Gson();
            drawerRecyclerViewDataset = gson.fromJson(preference, String[].class);
        }
        return drawerRecyclerViewDataset;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                if (!Arrays.equals(getDrawerRecyclerViewDataset(), mDrawerRecyclerViewDataset)) {
                    EventBus.post(new NavigationMenuChangeDetails(mSelectedConversion));
                }
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setHeaderTextByFragment() {
        mTv.setText(mSelectedConversion);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        spinner.setSelection(position);
        mSelectedConversion = spinner.getSelectedItem().toString();
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.inflated_content_main, MainFragment.newInstance(mSelectedConversion));
        fragmentTransaction.commit();

        setHeaderTextByFragment();
        setRecyclerView();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * Is called when swap button is clicked, it interchanges the top and bottom fragments
     * Also, animates the swap button
     * @param view
     */
    public void swapFragments(View view) {
        ImageView swapButton = (ImageView) findViewById(R.id.swapButton);
        animateSwapButton(swapButton);
        EventBus.post(new SwapFragment(true));
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    private void animateSwapButton(ImageView swapButton) {
        Animation animation;
        if (spinDirection) {
            animation = new RotateAnimation(0.0f, 180.0f, swapButton.getWidth() / 2, swapButton.getHeight() / 2);
        } else {
            animation = new RotateAnimation(180.0f, 0.0f, swapButton.getWidth() / 2, swapButton.getHeight() / 2);
        }
        spinDirection = !spinDirection;
        animation.setDuration(ROTATE_ANIMATION_DURATION);
        animation.setRepeatCount(0);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setFillAfter(true);
        swapButton.setAnimation(animation);
    }

    /**
     * Make sure the height of the linear layout matches full screen when the soft-keyboard is hidden
     */
    @Override
    public void keyboardHidden() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLinearLayout.setLayoutParams(layoutParams);
    }

    @Subscribe
    public void toggleToolBar(ScrollListener scrollListener) {
        int dy;
        if (scrollListener.moveUp) {
            if (GeneralUtils.convertPixelsToDp(mToolbarContainer.getTranslationY(), this) > -56.0) {
                float diff = mToolbarContainer.getTranslationY() - DY;
                if ((GeneralUtils.convertPixelsToDp(diff, this) < -56.0)) {
                    dy = Math.round(diff + GeneralUtils.convertDpToPixel(56, this));
                    diff = mToolbarContainer.getTranslationY() - dy;
                } else {
                    dy = DY;
                }
                mToolbarContainer.setTranslationY(diff);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mLinearLayout.getWidth(), mLinearLayout.getHeight() + dy);
                mLinearLayout.setLayoutParams(layoutParams);
                mLinearLayout.setTranslationY(mLinearLayout.getY() - dy);
            }
        } else {
            if (mToolbarContainer.getTranslationY() < 0.0) {
                float diff = mToolbarContainer.getTranslationY() + DY;
                if ((diff) > 0.0) {
                    dy = Math.round(diff);
                    diff = mToolbarContainer.getTranslationY() + dy;
                } else {
                    dy = DY;
                }
                mToolbarContainer.setTranslationY(diff);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mLinearLayout.getWidth(), mLinearLayout.getHeight() - dy);
                mLinearLayout.setLayoutParams(layoutParams);
                mLinearLayout.setTranslationY(mLinearLayout.getY() + dy);
            }
        }
    }

    @Subscribe
    public void hideOrShowToolbarAfterScrollComplete(FlingListener flingListener) {
        int dy;
        float yTranslationInDP = GeneralUtils.convertPixelsToDp(mToolbarContainer.getTranslationY(), this);

        if (flingListener.flingedUp && (yTranslationInDP > -56) && (yTranslationInDP < 0)) {
            float diff = Math.round(GeneralUtils.convertDpToPixel(-56, this));
            mToolbarContainer.setTranslationY(diff);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mLinearLayout.getWidth(), (int) (mLinearLayout.getHeight() + mLinearLayout.getY()));
            mLinearLayout.setLayoutParams(layoutParams);
            mLinearLayout.setTranslationY(0);
        } else if (!flingListener.flingedUp && (yTranslationInDP < 56.0) && (GeneralUtils.convertPixelsToDp(mLinearLayout.getY(), this) < 56)) {
            float diff = 0;
            dy = Math.round(GeneralUtils.convertDpToPixel(56, this));
            mToolbarContainer.setTranslationY(diff);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(mLinearLayout.getWidth(), (int) (mLinearLayout.getHeight() - diff));
            mLinearLayout.setLayoutParams(layoutParams);
            mLinearLayout.setTranslationY(dy);
        }
    }
}


