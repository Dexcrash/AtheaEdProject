package com.athenaed.athena;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Asus} on 3/04/2018.
 */

public class ActivitiesFragment extends Fragment {


    private final static String TAG ="ActivitiesFragment";

    private Button buttonActivities;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_activities,container,false);

        buttonActivities = view.findViewById(R.id.activitiesButton1);

        buttonActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"ACT",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
