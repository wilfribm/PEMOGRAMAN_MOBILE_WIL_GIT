package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaRecyclerAdapter extends RecyclerView.Adapter<MahasiswaRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Mahasiswa> mahasiswaList;


    public MahasiswaRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_recycler,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Mahasiswa m = mahasiswaList.get(i);

        viewHolder.tvNama.setText(m.getNama());
        viewHolder.tvNim.setText(m.getNim());
//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama,tvNim,tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNoTelp  = itemView.findViewById(R.id.tvNoTelp);

        }
    }
}
