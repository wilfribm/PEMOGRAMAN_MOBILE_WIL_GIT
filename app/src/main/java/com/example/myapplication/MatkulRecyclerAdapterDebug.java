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

public class MatkulRecyclerAdapterDebug extends RecyclerView.Adapter<MatkulRecyclerAdapterDebug.ViewHolder> {

    private Context context;
    private List<Matkul> matkulList;


    public MatkulRecyclerAdapterDebug(Context context) {
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
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_recycler_debug,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Matkul mk = matkulList.get(i);

        viewHolder.tvNama.setText(mk.getNamaMatkul());
        viewHolder.tvNim.setText(mk.getKodeMatkul());
//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return matkulList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama,tvNim,tvNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
//            tvNoTelp  = itemView.findViewById(R.id.tvNoTelp);

        }
    }
}
