package com.athenaed.athena.classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaTeacher;

public class StudentActivity extends AppCompatActivity {

    private final static String TAG ="ProfileFragment";
    private TextView tv_name;
    private TextView institucion;
    private TextView porcentaje1;
    private ProgressBar barra1;
    private TextView porcentaje2;
    private ProgressBar barra2;
    private TextView porcentaje3;
    private ProgressBar barra3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student);
        String name = getIntent().getExtras().getString("name");

        tv_name = findViewById(R.id.student_name);
        tv_name.setText(name);

        institucion = findViewById(R.id.institucion);
        institucion.setText("Universidad De Los Andes");

        porcentaje1 = findViewById(R.id.porcentaje1);
        porcentaje1.setText(60 + "");
        barra1 = findViewById(R.id.progressBar1);
        barra1.setProgress(3*20);

        porcentaje2 = findViewById(R.id.porcentaje2);
        porcentaje2.setText(40+ "");
        barra2 = findViewById(R.id.progressBar2);
        barra2.setProgress(2*20);

        porcentaje3 = findViewById(R.id.porcentaje3);
        porcentaje3.setText(80 + "");
        barra3 = findViewById(R.id.progressBar3);
        barra3.setProgress(4*20);
    }
}
