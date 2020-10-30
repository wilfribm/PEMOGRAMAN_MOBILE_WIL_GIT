package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainDsnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dsn);

        Button btnGetDsn = (Button)findViewById(R.id.buttonGetDsn);
        btnGetDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenGetAllActivity.class);
                startActivity(intent);
            }
        });

        Button btnAddMhs = (Button)findViewById(R.id.buttonAddMhs);
        btnAddMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });

        Button btnHpsData = (Button)findViewById(R.id.buttonHapusData);
        btnHpsData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenDeleteActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUbahData = (Button)findViewById(R.id.buttonUbahData);
        buttonUbahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDsnActivity.this, DosenUpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}