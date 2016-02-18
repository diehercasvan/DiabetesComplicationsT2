package com.edibca.diabetescomplicationst2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import Class_General.General;
import Class_General.SvgCreate;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private ImageView[] imageViews;
    private SvgCreate svgCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        General general = new General(this, this, Environment.getExternalStorageDirectory().getAbsolutePath());
        setContentView(R.layout.activity_main);
        loadMenuContent();
        loadView();

    }

    public void loadView() {

        imageViews = new ImageView[7];
        imageViews[0] = (ImageView) findViewById(R.id.imgOneGuide);
        imageViews[1] = (ImageView) findViewById(R.id.imgTwoGuide);
        imageViews[2] = (ImageView) findViewById(R.id.imgThreeGuide);
        imageViews[3] = (ImageView) findViewById(R.id.imgFourGuide);
        imageViews[4] = (ImageView) findViewById(R.id.imgFiveGuide);
        imageViews[5] = (ImageView) findViewById(R.id.imgSixGuide);
        imageViews[6] = (ImageView) findViewById(R.id.logo);

        for (int i = 0; i < imageViews.length; i++) {

            imageViews[i].setOnClickListener(this);
        }
        svgCreate=new SvgCreate(imageViews[6], General.iIDLogo);
        svgCreate.builderSVG();

    }

    public void loadMenuContent() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int iSelectionMenu = 0;

        switch (item.getItemId()) {
            case R.id.one_guide:
                iSelectionMenu = 0;
                break;
            case R.id.two_guide:
                iSelectionMenu = 1;
                break;
            case R.id.three_guide:
                iSelectionMenu = 2;
                break;
            case R.id.four_guide:
                iSelectionMenu = 3;
                break;
            case R.id.five_guide:
                iSelectionMenu = 4;
                break;
            case R.id.six_guide:
                iSelectionMenu = 5;
                break;


        }
        selectionMenu(iSelectionMenu);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int iIntent = 0;
        switch (v.getId()) {

            case R.id.imgOneGuide:
                iIntent = 0;
                break;
            case R.id.imgTwoGuide:
                iIntent = 1;
                break;
            case R.id.imgThreeGuide:
                iIntent = 2;
                break;
            case R.id.imgFourGuide:
                iIntent = 3;
                break;
            case R.id.imgFiveGuide:
                iIntent = 4;
                break;
            case R.id.imgSixGuide:
                iIntent = 5;
                break;
        }

        selectionMenu(iIntent);
    }

    private void selectionMenu(int iSelectionMenu) {

        Intent intent = null;
        switch (iSelectionMenu) {

            case 0:
                intent = new Intent(this, ScreenSlideActivity.class);
                break;
            case 1:
                intent = new Intent(this, ScreenSlideActivityTwo.class);
                break;
            case 2:
                intent = new Intent(this, ScreenSlideActivityThree.class);
                break;
            case 3:
                intent = new Intent(this, ScreenSlideActivityFour.class);
                break;
            case 4:
                intent = new Intent(this, ScreenSlideActivityFive.class);
                break;
            case 5:
                intent = new Intent(this, ScreenSlideActivitySix.class);
                break;
        }

        startActivity(intent);
    }
}
