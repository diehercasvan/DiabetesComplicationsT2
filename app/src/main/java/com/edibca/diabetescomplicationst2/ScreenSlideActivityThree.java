package com.edibca.diabetescomplicationst2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import Class_General.General;
import Interfaces.IntMenuSelector;
import fragment.FragmentMenuDialog;
import fragment.FragmentSlidePageThree;
import fragment.FragmentSlidePageTwo;
import models.ModelDialog;
import models.ModelFragments;

/**
 * Created by DIEGO CASALLAS  on 12/02/2016.
 * Management Class displaced fragments
 */
public class ScreenSlideActivityThree extends FragmentActivity implements IntMenuSelector{
/**
 * The number of pages (wizard steps) to show in this demo.
 */
    private static final int NUM_PAGE=10;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager viewPager;
    private FragmentMenuDialog fragmentMenuDialog;
    private ModelDialog modelDialog;//New changes
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        // Instantiate a ViewPager and a PagerAdapter.
        viewPager=(ViewPager)findViewById(R.id.pager);
        pagerAdapter =new ScreenSlidePagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                invalidateOptionsMenu();
            }
        });
       //viewPager.setCurrentItem(4);
        getActionBar().setIcon(R.drawable.three_guide);//New changes
        General.CONTEXT=this;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_page_slide, menu);

        menu.findItem(R.id.action_previous).setEnabled(viewPager.getCurrentItem() > 0);

        // Add either a "next" or "finish" button to the action bar, depending on which page
        // is currently selected.
        MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
                (viewPager.getCurrentItem() == pagerAdapter.getCount() - 1) ? R.string.action_finish : R.string.action_next);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
                return true;

            case R.id.action_previous:
                // Go to the previous step in the wizard. If there is no previous step,
                // setCurrentItem will do nothing.
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                return true;

            case R.id.action_next:
                // Advance to the next step in the wizard. If there is no next step, setCurrentItem
                // will do nothing.
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                return true;
            case R.id.search:

                modelDialog=new ModelDialog();
                modelDialog.setiDiImage(R.drawable.three_guide);
                modelDialog.setSlistView(getResources().getStringArray(R.array.sec_3_menu));
                modelDialog.setsRouteDownload("");
                modelDialog.setsTitleDialog(this.getTitle().toString());
                General.LoadFragmentDialog(modelDialog);

                FragmentTransaction  fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentMenuDialog = new FragmentMenuDialog().newInstance();
                fragmentMenuDialog.show(fragmentTransaction, "Calculadora");

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void SelectionMenuItem(int iSelection) {
        viewPager.setCurrentItem(iSelection);//New changes
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            General.LoadFragmentSlidePage(loadData());

            return FragmentSlidePageThree.create(position);
        }
        public ModelFragments  loadData(){
            int[] iSrcImages=new int[7];
            iSrcImages[0]=R.drawable.sec3_1_1;
            iSrcImages[1]=R.drawable.sec3_3_1;
            iSrcImages[2]=R.drawable.sec3_3_2;
            iSrcImages[3]=R.drawable.sec3_4_1;
            iSrcImages[4]=R.drawable.sec3_4_2;
            iSrcImages[5]=R.drawable.sec3_5_1;
            iSrcImages[6]=R.drawable.sec3_6_1;


            int[] iD_Layout=new int[3];
            iD_Layout[0]=R.layout.fragment_image;
            iD_Layout[1]=R.layout.fragment_image_text;
            iD_Layout[2]=R.layout.fragment_text;

            int [] iD_image_single=new int [1];
            iD_image_single[0]=R.drawable.sec3_9_1;

            ModelFragments modelFragments=new ModelFragments();
            modelFragments.setiSrcImage(iD_image_single);
            modelFragments.setsTitlePage(getResources().getStringArray(R.array.sec_3_menu));
            modelFragments.setiSrcImages(iSrcImages);
            modelFragments.setsTitleImages(getResources().getStringArray(R.array.sec_3_images));
            modelFragments.setsFileWebViews("section_3");
            modelFragments.setiD_Layout(iD_Layout);

            return modelFragments;

        }

        @Override
        public int getCount() {
            return NUM_PAGE;
        }
    }

}
