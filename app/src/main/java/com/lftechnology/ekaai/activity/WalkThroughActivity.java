package com.lftechnology.ekaai.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.adapter.WalkThroughAdapter;
import com.lftechnology.ekaai.constant.AppConstant;
import com.lftechnology.ekaai.helper.ZoomOutPageTransformer;
import com.lftechnology.ekaai.utils.GeneralUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class WalkThroughActivity extends AppCompatActivity {
    private static final String FIRST_LOGIN = "FIRST_LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(GeneralUtils.getStatusColor(getResources().getColor(R.color.colorLengthLight)));
        }
        ViewPager vp = (ViewPager) findViewById(R.id.vp_walk_through_pager);
        WalkThroughAdapter mPagerAdapterTop = new WalkThroughAdapter(getSupportFragmentManager());
        vp.setAdapter(mPagerAdapterTop);
        vp.setPageTransformer(true, new ZoomOutPageTransformer());

    }

    @OnClick(R.id.tv_get_started)
    public void setOnClicks(View view) {
        Intent intent = new Intent(WalkThroughActivity.this, MainActivity.class);
        SharedPreferences sharedPref = Ekaai.getContext().getSharedPreferences(AppConstant.EKAAI, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(FIRST_LOGIN, false);
        editor.apply();
        startActivity(intent);
        finish();
    }
}
