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

public class ClassesFragment extends Fragment {
    private final static String TAG ="ClassesFragment";

    private Button buttonClasses;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_classes,container,false);

        buttonClasses = view.findViewById(R.id.classesButton1);

        buttonClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Pruebitas shydoris",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
