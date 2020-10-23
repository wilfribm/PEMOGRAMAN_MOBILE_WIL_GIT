package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaCRUDRecyclerAdapter extends RecyclerView.Adapter<MahasiswaCRUDRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Mahasiswa> mahasiswaList;


    public MahasiswaCRUDRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();

    }

    public MahasiswaCRUDRecyclerAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Mahasiswa m = mahasiswaList.get(i);

        viewHolder.tvNama.setText(m.getNama());
        viewHolder.tvNim.setText(m.getNim());

        viewHolder.tvAlamat.setText(m.getAlamat());
        viewHolder.tvEmail.setText(m.getEmail());


//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama,tvNim,tvAlamat,tvEmail,tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
//            tvNoTelp  = itemView.findViewById(R.id.tvNoTelp);

        }
    }
}
