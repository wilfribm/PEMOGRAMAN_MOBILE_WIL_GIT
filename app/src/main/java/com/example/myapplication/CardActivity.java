package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        CardView cv = (CardView)findViewById(R.id.cvMahasiswa);

        MahasiswaCardAdapter mahasiswaCardAdapter;

        //Data dummy
        List<Mahasiswa> mahasiswaCard = new ArrayList<Mahasiswa>();

        //Genrate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Wil","72180230","08123456");
        Mahasiswa m2 = new Mahasiswa("Wilf","72180231","08123457");
        Mahasiswa m3 = new Mahasiswa("Wilfr","72180232","08123458");
        Mahasiswa m4 = new Mahasiswa("Wilfri","72180233","08123459");

        mahasiswaCard.add(m1);
        mahasiswaCard.add(m2);
        mahasiswaCard.add(m3);
        mahasiswaCard.add(m4);

        mahasiswaCardAdapter = new MahasiswaCardAdapter(CardActivity.this);
        mahasiswaCardAdapter.setMahasiswaCard(mahasiswaCard);






    }
}