package com.athenaed.athena.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.mundo.AthenaStep;

import java.util.ArrayList;
import java.util.List;

public class ActivityStepsAdapter extends ArrayAdapter<AthenaStep> {

    private Context mContext;
    private List<AthenaStep> arreglo = new ArrayList<>();

    public ActivityStepsAdapter(Context context, List<AthenaStep> users) {
        super(context, R.layout.activity_step_item, users);
        mContext = context;
        arreglo = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        // Get the data item for this position
        // Check if an existing view is being reused, otherwise inflate the view
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_step_item, parent, false);
        }

        AthenaStep user = arreglo.get(position);

        // Lookup view for data population

        TextView number = (TextView) listItem.findViewById(R.id.number);
        TextView title = (TextView) listItem.findViewById(R.id.title);
        TextView description = (TextView) listItem.findViewById(R.id.description);
        // Populate the data into the template view using the data object


        number.setText("Step " + user.getNumber());
        title.setText(user.getTitle());
        description.setText(user.getDescription());
        // Return the completed view to render on screen
        return listItem;
    }
}