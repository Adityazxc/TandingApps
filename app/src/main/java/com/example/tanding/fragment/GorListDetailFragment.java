package com.example.tanding.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tanding.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GorListDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GorListDetailFragment extends Fragment {
    Toolbar gorListDetailToolbar;

    ImageView imageViewImgGorDetail;

    Button buttonWhatsApp;

    TextView textViewNamaDetail, textViewAlamatDetail, textViewJamBukaDetail, textViewJamTutupDetail,
    textViewTanggalDetail, textViewImgGorDetail, textViewKontakDetail, textViewHargaDetail, textViewKeyDetail;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "nama_gor";
    private static final String ARG_PARAM2 = "alamat";
    private static final String ARG_PARAM3 = "jam_buka";
    private static final String ARG_PARAM4 = "jam_tutup";
    private static final String ARG_PARAM5 = "tanggal_buka";
    private static final String ARG_PARAM6 = "gor_image";
    private static final String ARG_PARAM7 = "kontak";
    private static final String ARG_PARAM8 = "harga";
    private static final String ARG_PARAM9 = "key";


    // TODO: Rename and change types of parameters
    private String nama_gor;
    private String alamat;
    private String jam_buka;
    private String jam_tutup;
    private String tanggal_buka;
    private String gor_image;
    private String kontak;
    private String harga;
    private String key;

    public GorListDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nama_gor Parameter 1.
     * @param alamat Parameter 2.
     * @return A new instance of fragment GorListDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GorListDetailFragment newInstance(String nama_gor, String alamat, String jam_buka,
                                                    String jam_tutup, String tanggal_buka, String gor_image,
                                                    String kontak, String harga, String key) {
        GorListDetailFragment fragment = new GorListDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nama_gor);
        args.putString(ARG_PARAM2, alamat);
        args.putString(ARG_PARAM3, jam_buka);
        args.putString(ARG_PARAM4, jam_tutup);
        args.putString(ARG_PARAM5, tanggal_buka);
        args.putString(ARG_PARAM6, gor_image);
        args.putString(ARG_PARAM7, kontak);
        args.putString(ARG_PARAM8, harga);
        args.putString(ARG_PARAM9, key);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nama_gor = getArguments().getString(ARG_PARAM1);
            alamat = getArguments().getString(ARG_PARAM2);
            jam_buka = getArguments().getString(ARG_PARAM3);
            jam_tutup = getArguments().getString(ARG_PARAM4);
            tanggal_buka = getArguments().getString(ARG_PARAM5);
            gor_image = getArguments().getString(ARG_PARAM6);
            kontak = getArguments().getString(ARG_PARAM7);
            harga = getArguments().getString(ARG_PARAM8);
            key = getArguments().getString(ARG_PARAM9);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gor_list_detail, container, false);

        gorListDetailToolbar = view.findViewById(R.id.toolbar_detail);
        ((AppCompatActivity)getActivity()).setSupportActionBar(gorListDetailToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Detail");

        setOnBackPressed(view);

        imageViewImgGorDetail = view.findViewById(R.id.img_gor_list_booking_detail);
        textViewNamaDetail = view.findViewById(R.id.txt_gor_list_name_booking_detail);
        textViewAlamatDetail = view.findViewById(R.id.txt_gor_list_alamat_booking_detail);
        textViewJamBukaDetail = view.findViewById(R.id.txt_nilai_jam_buka_list);
        textViewJamTutupDetail = view.findViewById(R.id.txt_nilai_jam_tutup_list);
        textViewTanggalDetail = view.findViewById(R.id.txt_nilai_tanggal_buka_list);
        textViewHargaDetail = view.findViewById(R.id.txt_nilai_harga_list);
        textViewKontakDetail = view.findViewById(R.id.txt_nilai_kontak_list);

        Glide.with(getActivity().getApplicationContext())
                .load(gor_image)
                .into(imageViewImgGorDetail);
        textViewNamaDetail.setText(nama_gor);
        textViewAlamatDetail.setText(alamat);
        textViewJamBukaDetail.setText(jam_buka);
        textViewJamTutupDetail.setText(jam_tutup);
        textViewTanggalDetail.setText(tanggal_buka);
        textViewHargaDetail.setText(harga);
        textViewKontakDetail.setText(kontak);

        buttonWhatsApp = view.findViewById(R.id.btn_buat_pesanan_list);

        btnOnClick();

        return view;
    }

    private void btnOnClick() {
        buttonWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!kontak.isEmpty()) {
                    openWhatsApp("+62" + kontak);
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Kontak Tidak Tersedia", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openWhatsApp(String number) {
        String url = "http://api.whatsapp.com/send?phone=" + number;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void setOnBackPressed(View view) {
        gorListDetailToolbar.setNavigationIcon(R.drawable.outline_chevron_left_24);
        gorListDetailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }
}