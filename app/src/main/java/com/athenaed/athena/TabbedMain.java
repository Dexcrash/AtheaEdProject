package com.athenaed.athena;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.athenaed.athena.activities.ActivitiesFragment;
import com.athenaed.athena.classes.ClassesFragment;
import com.athenaed.athena.profile.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

public class TabbedMain extends AppCompatActivity {

    private static final String TAG = "TabbedActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_tabbed);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewerPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }


    private void setupViewerPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new ClassesFragment(), "Classes");
        adapter.addFragment(new ActivitiesFragment(), "Activities");
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
