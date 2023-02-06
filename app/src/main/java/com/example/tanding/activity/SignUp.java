package com.example.tanding.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tanding.R;

public class SignUp extends AppCompatActivity {

        Button btn_signup;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_up);

            btn_signup=(Button) findViewById(R.id.btn_signup);
            btn_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignUp.this, MainActivity.class);
                    SignUp.this.startActivity(intent);
                    finish();
                }
            });


        }
    }

