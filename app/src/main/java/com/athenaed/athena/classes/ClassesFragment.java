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
import com.athenaed.athena.mundo.AthenaActivity;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaStudent;
import com.athenaed.athena.mundo.AthenaTeacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus} on 3/04/2018.
 */

public class ClassesFragment extends Fragment {
    private final static String TAG ="ClassesFragment";

    ArrayList<AthenaClass> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        data = getArguments().getParcelableArrayList("dataClasses");
        View view =  inflater.inflate(R.layout.fragment_classes,container,false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.classes_recycler);
        ClassesRecyclerAdapter myAdapter = new ClassesRecyclerAdapter(view.getContext(), data);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        myrv.setAdapter(myAdapter);
        return view;
    }
}
