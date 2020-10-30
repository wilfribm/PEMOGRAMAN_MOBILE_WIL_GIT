package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanUtamaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        Button buttonKelolaDosen = findViewById(R.id.buttonKelolaDosen);
        Button buttonKelolaMahasiswa = findViewById(R.id.buttonKelolaMahasiswa);
        Button buttonKelolaMatakuliah = findViewById(R.id.buttonKelolaMatakuliah);
        Button buttonLogout = findViewById(R.id.buttonLogout);

        buttonKelolaDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanUtamaActivity.this, MainDsnActivity.class);
                startActivity(intent);
            }
        });

        buttonKelolaMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanUtamaActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });

        buttonKelolaMatakuliah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanUtamaActivity.this, MainMatkulActivity.class);
                startActivity(intent);
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanUtamaActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}