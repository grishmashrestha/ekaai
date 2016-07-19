package com.lftechnology.ekaai.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;
import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.adapter.DrawerMenuRecyclerViewAdapter;
import com.lftechnology.ekaai.adapter.DrawerOptionsRecyclerViewAdapter;
import com.lftechnology.ekaai.adapter.ScreenSlidePageAdapter;
import com.lftechnology.ekaai.bus.EventBus;
import com.lftechnology.ekaai.bus.FlingListener;
import com.lftechnology.ekaai.bus.PageScrollPosition;
import com.lftechnology.ekaai.bus.ScrollListener;
import com.lftechnology.ekaai.constant.AppConstant;
import com.lftechnology.ekaai.fragment.ScreenSlideTopFragment;
import com.lftechnology.ekaai.helper.OnKeyEventsListener;
import com.lftechnology.ekaai.helper.OnStartDragListener;
import com.lftechnology.ekaai.helper.SimpleItemTouchHelperCallback;
import com.lftechnology.ekaai.helper.ZoomOutPageTransformer;
import com.lftechnology.ekaai.utils.ApplicationThemeAndDataset;
import com.lftechnology.ekaai.utils.CustomEditText;
import com.lftechnology.ekaai.utils.GeneralUtils;
import com.squareup.otto.Subscribe;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;

/**
 * Handles all the interactions with the app as it is a one-page application
 */
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, ScreenSlideTopFragment.CustomEditTextOnTouch, OnKeyEventsListener, DrawerMenuRecyclerViewAdapter.UpdateFragmentInMainActivity, OnStartDragListener {
    @Bind(R.id.toolbarContainer)
    LinearLayout mToolbarContainer;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_left_recycler_view)
    RecyclerView mLeftRecyclerView;

    @Bind(R.id.drawer_right_recycler_view)
    RecyclerView mRightRecyclerView;

    @Bind(R.id.drawer_left_linear_layout)
    LinearLayout mDrawerLeftLinearLayout;

    @Bind(R.id.drawer_right_linear_layout)
    LinearLayout mDrawerRightLinearLayout;

    @Bind(R.id.inflated_content_main)
    RelativeLayout mLinearLayout;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.main_content)
    RelativeLayout mMainContent;

    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;

    @Bind(R.id.pagerTop)
    ViewPager mPagerTop;

    @Bind(R.id.pagerBottom)
    ViewPager mPagerBottom;

    @Bind(R.id.swapButton)
    ImageView mSwapButton;

    @Bind(R.id.nav_header_background)
    ImageView mNavHeaderBackground;

    @Bind(R.id.app_icon_in_menu)
    ImageView mAppIconInMenu;

    private String mSelectedConversion;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] mDrawerRecyclerViewDataset;
    private ItemTouchHelper mItemTouchHelper;
    private boolean spinDirection = true;
    private float lastTranslate = 0.0f;
    private int mBottomBackgroundColor, mSwapButtonColor, mDataCount;
    private static final int ROTATE_ANIMATION_DURATION = 300;

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
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSelectedConversion(AppConstant.LENGTH);
        setFragment();
        setSupportActionBar(mToolbar);
        setLeftNavigationDrawer();
        setRightNavigationDrawer();
    }

    private void setSelectedConversion(String selectedConversion) {
        mSelectedConversion = selectedConversion;
    }

    private void setLeftNavigationDrawer() {
        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
//        mDrawerLayout.setScrimColor(Color.TRANSPARENT); // set no overlay shadow
        setLeftRecyclerView();
        setNavigationDrawerWidth(mDrawerLeftLinearLayout);
        setNavigationDrawerHeaderImage();
    }

    private void setLeftRecyclerView() {
        mLeftRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mLeftRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerRecyclerViewDataset = getResources().getStringArray(R.array.unit_options);
        DrawerMenuRecyclerViewAdapter mLeftAdapter = new DrawerMenuRecyclerViewAdapter(mDrawerRecyclerViewDataset, this, mSelectedConversion);
        mLeftRecyclerView.setAdapter(mLeftAdapter);
    }

    public void setNavigationDrawerWidth(LinearLayout navigationDrawerLinearLayout) {
        DrawerLayout.LayoutParams linearLayoutParams = (DrawerLayout.LayoutParams) navigationDrawerLinearLayout.getLayoutParams();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        width = (int) (width - GeneralUtils.convertDpToPixel(AppConstant.APP_BAR_HEIGHT, Ekaai.getContext()));
        // set maximum width to 400dp only
        width = width <= (GeneralUtils.convertDpToPixel(AppConstant.NAVIGATION_DRAWER_MAXIMUM_WIDTH, Ekaai.getContext())) ? width : (int) (GeneralUtils.convertDpToPixel(AppConstant.NAVIGATION_DRAWER_MAXIMUM_WIDTH, Ekaai.getContext()));
        linearLayoutParams.width = width;
        navigationDrawerLinearLayout.setLayoutParams(linearLayoutParams);
    }

    private void setNavigationDrawerHeaderImage() {
        Glide.with(Ekaai.getContext()).load(R.drawable.header_bg_transparent).into(mNavHeaderBackground);
        Glide.with(Ekaai.getContext()).load(R.drawable.ekaai_icon).into(mAppIconInMenu);
    }

    private void setRightNavigationDrawer() {
        setRightRecyclerView();
        setNavigationDrawerWidth(mDrawerRightLinearLayout);
    }

    private void setRightRecyclerView() {
        mLayoutManager = new LinearLayoutManager(this);
        mRightRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerRecyclerViewDataset = ApplicationThemeAndDataset.getDataset(mSelectedConversion);
        DrawerOptionsRecyclerViewAdapter mRightAdapter = new DrawerOptionsRecyclerViewAdapter(mDrawerRecyclerViewDataset, this, mSelectedConversion);
        mRightRecyclerView.setAdapter(mRightAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mRightAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRightRecyclerView);
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
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                DrawerLayout.LayoutParams layoutParam = (DrawerLayout.LayoutParams) drawerView.getLayoutParams();
                int drawerGravity = layoutParam.gravity;
                if (drawerGravity == GravityCompat.END) {
                    String[] dataset = ApplicationThemeAndDataset.getDataset(mSelectedConversion);
                    if (!Arrays.equals(dataset, mDrawerRecyclerViewDataset)) {
                        mDrawerRecyclerViewDataset = dataset;
                        setAdapters();
                    }
                }
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // hide soft keyboard if it is open
                GeneralUtils.hideSoftKeyboard(MainActivity.this, drawerView);
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // push out/in main fragment when drawer slides in/out instead of overlaying on top of the main fragments
                float moveFactor = (mLeftRecyclerView.getWidth() * slideOffset);
                DrawerLayout.LayoutParams layoutParam = (DrawerLayout.LayoutParams) drawerView.getLayoutParams();
                int drawerGravity = layoutParam.gravity;

                if (drawerGravity == GravityCompat.START) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        mMainContent.setTranslationX(moveFactor);
                    } else {
                        TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                        anim.setDuration(0);
                        anim.setFillAfter(true);
                        mMainContent.startAnimation(anim);
                        lastTranslate = moveFactor;
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                        mMainContent.setTranslationX(-moveFactor);
                    } else {
                        TranslateAnimation anim = new TranslateAnimation(lastTranslate, -moveFactor, 0.0f, 0.0f);
                        anim.setDuration(0);
                        anim.setFillAfter(true);
                        mMainContent.startAnimation(anim);
                        lastTranslate = moveFactor;
                    }
                }
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
    }

    /**
     * Is called when swap button is clicked, it interchanges the top and bottom fragments
     * Also, animates the swap button
     *
     * @param view {@link View} it belongs to
     */
    public void swapFragments(View view) {
        animateSwapButton(mSwapButton);
        int initialTopFragmentPosition = mPagerTop.getCurrentItem();
        int initialBottomFragmentPosition = mPagerBottom.getCurrentItem();
        mPagerTop.setCurrentItem(initialBottomFragmentPosition);
        mPagerBottom.setCurrentItem(initialTopFragmentPosition);
    }

    private void animateSwapButton(ImageView swapButton) {
        swapButton.clearAnimation();
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
     * Animate swap button when show/hide keyboard
     */
    @Override
    public void keyboardHidden() {
        // TODO Make sure the height of the linear layout matches full screen when the soft-keyboard is hidden
        //  RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //  mLinearLayout.setLayoutParams(layoutParams);

        // show swap button
        if (mSwapButton.getVisibility() == View.INVISIBLE) {
            mSwapButton.clearAnimation();
            Animation scaleOut = new ScaleAnimation(0, 1, 0, 1, mSwapButton.getWidth() / 2, mSwapButton.getHeight() / 2);
            scaleOut.setInterpolator(new AccelerateInterpolator());
            scaleOut.setStartOffset(0); // Start fading out after 500 milli seconds
            scaleOut.setDuration(AppConstant.SWAP_BUTTON_ANIMATION_TIME_400); // Fadeout duration should be 1000 milli seconds

            Animation fadeOut = new AlphaAnimation(0, 1);  // the 1, 0 here notifies that we want the opacity to go from opaque (1) to transparent (0)
            fadeOut.setInterpolator(new AccelerateInterpolator());
            fadeOut.setStartOffset(0); // Start fading out after 500 milli seconds
            fadeOut.setDuration(AppConstant.SWAP_BUTTON_ANIMATION_TIME_400); // Fadeout duration should be 1000 milli seconds

            AnimationSet animation = new AnimationSet(false); // change to false
            animation.addAnimation(scaleOut);
            animation.addAnimation(fadeOut);
            animation.setRepeatCount(1);
            mSwapButton.setAnimation(animation);
            mSwapButton.setVisibility(View.VISIBLE);
        }
    }

    @Subscribe
    public void toggleToolBar(ScrollListener scrollListener) {
        int dy;
        int DY = 5;
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

    @Override
    public void updateFragment(String selectedConversion) {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
        }

        if (!mSelectedConversion.equals(selectedConversion)) {
            mSelectedConversion = selectedConversion;
            mItemTouchHelper.attachToRecyclerView(null);
            setFragment();
            setLeftRecyclerView();
            setRightRecyclerView();
        }
    }

    public void setFragment() {
        setBackgroundColorAndLengthBySelectedConversion();
        setAdapters();
        mSwapButton.setBackgroundResource(mSwapButtonColor);
        ScreenSlideTopFragment.setCustomEditTextOnTouch(this);
        mToolbarTitle.setText(mSelectedConversion);
//        GeneralUtils.getStatusColor(mBottomBackgroundColor);
        mToolbar.setBackgroundColor(getResources().getColor(mBottomBackgroundColor));
    }

    private void setBackgroundColorAndLengthBySelectedConversion() {
        Integer[] themeDetails = ApplicationThemeAndDataset.getThemeDetails(mSelectedConversion);
        mDataCount = themeDetails[0];
        mBottomBackgroundColor = themeDetails[1];
        mSwapButtonColor = themeDetails[2];
    }

    public void setAdapters() {
        String[] dataset = ApplicationThemeAndDataset.getDataset(mSelectedConversion);
        mPagerTop.removeOnPageChangeListener(this);
        ScreenSlidePageAdapter mPagerAdapterTop = new ScreenSlidePageAdapter(getSupportFragmentManager(), true, mSelectedConversion, dataset);
        mPagerTop.setAdapter(mPagerAdapterTop);
        mPagerTop.setOffscreenPageLimit(mDataCount);
        mPagerTop.addOnPageChangeListener(this);
        mPagerTop.setPageTransformer(true, new ZoomOutPageTransformer());

        ScreenSlidePageAdapter mPagerAdapterBottom = new ScreenSlidePageAdapter(getSupportFragmentManager(), false, mSelectedConversion, dataset);
        mPagerBottom.setAdapter(mPagerAdapterBottom);
        mPagerBottom.setOffscreenPageLimit(mDataCount);
        mPagerBottom.setCurrentItem(1);
        mPagerBottom.setBackgroundResource(mBottomBackgroundColor);
        mPagerBottom.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    @OnClick(R.id.tv_about)
    public void setOnClicks(View view) {
        switch (view.getId()) {
            case R.id.tv_about:
                showAboutInAlertDialog();
                break;
        }
    }

    private void showAboutInAlertDialog() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        View view = getLayoutInflater().inflate(R.layout.dialog_about_us, null);
        view.findViewById(R.id.iv_dialog_logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.lft_website)));
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = new AlertDialog.Builder(this, R.style.NewDialog)
                .setTitle(R.string.dialog_about_title)
                .setView(view)
                .setPositiveButton(R.string.rate_us, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(getString(R.string.lft_playstore_link)));
                        startActivity(intent);

                    }
                })
                .setNegativeButton(R.string.later, null)
                .create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.NewDialog;
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
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

    @Override
    public void editTextOnTouch() {
        if (mSwapButton.getVisibility() == View.VISIBLE) {
            mSwapButton.clearAnimation();
            Animation scaleOut = new ScaleAnimation(1, 0, 1, 0, mSwapButton.getWidth() / 2, mSwapButton.getHeight() / 2);
            scaleOut.setInterpolator(new AccelerateInterpolator());
            scaleOut.setStartOffset(0);
            scaleOut.setDuration(AppConstant.SWAP_BUTTON_ANIMATION_TIME_800);
            Animation fadeOut = new AlphaAnimation(1, 0);  // the 1, 0 here notifies that we want the opacity to go from opaque (1) to transparent (0)
            fadeOut.setInterpolator(new AccelerateInterpolator());
            fadeOut.setStartOffset(0);
            fadeOut.setDuration(AppConstant.SWAP_BUTTON_ANIMATION_TIME_800);
            AnimationSet animation = new AnimationSet(false); // change to false
            animation.addAnimation(scaleOut);
            animation.addAnimation(fadeOut);
            animation.setRepeatCount(1);
            mSwapButton.setAnimation(animation);
            mSwapButton.setVisibility(View.INVISIBLE);
        }
    }
}


