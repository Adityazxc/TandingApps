package com.example.tanding.fragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanding.R;
import com.example.tanding.adapter.JamAdapter;
import com.example.tanding.adapter.TanggalAdapter;
import com.example.tanding.model.Gor;
import com.example.tanding.model.GorList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingFragment extends Fragment implements JamAdapter.JamItemClickListener {

    ImageView gorImageView;
    TextView gorNamaTextView;
    TextView gorAlamatTextView;

    ArrayList<Gor> gorArrayList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final Integer ARG_PARAM3 = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Integer mParam3;


    public BookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingFragment newInstance(String param1, String param2, Integer param3) {
        BookingFragment fragment = new BookingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(String.valueOf(0), param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(String.valueOf(0));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        gorImageView = view.findViewById(R.id.img_gor_booking);
        gorNamaTextView = view.findViewById(R.id.txt_gor_name_booking);
        gorAlamatTextView = view.findViewById(R.id.txt_gor_alamat_booking);

        setOnBackPressed(view);

        gorImageView.setImageDrawable(getContext().getResources().getDrawable(mParam3));
        gorNamaTextView.setText(mParam1);
        gorAlamatTextView.setText(mParam2);

//        buildJamData();
        initRecyclerView(view);

        return view;
    }

    private void setOnBackPressed(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.chevron_left_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerViewJam = view.findViewById(R.id.recycler_gor_jam);
        recyclerViewJam.setHasFixedSize(true);
        recyclerViewJam.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        JamAdapter jamAdapter = new JamAdapter(gorArrayList, getActivity().getApplicationContext(), this);
        recyclerViewJam.setAdapter(jamAdapter);

        RecyclerView recyclerViewTanggal = view.findViewById(R.id.recycler_gor_tanggal);
        recyclerViewTanggal.setHasFixedSize(true);
        recyclerViewTanggal.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        TanggalAdapter tanggalAdapter = new TanggalAdapter(gorArrayList, getActivity().getApplicationContext());
        recyclerViewTanggal.setAdapter(tanggalAdapter);
    }

//    private void buildJamData() {
//        gorArrayList.clear();
//
//        for (int i = 0; i < GorList.nama_gor.length; i++) {
//            gorArrayList.add(new Gor(
//                    mParam1,
//                    mParam2,
//                    GorList.jam_buka[i],
//                    "",
//                    GorList.tanggal_buka[i],
//                    mParam3
//            ));
//        }
//    }

    @Override
    public void jamOnItemCLick(Gor gor) {
        Fragment bookingDetailFragment = BookingDetailFragment.newInstance(gor.getNama_gor(), gor.getAlamat(), 0, gor.getJam_buka());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentFrame, bookingDetailFragment, null)
                .setReorderingAllowed(true)
                .addToBackStack("booking")
                .commit();
    }
}