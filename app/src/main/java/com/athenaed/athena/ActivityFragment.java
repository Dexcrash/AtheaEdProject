package com.athenaed.athena;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.mundo.Actividad;

public class ActivityFragment extends Fragment {

    private final static String TAG ="ActivitiesFragment";

    private EditText titulo;
    private TextView descripcion2;
    private ProgressBar barra1;
    private TextView porcentaje1;
    private ProgressBar barra2;
    private TextView porcentaje2;
    private ProgressBar barra3;
    private TextView porcentaje3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_activity,container,false);
        String descripcion = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat";
        Actividad act = new Actividad("Movie", descripcion, 30,40,60);

        titulo = view.findViewById(R.id.activity);
        titulo.setText(titulo.getText() + " " + act.nombre);

        descripcion2 = view.findViewById(R.id.text);
        descripcion2.setText(descripcion2.getText());

        porcentaje1 = view.findViewById(R.id.porcentaje1);
        porcentaje1.setText(act.auditiva + "");
        barra1 = view.findViewById(R.id.progressBar1);
        barra1.setProgress(act.auditiva);

        porcentaje2 = view.findViewById(R.id.porcentaje2);
        porcentaje2.setText(act.kinestesica + "");
        barra2 = view.findViewById(R.id.progressBar2);
        barra2.setProgress(act.kinestesica);

        porcentaje3 = view.findViewById(R.id.porcentaje3);
        porcentaje3.setText(act.visual + "");
        barra3 = view.findViewById(R.id.progressBar3);
        barra3.setProgress(act.visual);

        return view;
    }
}