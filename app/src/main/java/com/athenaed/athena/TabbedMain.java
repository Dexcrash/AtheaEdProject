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
import com.athenaed.athena.mundo.AthenaActivity;
import com.athenaed.athena.profile.ProfileFragment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TabbedMain extends AppCompatActivity {

    private static final String TAG = "TabbedActivity";

    private static ArrayList<AthenaActivity> activitiesMain = new ArrayList<AthenaActivity>();


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private FirebaseDatabase mFireDataBase;
    private DatabaseReference mActivitiesDataBaseReference;
    private ChildEventListener mChildEventListener;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFireDataBase = FirebaseDatabase.getInstance();
        mActivitiesDataBaseReference = mFireDataBase.getReference().child("Activities");

        setContentView(R.layout.activity_tabbed);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewerPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                AthenaActivity act = dataSnapshot.getValue(AthenaActivity.class);
                activitiesMain.add(act);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        mActivitiesDataBaseReference.addChildEventListener(mChildEventListener);
    }


    private void setupViewerPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new ClassesFragment(), "Classes");
        Fragment activitiesFragment = new ActivitiesFragment();
        Bundle info = new Bundle();
        info.putParcelableArrayList("activtiesData",activitiesMain);
        activitiesFragment.setArguments(info);
        adapter.addFragment(activitiesFragment, "Activities");
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
