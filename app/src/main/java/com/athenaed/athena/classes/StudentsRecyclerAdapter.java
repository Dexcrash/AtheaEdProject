package com.athenaed.athena.classes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.athenaed.athena.R;
import com.athenaed.athena.activities.ActivityActivity;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaStudent;

import java.util.List;

public class StudentsRecyclerAdapter extends RecyclerView.Adapter<StudentsRecyclerAdapter.StudentsViewHolder> {

    
    Context mContext;
    List<AthenaStudent> mData;

    public StudentsRecyclerAdapter(Context mContext, List<AthenaStudent> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @Override
    public StudentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.student_card_view,parent,false);
        return new StudentsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(StudentsViewHolder holder, final int position) {

        holder.tv_student_name.setText(mData.get(position).name);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,StudentActivity.class);

                // passing data to the book activity
                intent.putExtra("name",mData.get(position).name);
                // start the activity
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class StudentsViewHolder extends RecyclerView.ViewHolder{
        TextView tv_student_name;
        ImageView iv_student;
        CardView cardView ;

        public StudentsViewHolder(View itemView) {
            super(itemView);
            tv_student_name = (TextView) itemView.findViewById(R.id.student_name) ;
            iv_student = itemView.findViewById(R.id.student_img_profile);
            cardView = (CardView) itemView.findViewById(R.id.student_card_view);
        }
    }
}
