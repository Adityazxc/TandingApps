package com.example.tanding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanding.R;
import com.example.tanding.model.Gor;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GorAdapter extends RecyclerView.Adapter<GorAdapter.HomeViewHolder> {
    private List<Gor> gorList;
    private Context context;

    public GorAdapter(List<Gor> gorList, Context context) {
        this.gorList = gorList;
        this.context = context;
    }

    @NonNull
    @Override
    public GorAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GorAdapter.HomeViewHolder holder, int position) {
        Gor gor = gorList.get(position);
        holder.circleImageView.setImageDrawable(context.getResources().getDrawable(gor.getGor_image()));
        holder.textView.setText(gor.getNama_gor());
    }

    @Override
    public int getItemCount() {
        return gorList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView textView;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circle_photo);
            textView = itemView.findViewById(R.id.txt_items_name);
        }
    }
}
