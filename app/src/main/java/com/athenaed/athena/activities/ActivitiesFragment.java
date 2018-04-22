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
import com.athenaed.athena.mundo.AthenaStep;

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


        data.add(new AthenaActivity("Rompecabezas_1","Se enseña por un rompecabezas con frases e información en grupos de reorganizar información dada por un dictado. En grupos de 3 estudiantes. Trabaja comunicación, memoria, trabajo en equipo y el tema.(Además de kinestésico y auditivo)",R.drawable.rompecabezas_2,4,8,2,null,null));
        data.add(new AthenaActivity("Diapositivas Sin Memoria","Uso de lecturas previas sobre el tema para luego mostrar diapositivas incompletas incentivando competencia al dar algún premio a los estudiantes que vayan completando la información. Enseña memoria, incentiva competencia entre estudiantes y da mayor interés por la clase al sentirse como un juego (además de ser visual)",R.drawable.memoria_1,5,5,5,null,null));
        data.add(new AthenaActivity("Procesos Incompletos","Uso de actividad en que se muestran pasos de un proceso de forma visual mientras se explica auditivamente el por qué se hace. Posteriormente, se pide dibujar o hacer en algún material los dos pasos más importantes del proceso. Al estar disociada la parte visual de la auditiva, la parte kinestésica requiere la atención de ambos. Con esto, sirve para entrenamiento total de habilidades enseñando diferentes datos por cada metodología",R.drawable.procesos_1,5,5,5,null,null));
        data.add(new AthenaActivity("Experimento Visual","Se envían detalles para el experimento previos a hacer el mismo. Posteriormente, un grupo lo hace frente a todos para que se explique el cómo hacerlo. Luego de esto, los mismos estudiantes deben repetir el experimento para hacerlo de forma práctica.",R.drawable.rompecabezas_2,1,8,2,null,null));
        data.add(new AthenaActivity("Experimento Memoria","Esto se debe hacer con un tema que minimice el riesgo de los estudiantes. El experimento iniciará con la explicación del mismo de forma auditiva. Al tener esto, se dejará que los estudiantes aprendan del tema de forma práctica.",R.drawable.memoria_1,3,6,2,null,null));


        View view =  inflater.inflate(R.layout.fragment_activities,container,false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.activities_recycler);
        ActivityRecyclerAdapter myAdapter = new ActivityRecyclerAdapter(view.getContext(), data);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        myrv.setAdapter(myAdapter);
        return view;
    }
}
