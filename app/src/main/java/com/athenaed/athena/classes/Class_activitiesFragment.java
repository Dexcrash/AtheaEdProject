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
import com.athenaed.athena.mundo.AthenaStep;

import java.util.ArrayList;
import java.util.List;

public class Class_activitiesFragment extends Fragment {

    List<AthenaActivity> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList<AthenaStep> pasos1 = new ArrayList<>();
        pasos1.add(new AthenaStep("Dividir el tema en frases significativas(preferiblemente que sean la cantidad de estudiantes divididos 3) y organizar las mismas en pequeños párrafos que las justifiquen.", -1));
        pasos1.add(new AthenaStep( "Dividir el salón de clases en grupos de entre 3 y 4 personas. Esto se hace para incentivar trabajo en equipo.", -1));
        pasos1.add(new AthenaStep( "Posterior a tener los equipos formados, hacer dictado de los párrafos con las frases. Preferiblemente, que la cantidad de párrafos sea igual a la de los grupos y hacer que cada grupo lea un párrafo.", -1));
        pasos1.add(new AthenaStep( "Dar 20 minutos para que los estudiantes armen las frases significativas de los párrafos leídos por todo grupo excluyendo el propio.",-1));

        data.add(new AthenaActivity("Rompecabezas_1","Se enseña por un rompecabezas con frases e información en grupos de reorganizar información dada por un dictado. En grupos de 3 estudiantes. Trabaja comunicación, memoria, trabajo en equipo y el tema.(Además de kinestésico y auditivo)",R.drawable.rompecabezas_2,4,8,2,pasos1));
        data.add(new AthenaActivity("Diapositivas Sin Memoria","Uso de lecturas previas sobre el tema para luego mostrar diapositivas incompletas incentivando competencia al dar algún premio a los estudiantes que vayan completando la información. Enseña memoria, incentiva competencia entre estudiantes y da mayor interés por la clase al sentirse como un juego (además de ser visual)",R.drawable.memoria_1,5,5,5,pasos1));
        data.add(new AthenaActivity("Procesos Incompletos","Uso de actividad en que se muestran pasos de un proceso de forma visual mientras se explica auditivamente el por qué se hace. Posteriormente, se pide dibujar o hacer en algún material los dos pasos más importantes del proceso. Al estar disociada la parte visual de la auditiva, la parte kinestésica requiere la atención de ambos. Con esto, sirve para entrenamiento total de habilidades enseñando diferentes datos por cada metodología",R.drawable.procesos_1,5,5,5,pasos1));


        View view =  inflater.inflate(R.layout.fragment_activities,container,false);
        RecyclerView myrv = (RecyclerView) view.findViewById(R.id.activities_recycler);
        ActivityRecyclerAdapter myAdapter = new ActivityRecyclerAdapter(view.getContext(), data);
        myrv.setLayoutManager(new GridLayoutManager(view.getContext(),1));
        myrv.setAdapter(myAdapter);
        return view;
    }
}
