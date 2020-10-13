package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DebuggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_debug);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihanD);

        MahasiswaRecyclerAdapterDebug mahasiswaRecyclerAdapterDebug;

        //Data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Argo","72110101","084646464646");
        Mahasiswa m2 = new Mahasiswa("Halim","72110101","084646464646");
        Mahasiswa m3 = new Mahasiswa("Jong Jek Siang","72110101","084646464646");
        Mahasiswa m4 = new Mahasiswa("Katon","72110101","084646464646");
        Mahasiswa m5 = new Mahasiswa("Yetli","72110101","084646464646");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);


        mahasiswaRecyclerAdapterDebug = new MahasiswaRecyclerAdapterDebug(DebuggingActivity.this);
        mahasiswaRecyclerAdapterDebug.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(DebuggingActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapterDebug);



    }
}

