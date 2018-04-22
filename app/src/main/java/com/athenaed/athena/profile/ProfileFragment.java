package com.athenaed.athena.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaTeacher;


public class ProfileFragment extends Fragment {
    private final static String TAG ="ProfileFragment";

    private TextView profesor;
    private TextView institucion;
    private TextView porcentaje1;
    private ProgressBar barra1;
    private TextView porcentaje2;
    private ProgressBar barra2;
    private TextView porcentaje3;
    private ProgressBar barra3;
    private ImageView foto;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_profile,container,false);

        AthenaTeacher prof = new AthenaTeacher("Colegio de Prueba XVI", "Julia Torres Sarmiento");

        profesor = view.findViewById(R.id.teacher_name);
        profesor.setText(prof.name);

        foto = view.findViewById(R.id.teacher_image);
        foto.setImageResource(R.drawable.teacher_1);

        institucion = view.findViewById(R.id.teacher_institucion);
        institucion.setText(prof.institution);

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