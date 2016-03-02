package com.lftechnology.unito;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private String mSelectedConversion;
    private Menu mMenu;


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

        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.setDrawerListener(drawerToggle);


        Spinner spinner = (Spinner) findViewById(R.id.unito_option_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unito_options, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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

        switch (mSelectedConversion) {
            case "Length":
                getMenuInflater().inflate(R.menu.drawer_length, menu);
                ;
                break;
            case "Temperature":
                getMenuInflater().inflate(R.menu.drawer_temperature, menu);
                ;
                break;
            case "Time":
                getMenuInflater().inflate(R.menu.drawer_time, menu);
                ;
                break;
            case "Volume":
                getMenuInflater().inflate(R.menu.drawer_volume, menu);
                ;
                break;
            case "Weight":
                getMenuInflater().inflate(R.menu.drawer_weight, menu);
                ;
                break;
            default:
                break;
        }
    }

    private void setHeaderTextByFragment(View view) {
        ((TextView) view.findViewById(R.id.nav_header)).setText(mSelectedConversion);
    }

    private void changeFragment(String selectedConversion) {
        mSelectedConversion = selectedConversion;
        switch (selectedConversion) {
            case "Length":
                replaceByAnotherFragment(new LengthFragment());
                break;
            case "Temperature":
                replaceByAnotherFragment(new TemperatureFragment());
                break;
            case "Time":
                replaceByAnotherFragment(new TimeFragment());
                break;
            case "Volume":
                replaceByAnotherFragment(new VolumeFragment());
                break;
            case "Weight":
                replaceByAnotherFragment(new WeightFragment());
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        spinner.setSelection(position);
        String selectedConversion = spinner.getSelectedItem().toString();
        changeFragment(selectedConversion);


        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        View view1 = nvDrawer.getHeaderView(0);
        setHeaderTextByFragment(view1);
        setMenuByFragment(mMenu);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public void replaceByAnotherFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.inflated_content_main, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}


