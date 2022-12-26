package com.example.tanding.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tanding.R;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin,text_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        text_signup = (Button) findViewById(R.id.text_signup);
//        text_signup.setOnClickListener(new View.OnClickListener()){
//            @Override
//                    public void onClick(View v){
//
//            }
//        };

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey=username.getText().toString();
                String passwordKey=password.getText().toString();


                if(usernameKey.equals("admin")&&passwordKey.equals("admin")) {

                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else{
                        //jika login gagal
                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Username atau Password Anda salah").setNegativeButton("Retry",null).create().show();
                    }
                }
        });
    }
}