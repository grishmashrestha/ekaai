package com.lftechnology.unito.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lftechnology.unito.R;
import com.lftechnology.unito.bus.EventBus;
import com.lftechnology.unito.bus.SwapFragment;
import com.lftechnology.unito.constant.AppConstant;
import com.lftechnology.unito.fragment.MainFragment;
import com.lftechnology.unito.utils.SoftKeyBoard;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private String mSelectedConversion;
    private Menu mMenu;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        mMenu = nvDrawer.getMenu();
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);

        mDrawerList = (ListView)findViewById(R.id.navList);
        addDrawerItems();

        Spinner spinner = (Spinner) findViewById(R.id.unito_option_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unito_options, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SoftKeyBoard.hideSoftKeyboard(v.getContext(), v);
                return false;
            }
        });
        spinner.setOnItemSelectedListener(this);
    }

    private void addDrawerItems() {
        String[] osArray = { "Android", "iOS", "Windows", "OS X", "Linux" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void setMenuByFragment(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.drawer_length, menu);

//        switch (mSelectedConversion) {
//            case AppConstant.LENGTH:
//                getMenuInflater().inflate(R.menu.drawer_length, menu);
//                break;
//            case AppConstant.TEMPERATURE:
//                getMenuInflater().inflate(R.menu.drawer_temperature, menu);
//                break;
//            case AppConstant.TIME:
//                getMenuInflater().inflate(R.menu.drawer_time, menu);
//                break;
//            case AppConstant.VOLUME:
//                getMenuInflater().inflate(R.menu.drawer_volume, menu);
//                break;
//            case AppConstant.WEIGHT:
//                getMenuInflater().inflate(R.menu.drawer_weight, menu);
//                break;
//            default:
//                break;
//        }
    }

    private void setHeaderTextByFragment() {
        ((TextView) findViewById(R.id.nav_header)).setText(mSelectedConversion);
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

        nvDrawer = (NavigationView) findViewById(R.id.nvView);
//        View view1 = nvDrawer.getHeaderView(0);
        setHeaderTextByFragment();
//        setMenuByFragment(mMenu);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void swapFragments(View view) {
        EventBus.post(new SwapFragment(true));
    }
}


