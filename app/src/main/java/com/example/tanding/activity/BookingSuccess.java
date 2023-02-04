package com.example.tanding.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tanding.R;

public class BookingSuccess extends AppCompatActivity {

    Button btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success_booking);

        btn_home=(Button) findViewById(R.id.btn_beranda);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingSuccess.this, MainActivity.class);
                BookingSuccess.this.startActivity(intent);
                finish();
            }
        });


    }
}