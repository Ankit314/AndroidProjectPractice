package com.example.internshipviewpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class vpAdapter extends RecyclerView.Adapter<vpAdapter.ViewHolder> {
    ArrayList<viewpager_item>viewpagerItemArrayList;

    public vpAdapter(ArrayList<viewpager_item> viewpagerItemArrayList) {
        this.viewpagerItemArrayList = viewpagerItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewpager_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        viewpager_item viewpagerItem=viewpagerItemArrayList.get(position);

        holder.imageView.setImageResource(viewpager_item.imageID);
        holder.tcHeading.setText(viewpager_item.heading);
        holder.tvDesc.setText(viewpager_item.description);

    }

    @Override
    public int getItemCount() {
        return viewpagerItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tcHeading,tvDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ivimage);
            tcHeading=itemView.findViewById(R.id.tvHeading);
            tvDesc=itemView.findViewById(R.id.tvDesc);

        }
    }

}
