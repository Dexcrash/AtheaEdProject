package com.athenaed.athena.classes;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaStudent;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Class_infoFragment extends Fragment {

    private ImageView image;
    private TextView description;
    private TextView name;
    private PieChart piechart;


    List<AthenaStudent> data = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class_info, container, false);

        Bundle b = getArguments();
        AthenaClass clasetemp = (AthenaClass) b.get("data");

        name = view.findViewById(R.id.class_activity_name);
        name.setText(clasetemp.name);

        description = view.findViewById(R.id.class_description);
        description.setText(clasetemp.description);

        image = view.findViewById(R.id.class_activity_image);
        image.setImageResource(clasetemp.img_principal);

        piechart = view.findViewById(R.id.class_activity_piechart);

        //PieChart Config

        List<PieEntry> pieEntries = new ArrayList<PieEntry>();
        pieEntries.add(new PieEntry(15,"Musical"));
        pieEntries.add(new PieEntry(5,"Interpersonal"));
        pieEntries.add(new PieEntry(20,"Corporal"));
        pieEntries.add(new PieEntry(12,"Naturalista"));
        pieEntries.add(new PieEntry(8,"Linguistica"));
        pieEntries.add(new PieEntry(19,"Intrapersonal"));
        pieEntries.add(new PieEntry(11,"Espacial"));
        pieEntries.add(new PieEntry(10,"Logica"));

        PieDataSet piedataset = new PieDataSet(pieEntries,"");

        // add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);


        piedataset.setValueLinePart1OffsetPercentage(80.f);
        piedataset.setValueLinePart1Length(0.2f);
        piedataset.setValueLinePart2Length(0.4f);
        //dataSet.setUsingSliceColorAsValueLineColor(true);

        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        piedataset.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        piedataset.setColors(colors);
        piedataset.setValueTextColor(Color.BLACK);
        PieData piedata = new PieData(piedataset);
        Description d = new Description();
        d.setText("");

        //dataSet.setSelectionShift(0f);
        piedata.setValueFormatter(new PercentFormatter());
        piedata.setValueTextSize(11f);
        piedata.setValueTextColor(Color.BLACK);

        piechart.setDescription(d);
        piechart.setData(piedata);
        piechart.invalidate();

        data = clasetemp.students;
        RecyclerView recyclerStudents = (RecyclerView) view.findViewById(R.id.class_activity_students_recycler);
        StudentsRecyclerAdapter studentsAdapter = new StudentsRecyclerAdapter(view.getContext(), data);
        recyclerStudents.setLayoutManager(new LinearLayoutManager(view.getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerStudents.setAdapter(studentsAdapter);
        return view;
    }
}