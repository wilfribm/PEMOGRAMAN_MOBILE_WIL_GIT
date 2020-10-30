package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatkulAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_add);

        EditText editTextNamaMatkul = (EditText)findViewById(R.id.editTextNamaMatkul);
        EditText editTextKodeMatkul = (EditText)findViewById(R.id.editTextKodeMatkul);
        EditText editTextHari = (EditText)findViewById(R.id.editTextHari);
        EditText editTextSesi = (EditText)findViewById(R.id.editTextSesi);
        EditText editTextSks = (EditText)findViewById(R.id.editTextSks);
        Button buttonSimpanMatkul = (Button)findViewById(R.id.buttonSimpanMatkul);

        pd = new ProgressDialog(MatkulAddActivity.this);

        buttonSimpanMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_matkul(
                        editTextNamaMatkul.getText().toString(),
                        editTextKodeMatkul.getText().toString(),
                        editTextHari.getText().toString(),
                        editTextSesi.getText().toString(),
                        editTextSks.getText().toString(),
                        "72180230"




                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "Data Berhasil disimpan", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "GAGAL", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}