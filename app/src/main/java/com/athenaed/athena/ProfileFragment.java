package com.athenaed.athena;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ProfileFragment extends Fragment {
    private final static String TAG ="ProfileFragment";

    private Button buttonProfile;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_classes,container,false);

        buttonProfile = view.findViewById(R.id.classesButton1);

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Pruebitas shydoris PROOOOOFILE",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
