package com.example.tanding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanding.R;
import com.example.tanding.model.Jadwal;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.HomeViewHolder> {
    private List<Jadwal> jadwalList;
    private Context context;

    public JadwalAdapter(List<Jadwal> jadwalList, Context context) {
        this.jadwalList = jadwalList;
        this.context = context;
    }

    @NonNull
    @Override
    public JadwalAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_jadwal, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.HomeViewHolder holder, int position) {
        Jadwal jadwal = jadwalList.get(position);
        holder.txtGor.setText(jadwal.getGor().getNama_gor());
        holder.txtTanggal.setText(jadwal.getPesanan().getTanggal_bermain());
        holder.txtJam.setText(jadwal.getPesanan().getJam_mulai());

    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView txtGor, txtTanggal, txtJam;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtGor = itemView.findViewById(R.id.txt_jadwal_nama_gor);
            txtTanggal = itemView.findViewById(R.id.txt_tanggal_bermain);
            txtJam = itemView.findViewById(R.id.txt_jam_mulai);
        }
    }
}
