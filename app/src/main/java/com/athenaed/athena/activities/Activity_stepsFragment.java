package com.athenaed.athena.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaStep;

import java.util.ArrayList;
import java.util.List;

public class Activity_stepsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_step_list,container,false);

        List<AthenaStep> arreglo = new ArrayList<>();
        AthenaStep hola = new AthenaStep("open book", "you need to open your book you need to close your book you need to close your book you need to close your book you need to close your book", 1);
        AthenaStep hola2 = new AthenaStep("close book", "you need to close your book you need to close your book you need to close your book you need to close your book you need to close your book", 2);
        AthenaStep hola3 = new AthenaStep("run", "get up and run", 3);
        AthenaStep hola4 = new AthenaStep("run", "get up and run",4);
        AthenaStep hola5 = new AthenaStep("run", "get up and run",5);
        AthenaStep hola6 = new AthenaStep("run", "get up and run",6);
        AthenaStep hola7 = new AthenaStep("run", "get up and run",7);


        arreglo.add(hola);
        arreglo.add(hola2);
        arreglo.add(hola3);
        arreglo.add(hola4);
        arreglo.add(hola5);
        arreglo.add(hola6);
        arreglo.add(hola7);

// Create the adapter to convert the array to views
        ActivityStepsAdapter adapter = new ActivityStepsAdapter(getActivity(), arreglo);
// Attach the adapter to a ListView
        ListView listView = (ListView) view.findViewById(R.id.list);

        listView.setAdapter(adapter);

      return view;
    }
}
