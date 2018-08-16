package com.athenaed.athena.classes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaStudent;
import com.athenaed.athena.mundo.AthenaTeacher;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private final static String TAG ="ProfileFragment";
    private TextView tv_name;
    private TextView institucion;
    private TextView tv_coments;
    private LineChart lineChart;
    private BarChart barChart;
    private ImageView imagen;
    private String barSelected = "Musical";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student);

        AthenaStudent student = (AthenaStudent) getIntent().getExtras().get("data");

        tv_name = findViewById(R.id.student_activity_name);
        tv_name.setText(student.name);

        institucion = findViewById(R.id.student_activity_institution);
        institucion.setText("Colegio de Prueba XVI");

        imagen = findViewById(R.id.student_activity_image);
        imagen.setImageResource(student.img_profile);

        tv_coments = findViewById(R.id.student_activity_comentarios);
        tv_coments.setText(student.comentarios);

        //LineChart Config
        lineChart = findViewById(R.id.students_activity_linechart);
        updateChart();


        //BarChart Config
        List<BarEntry> entries2 = new ArrayList<BarEntry>();
        barChart = findViewById(R.id.student_activity_barchart);
        entries2.add(new BarEntry(0,(float) student.musical));
        entries2.add(new BarEntry(1,(float) student.interpersonal));
        entries2.add(new BarEntry(2,(float) student.corporal));
        entries2.add(new BarEntry(3,(float) student.naturalista));
        entries2.add(new BarEntry(4,(float) student.linguistico));
        entries2.add(new BarEntry(5,(float) student.intrapersonal));
        entries2.add(new BarEntry(6,(float) student.visual));
        entries2.add(new BarEntry(7,(float) student.logico));
        final BarDataSet bardataset = new BarDataSet(entries2,"Inteligencias");
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Musical");
        labels.add("Interpersonal");
        labels.add("Corporal");
        labels.add("Naturalista");
        labels.add("Linguistica");
        labels.add("Intrapersonal");
        labels.add("Espacial");
        labels.add("Logica");
        bardataset.setColors(ColorTemplate.VORDIPLOM_COLORS);
        BarData bardata = new BarData(bardataset);
        barChart.setData(bardata);
        Description d = new Description();
        d.setText("");
        barChart.setDescription(d);
        barChart.setPinchZoom(false);
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                barSelected = barChart.getXAxis().getValueFormatter().getFormattedValue(e.getX(), barChart.getXAxis());
                updateChart();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    private void updateChart(){

        Integer[] x = {1,2,3,4,5,6,7,8,9,10,11,12};
        Integer[] y = {1,2,3,4,5,6,7,8,9,10,11,12};
        Integer[] y1 = {3,4,3,5,5,5,6,5,5,4,5,6};
        Integer[] y2 = {1,2,3,1,3,4,4,4,4,4,5,4};
        Integer[] y3 = {5,5,5,4,5,6,5,5,5,4,5,6};
        Integer[] y4 = {3,2,3,4,5,6,4,4,4,4,5,4};
        Integer[] y5 = {1,2,3,2,1,3,3,2,3,2,2,2};
        Integer[] y6 = {7,6,5,5,5,6,5,8,7,7,7,6};
        Integer[] y7 = {5,5,4,4,5,6,4,2,3,4,4,3};
        Integer[] y8 = {7,8,5,6,5,6,7,8,6,5,5,7};

        ArrayList<Entry> entries = new ArrayList<Entry>();

        if(barSelected.equals("Musical")){
            y = y1;
        }else if(barSelected.equals("Interpersonal")){
            y = y2;
        }else if(barSelected.equals("Corporal")){
            y = y3;
        }else if(barSelected.equals("Naturalista")){
            y = y4;
        }else if(barSelected.equals("Linguistica")){
            y = y5;
        }else if(barSelected.equals("Intrapersonal")){
            y = y6;
        }else if(barSelected.equals("Espacial")){
            y = y7;
        }else if(barSelected.equals("Logica")){
            y = y8;
        }else{

        }

        for (int i=0;i<x.length;i++){
            entries.add(new Entry(x[i], y[i]));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Analisis de " + barSelected); // add entries to dataset
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        ArrayList<String> mes = new ArrayList<String>();
        for(String s: meses){
            mes.add(s);
        }
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.setPinchZoom(false);
        lineChart.setDoubleTapToZoomEnabled(false);
        Description d1 = new Description();
        d1.setText("");
        lineChart.setDescription(d1);
        lineChart.invalidate();
    }
}
