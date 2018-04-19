package com.athenaed.athena.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus} on 3/04/2018.
 */

public class ActivitiesFragment extends Fragment {

    List<AthenaActivity> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        data.add(new AthenaActivity("nombre1","jola",5,5,5,5,null,null));
        data.add(new AthenaActivity("nombre2","jola",5,5,5,5,null,null));
        data.add(new AthenaActivity("nombre3","jola",5,5,5,5,null,null));
        data.add(new AthenaActivity("nombre4","jola",5,5,5,5,null,null));
        data.add(new AthenaActivity("nombre5","jola",5,5,5,5,null,null));

        data = getArguments().getParcelableArrayList("activitiesDara");
        View view =  inflater.inflate(R.layout.fragment_activities,container,false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.activities_recycler);
        ActivityRecyclerAdapter myAdapter = new ActivityRecyclerAdapter(view.getContext(), data);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        myrv.setAdapter(myAdapter);
        return view;
    }
}
