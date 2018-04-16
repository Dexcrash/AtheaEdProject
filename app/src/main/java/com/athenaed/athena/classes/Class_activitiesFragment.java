package com.athenaed.athena.classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.athenaed.athena.R;
import com.athenaed.athena.activities.ActivityRecyclerAdapter;
import com.athenaed.athena.mundo.AthenaActivity;

import java.util.ArrayList;
import java.util.List;

public class Class_activitiesFragment extends Fragment {

    List<AthenaActivity> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        data.add(new AthenaActivity("Actividad1","Holoolololo", 40,60,50,5));
        data.add(new AthenaActivity("Actividad2","Holoolololo", 40,60,50,5));
        data.add(new AthenaActivity("Actividad3","Holoolololo", 40,60,50,5));
        data.add(new AthenaActivity("Actividad4","Holoolololo", 40,60,50,5));
        data.add(new AthenaActivity("Actividad5","Holoolololo", 40,60,50,5));

        View view =  inflater.inflate(R.layout.fragment_activities,container,false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.activities_recycler);
        ActivityRecyclerAdapter myAdapter = new ActivityRecyclerAdapter(view.getContext(), data);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        myrv.setAdapter(myAdapter);
        return view;
    }
}
