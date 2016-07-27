package com.lftechnology.ekaai.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.lftechnology.ekaai.Ekaai;
import com.lftechnology.ekaai.R;
import com.lftechnology.ekaai.constant.AppConstant;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String FIRST_LOGIN = "FIRST_LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPref = Ekaai.getContext().getSharedPreferences(AppConstant.EKAAI, Context.MODE_PRIVATE);
                boolean firstLogin = sharedPref.getBoolean(FIRST_LOGIN, true);
                Intent intent;
                if (firstLogin) {
                    intent = new Intent(SplashScreenActivity.this, WalkThroughActivity.class);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean(FIRST_LOGIN, true); // TODO change to false when initial work is done
                    editor.apply();
                } else {
                    intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
