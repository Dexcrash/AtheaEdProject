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


    List<AthenaClass> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        AthenaTeacher prof = new AthenaTeacher("Colegio de Prueba XVI", "Julia Torres Sarmiento");

        AthenaClass clasetemp1 = new AthenaClass("Sexto B", "Clase muy tranquila, callados y respetuosos. Stienden muy bien a clase.", R.drawable.class_1);
        clasetemp1.average = 3;
        clasetemp1.type = "auditivo";
        AthenaClass clasetemp2 = new AthenaClass("Octavo C", "Dispersos y en ocasiones muy habladores. Pero bastante responsable socn los trabajos.", R.drawable.class_2);
        clasetemp2.average =4;
        clasetemp2.type = "auditivo";
        AthenaClass clasetemp3 = new AthenaClass("Octavo A", "Una de las mejores clases del colegio, atienden de forma respetuosa y su responsabilidad con trabajos es ejemplar.", R.drawable.class_3);
        clasetemp3.average = 4;
        clasetemp3.type = "kinestesico";
        AthenaClass clasetemp4 = new AthenaClass("Sexto A", "Clase juiciosa y dedicada, con algunos distraidos, pero en general buenos estudiantes todos.", R.drawable.class_2);
        clasetemp4.average = 5;
        clasetemp4.type = "kinestesico";
        AthenaClass clasetemp5 = new AthenaClass("Decimo C", "El decimo más complicado, se distren bastante y se faltan demasiado alr espeto entre ellos. NO estan mal academicamente pero les falta convivencia.", R.drawable.class_3);
        clasetemp5.average = 3;
        clasetemp5.type = "visual";
        AthenaClass clasetemp6 = new AthenaClass("Decimo A", "Una clase muy interesante de trabajar, los estudiantes atienden a las clases y participan de manera activa, proponiendo siempre, apropiendose de su proceso de aprendizaje.",R.drawable.class_1);
        clasetemp6.average = 5;
        clasetemp6.type = "auditivo";
        AthenaClass clasetemp7 = new AthenaClass("Decimo B", "Muy respondables con los trabajos, pero hace falta mayor participacion en clase, muy pocos se preocupan por participar y apropiarse d elos temas vistos.", R.drawable.class_2);
        clasetemp6.average = 5;
        clasetemp6.type = "visual";
        AthenaClass clasetemp8 = new AthenaClass("Sexto C", "Estudiantes aplicados, con excepcion de unos pocos que presentan graves problemas de atencion y trabajo en grupo.", R.drawable.class_1);
        clasetemp6.average = 5;
        clasetemp6.type = "visual";
        AthenaClass clasetemp9 = new AthenaClass("Octavo B", "Una clase muy alegre y despuesta a aprender en todo momento, solo cuenta con un caso complciado, pero son estudiantes que valoran el trabajo en equipo y hacen uso de este en todo momento.", R.drawable.class_3);
        clasetemp6.average = 5;
        clasetemp6.type = "kinestesico";

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
