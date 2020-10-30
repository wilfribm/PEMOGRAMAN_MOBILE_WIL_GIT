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

public class DosenRecyclerAdapterDebug extends RecyclerView.Adapter<DosenRecyclerAdapterDebug.ViewHolder> {

    private Context context;
    private List<Dosen> dosenList;


    public DosenRecyclerAdapterDebug(Context context) {
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
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_recycler_debug,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Dosen d = dosenList.get(i);

        viewHolder.tvNama.setText(d.getNamaDosen());
        viewHolder.tvNim.setText(d.getNidn());
//        viewHolder.tvNoTelp.setText(m.getNotelp());


    }


    @Override
    public int getItemCount() {
        return dosenList.size();
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
