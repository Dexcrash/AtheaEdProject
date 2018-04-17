package com.athenaed.athena.classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaStudent;

import java.util.ArrayList;
import java.util.List;

public class Class_infoFragment extends Fragment {

    private ProgressBar barra1;
    private TextView porcentaje1;
    private ProgressBar barra2;
    private TextView porcentaje2;
    private ProgressBar barra3;
    private TextView porcentaje3;

    List<AthenaStudent> data = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class_info, container, false);

        AthenaClass clasetemp = new AthenaClass("CLASE","Mamadas");
        clasetemp.auditory = 50;
        clasetemp.visual = 40;
        clasetemp.kinesthetic = 60;

        porcentaje1 = view.findViewById(R.id.porcentaje1);
        porcentaje1.setText(clasetemp.auditory + "");
        barra1 = view.findViewById(R.id.progressBar1);
        barra1.setProgress(clasetemp.auditory);

        porcentaje2 = view.findViewById(R.id.porcentaje2);
        porcentaje2.setText(clasetemp.kinesthetic + "");
        barra2 = view.findViewById(R.id.progressBar2);
        barra2.setProgress(clasetemp.kinesthetic);

        porcentaje3 = view.findViewById(R.id.porcentaje3);
        porcentaje3.setText(clasetemp.visual + "");
        barra3 = view.findViewById(R.id.progressBar3);
        barra3.setProgress(clasetemp.visual);

        data.add(new AthenaStudent("Camilo Sánchez"));
        data.add(new AthenaStudent("Andrés Bejarano"));
        data.add(new AthenaStudent("Juan Diego Correa"));
        data.add(new AthenaStudent("Gabriel Pinto"));
        data.add(new AthenaStudent("David Acuña"));
        data.add(new AthenaStudent("Julian Arenas"));

        RecyclerView recyclerStudents = (RecyclerView) view.findViewById(R.id.students_recycler);
        StudentsRecyclerAdapter studentsAdapter = new StudentsRecyclerAdapter(view.getContext(), data);
        GridLayoutManager grid = new GridLayoutManager(view.getContext(),1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        recyclerStudents.setLayoutManager(grid);
        recyclerStudents.setAdapter(studentsAdapter);
        recyclerStudents.setFocusableInTouchMode(false);
        return view;
    }

}
