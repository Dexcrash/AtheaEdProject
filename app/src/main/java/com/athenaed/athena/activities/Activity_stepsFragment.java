package com.athenaed.athena.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaActivity;
import com.athenaed.athena.mundo.AthenaStep;

import java.util.ArrayList;
import java.util.List;

public class Activity_stepsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_step_list,container,false);

        List<AthenaStep> arreglo = new ArrayList<>();
        AthenaActivity activity = (AthenaActivity)getArguments().get("data");
        arreglo = activity.steps;

        // Create the adapter to convert the array to views
        ActivityStepsAdapter adapter = new ActivityStepsAdapter(getActivity(), arreglo);
        // Attach the adapter to a ListView
        ListView listView = (ListView) view.findViewById(R.id.list);

        listView.setAdapter(adapter);

      return view;
    }
}
