package com.athenaed.athena;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.mundo.Profesor;
import com.athenaed.athena.mundo.Clase;


public class ProfileFragment extends Fragment {
    private final static String TAG ="ProfileFragment";

    private EditText profesor;
    private EditText institucion;
    private TextView porcentaje1;
    private ProgressBar barra1;
    private TextView porcentaje2;
    private ProgressBar barra2;
    private TextView porcentaje3;
    private ProgressBar barra3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile,container,false);

        Profesor prof = new Profesor("Andes", "Mario");
        Clase clasetemp1 = new Clase();
        clasetemp1.setPromedio(3);
        clasetemp1.setTipo("auditivo");
        Clase clasetemp2 = new Clase();
        clasetemp2.setPromedio(4);
        clasetemp2.setTipo("auditivo");
        Clase clasetemp3 = new Clase();
        clasetemp3.setPromedio(4);
        clasetemp3.setTipo("kinestesico");
        Clase clasetemp4 = new Clase();
        clasetemp4.setPromedio(5);
        clasetemp4.setTipo("kinestesico");
        Clase clasetemp5 = new Clase();
        clasetemp5.setPromedio(3);
        clasetemp5.setTipo("visual");
        Clase clasetemp6 = new Clase();
        clasetemp5.setPromedio(5);
        clasetemp5.setTipo("visual");
        prof.agregarClase(clasetemp1);
        prof.agregarClase(clasetemp2);
        prof.agregarClase(clasetemp3);
        prof.agregarClase(clasetemp4);
        prof.agregarClase(clasetemp5);
        prof.agregarClase(clasetemp6);

        profesor = view.findViewById(R.id.profesor);
        profesor.setText(profesor.getText() + " " + prof.nombre);

        institucion = view.findViewById(R.id.institucion);
        institucion.setText(institucion.getText() + " " + prof.institucion);

        porcentaje1 = view.findViewById(R.id.porcentaje1);
        porcentaje1.setText(prof.promedioVisual + "");
        barra1 = view.findViewById(R.id.progressBar1);
        barra1.setProgress(prof.promedioVisual*20);

        porcentaje2 = view.findViewById(R.id.porcentaje2);
        porcentaje2.setText(prof.promedioKinestesico + "");
        barra2 = view.findViewById(R.id.progressBar2);
        barra2.setProgress(prof.promedioKinestesico*20);

        porcentaje3 = view.findViewById(R.id.porcentaje3);
        porcentaje3.setText(prof.promedioAuditivo + "");
        barra3 = view.findViewById(R.id.progressBar3);
        barra3.setProgress(prof.promedioAuditivo*20);

        return view;
    }
}