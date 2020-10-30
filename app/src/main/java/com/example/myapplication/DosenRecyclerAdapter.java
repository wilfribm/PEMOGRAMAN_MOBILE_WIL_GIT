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

public class DosenRecyclerAdapter extends RecyclerView.Adapter<DosenRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Dosen> dosenList;


    public DosenRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_dosen_recycler,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Dosen d = dosenList.get(i);

        viewHolder.tvNamaDosen.setText(d.getNamaDosen());
        viewHolder.tvNidn.setText(d.getNidn());
        viewHolder.tvAlamatDosen.setText(d.getAlamat());
        viewHolder.tvEmailDosen.setText(d.getEmail());
//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaDosen,tvNidn,tvAlamatDosen,tvEmailDosen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaDosen = itemView.findViewById(R.id.tvNamaDosen);
            tvNidn = itemView.findViewById(R.id.tvNidn);
            tvAlamatDosen  = itemView.findViewById(R.id.tvAlamatDosen);
            tvEmailDosen  = itemView.findViewById(R.id.tvEmailDosen);

        }
    }
}
