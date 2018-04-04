package com.athenaed.athena;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.athenaed.athena.mundo.ProfesorTemp;


public class ProfileFragment extends Fragment {
    private final static String TAG ="ProfileFragment";

    private EditText profesor;
    private EditText institucion;
    private EditText clase;
    private EditText porcentaje1;
    private ProgressBar barra;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_classes,container,false);

        ProfesorTemp prof = new ProfesorTemp("Andes", "Mario");

        profesor = view.findViewById(R.id.profesor);
        profesor.setText(profesor.getText() + prof.nombre);

        institucion = view.findViewById(R.id.institucion);
        institucion.setText(profesor.getText() + prof.institucion);

        clase = view.findViewById(R.id.clase);
        clase.setText(profesor.getText() + " 1");

        porcentaje1.setText(prof.clases.get(0).rating + "%");

        barra.setProgress(prof.clases.get(0).rating);

        return view;
    }
}