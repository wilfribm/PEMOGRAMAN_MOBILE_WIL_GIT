package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);

        Button buttonGetMatkul = (Button)findViewById(R.id.buttonGetMatkul);
        buttonGetMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulGetAllActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAddMatkul = (Button)findViewById(R.id.buttonAddMatkul);
        buttonAddMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulAddActivity.class);
                startActivity(intent);
            }
        });

        Button buttonHapusDataMatkul = (Button)findViewById(R.id.buttonHapusDataMatkul);
        buttonHapusDataMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulDeleteActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUbahDataMatkul = (Button)findViewById(R.id.buttonUbahDataMatkul);
        buttonUbahDataMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulUpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}