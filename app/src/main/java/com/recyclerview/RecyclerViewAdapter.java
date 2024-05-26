package com.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<CategoryModel> categoryList;
    public RecyclerViewAdapter(Context context, ArrayList<CategoryModel> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.label.setText(categoryList.get(position).getLabel());
        holder.des.setText(categoryList.get(position).getDes());
        holder.thumbnail.setImageResource(categoryList.get(position).getThumbnail());
        holder.label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("thumbnailID", categoryList.get(holder.getAdapterPosition()).getThumbnail());
                intent.putExtra("label", categoryList.get(holder.getAdapterPosition()).getLabel());
                intent.putExtra("des", categoryList.get(holder.getAdapterPosition()).getDes());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView label;
        TextView des;
        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            label = itemView.findViewById(R.id.label);
            des = itemView.findViewById(R.id.des);
        }
    }
}