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

public class JamAdapter extends RecyclerView.Adapter<JamAdapter.BookingViewAdapter> {
    private List<Gor> gorList;
    private Context context;

    private JamItemClickListener jamItemClickListener;

    public JamAdapter(List<Gor> gorList, Context context, JamItemClickListener jamItemClickListener) {
        this.gorList = gorList;
        this.context = context;
        this.jamItemClickListener = jamItemClickListener;
    }

    @NonNull
    @Override
    public JamAdapter.BookingViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_jam_tanggal, parent, false);
        return new BookingViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JamAdapter.BookingViewAdapter holder, int position) {
        Gor gor = gorList.get(position);
        holder.textView.setText(gor.getJam_buka());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jamItemClickListener.jamOnItemCLick(gorList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return gorList.size();
    }

    public class BookingViewAdapter extends RecyclerView.ViewHolder {
        TextView textView;
        public BookingViewAdapter(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_jam_tanggal_booking);
        }
    }

    public interface JamItemClickListener {
        public void jamOnItemCLick(Gor gor);
    }
}
