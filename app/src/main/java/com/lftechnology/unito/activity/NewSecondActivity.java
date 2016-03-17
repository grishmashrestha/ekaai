package com.lftechnology.unito.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lftechnology.unito.R;

import timber.log.Timber;

public class NewSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_second);
        Timber.e("I am here");
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra(Intent.EXTRA_EMAIL, 100);
        setResult(1, intent);
        finish();
    }
}
