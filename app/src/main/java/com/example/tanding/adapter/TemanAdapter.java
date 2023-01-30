package com.example.tanding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanding.R;
import com.example.tanding.model.Teman;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.HomeViewHolder> {
    private List<Teman> temanList;
    private Context context;

    public TemanAdapter(List<Teman> temanList, Context context) {
        this.temanList = temanList;
        this.context = context;
    }

    @NonNull
    @Override
    public TemanAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanAdapter.HomeViewHolder holder, int position) {
        Teman teman = temanList.get(position);
        holder.circleImageView.setImageDrawable(context.getResources().getDrawable(teman.getTeman_photo()));
        holder.textView.setText(teman.getNama_teman());
    }

    @Override
    public int getItemCount() {
        return temanList.size();
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
