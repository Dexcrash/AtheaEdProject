package com.athenaed.athena.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.athenaed.athena.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityActivity extends AppCompatActivity {

    private static final String TAG = "ActivityActivity";

    private ActivityActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabbed_activities);
        mSectionsPagerAdapter = new ActivityActivity.SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewerPager(mViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
     }


    private void setupViewerPager(ViewPager viewPager){
        ActivityActivity.SectionsPagerAdapter adapter = new ActivityActivity.SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Activity_infoFragment(), "Information");
        adapter.addFragment(new Activity_stepsFragment(), "Activities");
        viewPager.setAdapter(adapter);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        private List<Fragment> mfragmentsList = new ArrayList<>();
        private List<String> mfragmentsTitlesList = new ArrayList<>();


        public void addFragment(Fragment fragment , String title){
            mfragmentsList.add(fragment);
            mfragmentsTitlesList.add(title);
        }

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mfragmentsTitlesList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentsList.size();
        }
    }
}
