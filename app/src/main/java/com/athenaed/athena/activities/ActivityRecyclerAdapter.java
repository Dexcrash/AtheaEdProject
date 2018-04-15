package com.athenaed.athena.activities;

import android.app.Activity;
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
import com.athenaed.athena.mundo.AthenaActivity;
import com.athenaed.athena.mundo.AthenaClass;

import java.util.List;

public class ActivityRecyclerAdapter extends RecyclerView.Adapter<ActivityRecyclerAdapter.ActivityViewHolder> {

    Context mContext;
    List<AthenaActivity> mData;

    public ActivityRecyclerAdapter(Context mContext, List<AthenaActivity> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.activity_card_view,parent,false);
        return new ActivityViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ActivityViewHolder holder, final int position) {
        holder.tv_activity_title.setText(mData.get(position).name);
        holder.img_activity_thumbnail.setImageResource(mData.get(position).img_principal);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ActivityActivity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).name);
                intent.putExtra("Description",mData.get(position).description);
                intent.putExtra("Thumbnail",mData.get(position).img_principal);
                // start the activity
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder{
        TextView tv_activity_title;
        ImageView img_activity_thumbnail;
        CardView cardView ;

        public ActivityViewHolder(View itemView) {
            super(itemView);
            tv_activity_title = (TextView) itemView.findViewById(R.id.activity_txt_title) ;
            img_activity_thumbnail = (ImageView) itemView.findViewById(R.id.activity_img_principal);
            cardView = (CardView) itemView.findViewById(R.id.activity_card_view);
        }
    }
}
