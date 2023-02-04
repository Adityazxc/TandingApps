package com.example.tanding.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tanding.R;
import com.example.tanding.adapter.GorAdapter;
import com.example.tanding.adapter.JadwalAdapter;
import com.example.tanding.adapter.TemanAdapter;
import com.example.tanding.model.Gor;
import com.example.tanding.model.Jadwal;
import com.example.tanding.model.Pesanan;
import com.example.tanding.model.Teman;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private ArrayList<Gor> gorArrayList = new ArrayList<>();
    private ArrayList<Teman> temanArrayList = new ArrayList<>();

    private ArrayList<Jadwal> jadwalArrayList = new ArrayList<>();

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        buildGorData();
        buildTemanData();
        buildJadwalData();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerViewGor = view.findViewById(R.id.recycler_gor);
        recyclerViewGor.setHasFixedSize(true);
        recyclerViewGor.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        GorAdapter gorAdapter = new GorAdapter(gorArrayList, getActivity().getApplicationContext());
        recyclerViewGor.setAdapter(gorAdapter);

        RecyclerView recyclerViewTeman = view.findViewById(R.id.recycler_friend);
        recyclerViewTeman.setHasFixedSize(true);
        recyclerViewTeman.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        TemanAdapter temanAdapter = new TemanAdapter(temanArrayList, getActivity().getApplicationContext());
        recyclerViewTeman.setAdapter(temanAdapter);

        RecyclerView recyclerViewJadwal = view.findViewById(R.id.recycler_schedule);
        recyclerViewJadwal.setHasFixedSize(true);
        recyclerViewJadwal.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        JadwalAdapter jadwalAdapter = new JadwalAdapter(jadwalArrayList, getActivity().getApplicationContext());
        recyclerViewJadwal.setAdapter(jadwalAdapter);
    }

    private void buildGorData() {
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
        gorArrayList.add(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1));
    }

    private void buildTemanData() {
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));
        temanArrayList.add(new Teman("Wahyu", "Laki-laki", "Badminton", R.drawable.teman_photo1));

    }

    private void buildJadwalData() {
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
        jadwalArrayList.add(new Jadwal(new Gor("Sports Arena TTH", "Jl. Raya Kopo No.105", "07:00", "18:00", "01/30/2023", R.drawable.gor_photo1), new Pesanan("00378729", "30/01/2023", "30/01/2023", "10:00", "13:00")));
    }
}