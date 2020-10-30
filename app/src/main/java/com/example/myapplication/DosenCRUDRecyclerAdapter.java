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

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Dosen> dosenList;


    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();

    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_dosen_cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Dosen m = dosenList.get(i);

        viewHolder.tvNamaDosen.setText(m.getNamaDosen());
        viewHolder.tvNidn.setText(m.getNidn());

        viewHolder.tvAlamatDosen.setText(m.getAlamat());
        viewHolder.tvEmailDosen.setText(m.getEmail());
        viewHolder.tvGelar.setText(m.getGelar());


//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaDosen,tvNidn,tvAlamatDosen,tvEmailDosen,tvGelar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaDosen = itemView.findViewById(R.id.tvNamaDosen);
            tvNidn = itemView.findViewById(R.id.tvNidn);
            tvAlamatDosen = itemView.findViewById(R.id.tvAlamatDosen);
            tvEmailDosen = itemView.findViewById(R.id.tvEmailDosen);
            tvGelar = itemView.findViewById(R.id.tvGelar);
//            tvNoTelp  = itemView.findViewById(R.id.tvNoTelp);

        }
    }
}
