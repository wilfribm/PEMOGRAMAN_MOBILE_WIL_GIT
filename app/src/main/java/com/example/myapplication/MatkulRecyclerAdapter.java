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

public class MatkulRecyclerAdapter extends RecyclerView.Adapter<MatkulRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Matkul> matkulList;


    public MatkulRecyclerAdapter(Context context) {
        this.context = context;
        matkulList = new ArrayList<>();

    }

    public List<Matkul> getMatkulList() {
        return matkulList;
    }

    public void setMatkulList(List<Matkul> matkulList) {
        this.matkulList = matkulList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_matkul_recycler,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Matkul mk = matkulList.get(i);

        viewHolder.tvNamaMatkul.setText(mk.getNamaMatkul());
        viewHolder.tvKodeMatkul.setText(mk.getKodeMatkul());

        viewHolder.tvHari.setText(mk.getSesi());
        viewHolder.tvSesi.setText(mk.getSks());
        viewHolder.tvSks.setText(mk.getSks());


//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return matkulList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaMatkul,tvKodeMatkul,tvHari,tvSesi,tvSks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaMatkul = itemView.findViewById(R.id.tvNamaMatkul);
            tvKodeMatkul = itemView.findViewById(R.id.tvKodeMatkul);
            tvHari  = itemView.findViewById(R.id.tvHari);
            tvSesi  = itemView.findViewById(R.id.tvSesi);
            tvSks  = itemView.findViewById(R.id.tvSks);

        }
    }
}
