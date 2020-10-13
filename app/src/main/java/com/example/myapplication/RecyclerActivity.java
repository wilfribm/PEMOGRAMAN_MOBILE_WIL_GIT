package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihanD);

        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;

        //Data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //Genrate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Wil","72180230","08123456");
        Mahasiswa m2 = new Mahasiswa("Wilf","72180231","08123457");
        Mahasiswa m3 = new Mahasiswa("Wilfr","72180232","08123458");
        Mahasiswa m4 = new Mahasiswa("Wilfri","72180233","08123459");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);

        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(RecyclerActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);



    }
}