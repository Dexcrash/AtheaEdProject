package com.athenaed.athena;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaTeacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus} on 3/04/2018.
 */

public class ClassesFragment extends Fragment {
    private final static String TAG ="ClassesFragment";


    List<AthenaClass> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        AthenaTeacher prof = new AthenaTeacher("Andes", "Mario");

        AthenaClass clasetemp1 = new AthenaClass("Clase1", "ABCDE");
        clasetemp1.average = 3;
        clasetemp1.type = "auditivo";
        AthenaClass clasetemp2 = new AthenaClass("Clase1", "ABCDE");
        clasetemp2.average =4;
        clasetemp2.type = "auditivo";
        AthenaClass clasetemp3 = new AthenaClass("Clase1", "ABCDE");
        clasetemp3.average = 4;
        clasetemp3.type = "kinestesico";
        AthenaClass clasetemp4 = new AthenaClass("Clase1", "ABCDE");
        clasetemp4.average = 5;
        clasetemp4.type = "kinestesico";
        AthenaClass clasetemp5 = new AthenaClass("Clase1", "ABCDE");
        clasetemp5.average = 3;
        clasetemp5.type = "visual";
        AthenaClass clasetemp6 = new AthenaClass("Clase1", "ABCDE");
        clasetemp6.average = 5;
        clasetemp6.type = "visual";
        prof.addAthenaClass(clasetemp1);
        prof.addAthenaClass(clasetemp2);
        prof.addAthenaClass(clasetemp3);
        prof.addAthenaClass(clasetemp4);
        prof.addAthenaClass(clasetemp5);
        prof.addAthenaClass(clasetemp6);

        data = prof.classes;
        View view =  inflater.inflate(R.layout.fragment_classes,container,false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.classes_recycler);
        ClassesRecyclerAdapter myAdapter = new ClassesRecyclerAdapter(view.getContext(), data);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        myrv.setAdapter(myAdapter);
        return view;
    }
}
