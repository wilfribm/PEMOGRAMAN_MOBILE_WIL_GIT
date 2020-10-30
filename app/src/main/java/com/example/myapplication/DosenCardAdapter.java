package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DosenCardAdapter extends RecyclerView.Adapter<DosenCardAdapter.ViewHolder> {

    private Context context;
    private List<Dosen> dosenCard;


    public DosenCardAdapter(Context context) {
        this.context = context;
        dosenCard = new ArrayList<>();

    }

    public List<Dosen> getDosenCard() {
        return dosenCard;
    }

    public void setDosenCard(List<Dosen> dosenCard) {
        this.dosenCard = dosenCard;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_dosen_cardview,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Dosen d = dosenCard.get(i);

        viewHolder.tvNamaDosen.setText(d.getNamaDosen());
        viewHolder.tvNidn.setText(d.getNidn());
        viewHolder.tvAlamatDosen.setText(d.getAlamat());
        viewHolder.tvEmailDosen.setText(d.getEmail());
        viewHolder.tvGelar.setText(d.getEmail());
//        viewHolder.tvNoTelp.setText(m.getNotelp());





    }


    @Override
    public int getItemCount() {
        return dosenCard.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNamaDosen,tvNidn,tvAlamatDosen,tvEmailDosen, tvGelar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaDosen = itemView.findViewById(R.id.tvNamaDosen);
            tvNidn = itemView.findViewById(R.id.tvNidn);
            tvAlamatDosen  = itemView.findViewById(R.id.tvAlamatDosen);
            tvEmailDosen  = itemView.findViewById(R.id.tvEmailDosen);
            tvGelar  = itemView.findViewById(R.id.tvGelar);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),tvNamaDosen.getText(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
