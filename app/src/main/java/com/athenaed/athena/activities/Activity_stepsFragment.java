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

        String actividad = (String)getArguments().get("Title");

        List<AthenaStep> arreglo = new ArrayList<>();
        AthenaStep s11 = new AthenaStep("Dividir el tema en frases significativas(preferiblemente que sean la cantidad de estudiantes divididos 3) y organizar las mismas en pequeños párrafos que las justifiquen.", -1);
        AthenaStep s12 = new AthenaStep( "Dividir el salón de clases en grupos de entre 3 y 4 personas. Esto se hace para incentivar trabajo en equipo.", -1);
        AthenaStep s13 = new AthenaStep( "Posterior a tener los equipos formados, hacer dictado de los párrafos con las frases. Preferiblemente, que la cantidad de párrafos sea igual a la de los grupos y hacer que cada grupo lea un párrafo.", -1);
        AthenaStep s14 = new AthenaStep( "Dar 20 minutos para que los estudiantes armen las frases significativas de los párrafos leídos por todo grupo excluyendo el propio.",-1);

        AthenaStep s21 = new AthenaStep("Iniciar con el envío de lecturas previas sobre el tema a los distintos estudiantes.", -1);
        AthenaStep s22 = new AthenaStep( "Sobre los temas más importantes de las lecturas, crear diapositivas con información faltante para ser completada.", -1);
        AthenaStep s23 = new AthenaStep( "Poner reglas para pedir palabra a los estudiantes al intentar llenar la información.", -1);
        AthenaStep s24 = new AthenaStep( "Con estas reglas, pasar diapositiva por diapositiva para hacer que los estudiantes compitan por llenarlas.",-1);
        AthenaStep s25 = new AthenaStep("Al acabar la actividad, recompensar con algo al estudiante con mayor cantidad de puntos o hacer esta actividad como quiz de lectura previa", -1);

        AthenaStep s31 = new AthenaStep( "Prepara el tema sobre un procedimiento con los pasos de forma visual(Diapositivas, por ejemplo).", -1);
        AthenaStep s32 = new AthenaStep( "Separar de los pasos la justificación de por qué el proceso es importante para el área, a manera de dictado.", -1);
        AthenaStep s33 = new AthenaStep( "Mostrar a la clase el procedimiento sin dar explicación específica de cada paso, mientras tanto, hablar de la importancia del proceso.", -1);
        AthenaStep s34 = new AthenaStep( "Pedir a cada estudiante que modele, según los temas, los dos pasos más importantes del proceso según lo que vio y escuchó. Preferiblemente hacerlo con plastilina(u otro material parecido) o un dibujo en caso de que no haya materiales.", -1);
        AthenaStep s35 = new AthenaStep( "Luego de la entrega, explicar el paso a paso del proceso. Al conocer la importancia del mismo y haber modelado lo que consideraban más importante, los estudiantes serán más propensos a entender el mismo.", -1);

        AthenaStep s41 = new AthenaStep( "Enviar detalles del experimento a los estudiantes.", -1);
        AthenaStep s42 = new AthenaStep( "Preparar el mismo experimento para que se haga frente a ellos.", -1);
        AthenaStep s43 = new AthenaStep( "Demostrar el experimento frente a los estudiantes para que sea repetible al inicio de la clase", -1);
        AthenaStep s44 = new AthenaStep( "Dejar que los estudiantes hagan el experimento.", -1);

        AthenaStep s51 = new AthenaStep( "Preparar el experimento paso a paso en forma de dictado, oral.", -1);
        AthenaStep s52 = new AthenaStep( "Dividir a los estudiantes en grupos para el experimento.", -1);
        AthenaStep s53 = new AthenaStep( "Explicar de forma oral el experimento a los estudiantes sin permitir que inicien hasta el final del dictado.", -1);
        AthenaStep s54 = new AthenaStep( "Hacer que los estudiantes hagan el experimento.", -1);


        if(actividad == "Rompecabezas_1"){
            arreglo.add(s11);
            arreglo.add(s12);
            arreglo.add(s13);
            arreglo.add(s14);
        }else if(actividad == "Diapositivas Sin Memoria"){
            arreglo.add(s21);
            arreglo.add(s22);
            arreglo.add(s23);
            arreglo.add(s24);
            arreglo.add(s25);
        }else if(actividad == "Procesos Incompletos"){
            arreglo.add(s31);
            arreglo.add(s32);
            arreglo.add(s33);
            arreglo.add(s34);
            arreglo.add(s35);
        }else if(actividad == "Experimento Visual"){
            arreglo.add(s41);
            arreglo.add(s42);
            arreglo.add(s43);
            arreglo.add(s44);
        }else if(actividad == "Experimento Memoria"){
            arreglo.add(s51);
            arreglo.add(s52);
            arreglo.add(s53);
            arreglo.add(s54);
        }else {
            arreglo.add(s21);
            arreglo.add(s22);
            arreglo.add(s23);
            arreglo.add(s24);
            arreglo.add(s25);
        }

// Create the adapter to convert the array to views
        ActivityStepsAdapter adapter = new ActivityStepsAdapter(getActivity(), arreglo);
// Attach the adapter to a ListView
        ListView listView = (ListView) view.findViewById(R.id.list);

        listView.setAdapter(adapter);

      return view;
    }
}
