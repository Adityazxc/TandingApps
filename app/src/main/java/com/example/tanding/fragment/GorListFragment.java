package com.example.tanding.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanding.R;
import com.example.tanding.adapter.GorListAdapter;
import com.example.tanding.model.Gor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GorListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GorListFragment extends Fragment implements GorListAdapter.GorItemCLickListener{

    ProfileFragment profileFragment = new ProfileFragment();
    RecyclerView homeRecyclerView;
    GorListAdapter gorListAdapter;
    ArrayList<Gor> gorArrayList = new ArrayList<>();

    DatabaseReference databaseReference;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GorListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GorListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GorListFragment newInstance(String param1, String param2) {
        GorListFragment fragment = new GorListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gor_list, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Toolbar gorListToolbar = view.findViewById(R.id.toolbar_gor_list);
        ((AppCompatActivity)getActivity()).setSupportActionBar(gorListToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Tanding");
        setHasOptionsMenu(true);

        dataBuild();

        initRecyclerView(view);

        return view;
    }

    private void dataBuild() {
        databaseReference.child("Gor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                gorArrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Gor gor = dataSnapshot.getValue(Gor.class);
                    gor.setKey(dataSnapshot.getKey());
                    Log.d("LINK", "onDataChange: " + gor.getGor_image());
                    gorArrayList.add(gor);
                }
                gorListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initRecyclerView(View view) {
        homeRecyclerView = view.findViewById(R.id.recycler_home);
        homeRecyclerView.setHasFixedSize(true);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        gorListAdapter = new GorListAdapter(gorArrayList, getActivity().getApplicationContext(), this);
        homeRecyclerView.setAdapter(gorListAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.app_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentFrame, profileFragment ,null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void gorItemCLick(Gor gor) {
        Fragment fragmentGorListDetail = GorListDetailFragment.newInstance(gor.getNama_gor(),
                gor.getAlamat(), gor.getJam_buka(), gor.getJam_tutup(), gor.getTanggal_buka(),
                gor.getGor_image(), gor.getKontak(), gor.getHarga(), gor.getKey());

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentFrame, fragmentGorListDetail, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();


    }
}