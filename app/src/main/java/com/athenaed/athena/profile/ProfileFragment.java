package com.athenaed.athena.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaTeacher;


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

        AthenaTeacher prof = new AthenaTeacher("Andes", "Mario");
        AthenaClass clasetemp1 = new AthenaClass("Clase1", "ABCDE");
        clasetemp1.average = 3;
        clasetemp1.type = "auditivo";
        AthenaClass clasetemp2 = new AthenaClass("Clase1", "ABCDE");
        clasetemp2.average =4;
        clasetemp2.type = "auditivo";
        AthenaClass clasetemp3 = new AthenaClass("Clase1", "ABCDE");
        clasetemp3.average = 4;
        clasetemp3.type = "kinestesico";
        AthenaClass clasetemp4 = new AthenaClass("Clase1", "ABCDE");
        clasetemp4.average = 5;
        clasetemp4.type = "kinestesico";
        AthenaClass clasetemp5 = new AthenaClass("Clase1", "ABCDE");
        clasetemp5.average = 3;
        clasetemp5.type = "visual";
        AthenaClass clasetemp6 = new AthenaClass("Clase1", "ABCDE");
        clasetemp6.average = 5;
        clasetemp6.type = "visual";
        prof.addAthenaClass(clasetemp1);
        prof.addAthenaClass(clasetemp2);
        prof.addAthenaClass(clasetemp3);
        prof.addAthenaClass(clasetemp4);
        prof.addAthenaClass(clasetemp5);
        prof.addAthenaClass(clasetemp6);

        profesor = view.findViewById(R.id.profesor);
        profesor.setText(profesor.getText() + " " + prof.name);

        institucion = view.findViewById(R.id.institucion);
        institucion.setText(institucion.getText() + " " + prof.institution);

        porcentaje1 = view.findViewById(R.id.porcentaje1);
        porcentaje1.setText(60 + "");
        barra1 = view.findViewById(R.id.progressBar1);
        barra1.setProgress(3*20);

        porcentaje2 = view.findViewById(R.id.porcentaje2);
        porcentaje2.setText(40+ "");
        barra2 = view.findViewById(R.id.progressBar2);
        barra2.setProgress(2*20);

        porcentaje3 = view.findViewById(R.id.porcentaje3);
        porcentaje3.setText(80 + "");
        barra3 = view.findViewById(R.id.progressBar3);
        barra3.setProgress(4*20);

        return view;
    }
}