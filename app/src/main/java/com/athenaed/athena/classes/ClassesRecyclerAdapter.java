package com.athenaed.athena.classes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import java.util.List;

public class ClassesRecyclerAdapter extends RecyclerView.Adapter<ClassesRecyclerAdapter.ClassViewHolder> {

    
    Context mContext;
    List<AthenaClass> mData;

    public ClassesRecyclerAdapter(Context mContext, List<AthenaClass> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.class_card_view,parent,false);
        return new ClassViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, final int position) {

        holder.tv_class_title.setText(mData.get(position).name);
        holder.tv_class_description.setText(mData.get(position).description);
        holder.img_class_thumbnail.setImageResource(mData.get(position).img_principal);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ClassActivity.class);
                // passing data to the book activity
                intent.putExtra("Name",mData.get(position).name);
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

    public static class ClassViewHolder extends RecyclerView.ViewHolder{
        TextView tv_class_title;
        ImageView img_class_thumbnail;
        TextView tv_class_description;
        CardView cardView ;

        public ClassViewHolder(View itemView) {
            super(itemView);
            tv_class_title = (TextView) itemView.findViewById(R.id.class_txt_title) ;
            tv_class_description = itemView.findViewById(R.id.class_description);
            img_class_thumbnail = (ImageView) itemView.findViewById(R.id.class_image_principal);
            cardView = (CardView) itemView.findViewById(R.id.class_card_view);
        }
    }
}
