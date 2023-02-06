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

public class TanggalAdapter extends RecyclerView.Adapter<TanggalAdapter.BookingViewHolder> {
    private List<Gor> gorList;
    private Context context;

    public TanggalAdapter(List<Gor> gorList, Context context) {
        this.gorList = gorList;
        this.context = context;
    }

    @NonNull
    @Override
    public TanggalAdapter.BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_jam_tanggal, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TanggalAdapter.BookingViewHolder holder, int position) {
        Gor gor = gorList.get(position);
        holder.textView.setText(gor.getTanggal_buka());
    }

    @Override
    public int getItemCount() {
        return gorList.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_jam_tanggal_booking);
        }
    }
}
