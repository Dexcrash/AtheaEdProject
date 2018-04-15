package com.athenaed.athena.classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;

public class Class_infoFragment extends Fragment {

    private ProgressBar barra1;
    private TextView porcentaje1;
    private ProgressBar barra2;
    private TextView porcentaje2;
    private ProgressBar barra3;
    private TextView porcentaje3;

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


        return view;
    }

}
