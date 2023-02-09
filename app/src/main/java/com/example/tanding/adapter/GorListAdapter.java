package com.example.tanding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tanding.R;
import com.example.tanding.model.Gor;

import java.util.List;

public class GorListAdapter extends RecyclerView.Adapter<GorListAdapter.GorListViewHolder> {

    List<Gor> gorList;

    Context context;

    GorItemCLickListener gorItemCLickListener;

    public GorListAdapter(List<Gor> gorList, Context context, GorItemCLickListener gorItemCLickListener) {
        this.gorList = gorList;
        this.context = context;
        this.gorItemCLickListener = gorItemCLickListener;
    }

    @NonNull
    @Override
    public GorListAdapter.GorListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gor_items, parent, false);
        return new GorListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GorListAdapter.GorListViewHolder holder, int position) {
        Gor gor = gorList.get(position);

        Glide.with(holder.itemView)
                        .load(gor.getGor_image())
                                .into(holder.imageViewImgGor);
        holder.textViewNama.setText(gor.getNama_gor());
        holder.textViewTanggal.setText(gor.getTanggal_buka());
        holder.textViewJam.setText(gor.getJam_buka());
        holder.textViewHarga.setText(gor.getHarga());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorItemCLickListener.gorItemCLick(gor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gorList.size();
    }

    public class GorListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewImgGor;
        TextView textViewNama, textViewTanggal, textViewJam, textViewHarga;

        public GorListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewImgGor = itemView.findViewById(R.id.img_gor);
            textViewNama = itemView.findViewById(R.id.txt_nama_gor);
            textViewTanggal = itemView.findViewById(R.id.txt_tanggal);
            textViewJam = itemView.findViewById(R.id.txt_jam);
            textViewHarga = itemView.findViewById(R.id.txt_harga);
        }
    }

    public interface GorItemCLickListener {
        public void gorItemCLick(Gor gor);
    }
}
