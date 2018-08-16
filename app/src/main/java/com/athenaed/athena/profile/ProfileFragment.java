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
import com.athenaed.athena.mundo.AthenaActivity;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaTeacher;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
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
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private final static String TAG = "ProfileFragment";

    private TextView profesor;
    private TextView institucion;
    private ImageView foto;
    private LineChart lineChart;
    private HorizontalBarChart barChart;
    private String barSelected = "Musical";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        AthenaTeacher prof = (AthenaTeacher) getArguments().get("dataTeacher");

        profesor = view.findViewById(R.id.teacher_name);
        profesor.setText(prof.name);

        foto = view.findViewById(R.id.teacher_image);
        foto.setImageResource(R.drawable.teacher_1);

        institucion = view.findViewById(R.id.teacher_institucion);
        institucion.setText(prof.institution);

        //CharLine Config
        lineChart = view.findViewById(R.id.lineChart);
        updateChart();

        //CharLine Config
        List<BarEntry> entries2 = new ArrayList<BarEntry>();
        barChart = view.findViewById(R.id.barChart);
        entries2.add(new BarEntry(0, 1));
        entries2.add(new BarEntry(1, 4));
        entries2.add(new BarEntry(2, 6));
        entries2.add(new BarEntry(3, 2));
        entries2.add(new BarEntry(4, 3));
        entries2.add(new BarEntry(5, 6));
        entries2.add(new BarEntry(6, 10));
        entries2.add(new BarEntry(7, 6));
        BarDataSet bardataset = new BarDataSet(entries2, "Inteligencias");
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
        return view;
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