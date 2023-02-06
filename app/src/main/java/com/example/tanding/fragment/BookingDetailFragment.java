package com.example.tanding.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanding.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookingDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingDetailFragment extends Fragment {

    ImageView gorImageView;
    TextView gorNamaTextView;
    TextView gorAlamatTextView;

    TextView bookingJamTextView;

    Button buatPesananButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final Integer ARG_PARAM3 = 0;

    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Integer mParam3;
    private String mParam4;


    public BookingDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingDetailFragment newInstance(String param1, String param2, Integer param3, String param4) {
        BookingDetailFragment fragment = new BookingDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(String.valueOf(0), param3);
        args.putString(ARG_PARAM4, param4);
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
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_detail, container, false);

        gorImageView = view.findViewById(R.id.img_gor_booking_detail);
        gorNamaTextView = view.findViewById(R.id.txt_gor_name_booking_detail);
        gorAlamatTextView = view.findViewById(R.id.txt_gor_alamat_booking_detail);
        bookingJamTextView = view.findViewById(R.id.txt_nilai_waktu);

        buatPesananButton = view.findViewById(R.id.btn_buat_pesanan);

        setOnBackPressed(view);

        gorImageView.setImageDrawable(getActivity().getResources().getDrawable(mParam3));
        gorNamaTextView.setText(mParam1);
        gorAlamatTextView.setText(mParam2);
        bookingJamTextView.setText(mParam4);

        btnPesananOnClick();

        return view;
    }

    private void btnPesananOnClick() {
        buatPesananButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
}