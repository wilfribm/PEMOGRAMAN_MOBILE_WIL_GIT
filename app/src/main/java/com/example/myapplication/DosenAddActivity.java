package com.example.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class DosenAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);

        EditText editTextNamaDosen = (EditText)findViewById(R.id.editTextNamaDosen);
        EditText editTextNidnCari = (EditText)findViewById(R.id.editTextNidnCari);
        EditText editTextAlamatDosen = (EditText)findViewById(R.id.editTextAlamatDosen);
        EditText editTextEmailDosen = (EditText)findViewById(R.id.editTextEmailDosen);
        EditText editTextGelar = (EditText)findViewById(R.id.editTextGelar);
        Button buttonSimpanDosen = (Button)findViewById(R.id.buttonSimpanDosen);

        pd = new ProgressDialog(DosenAddActivity.this);

        buttonSimpanDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dsn(
                        editTextNamaDosen.getText().toString(),
                        editTextNidnCari.getText().toString(),
                        editTextAlamatDosen.getText().toString(),
                        editTextEmailDosen.getText().toString(),
                        editTextGelar.getText().toString(),
                        "Kosongkan saja ",
                        "72180230"





                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "Data Berhasil disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this, "GAGAL", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}