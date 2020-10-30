package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulGetAllActivity extends AppCompatActivity {

    RecyclerView rvMatkul;
    MatkulCRUDRecyclerAdapter matkulAdapter;
    ProgressDialog pd;
    List<Matkul> matkulList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_get_all);

        rvMatkul = (RecyclerView)findViewById(R.id.rvGetMatkulAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matkul>> call = service.getMatkul("72180230");

        call.enqueue(new Callback<List<Matkul>>() {
            @Override
            public void onResponse(Call<List<Matkul>> call, Response<List<Matkul>> response) {
                pd.dismiss();
                matkulList = response.body();
                matkulAdapter = new MatkulCRUDRecyclerAdapter(matkulList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetAllActivity.this);
                rvMatkul.setLayoutManager(layoutManager);
                rvMatkul.setAdapter(matkulAdapter);

            }

            @Override
            public void onFailure(Call<List<Matkul>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatkulGetAllActivity.this, "Error",Toast.LENGTH_LONG);

            }
        });

    }
}