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

public class DosenUpdateActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);

        final EditText editTextNidnCari = (EditText)findViewById(R.id.editTextNidnCari);
        final EditText EditTextNama2Dosen = (EditText)findViewById(R.id.EditTextNama2Dosen);
        final EditText EditTextNidn2 = (EditText)findViewById(R.id.EditTextNidn2);
        final EditText EditTextAlamat2Dosen = (EditText)findViewById(R.id.EditTextAlamat2Dosen);
        final EditText EditTextEmail2Dosen = (EditText)findViewById(R.id.EditTextEmail2Dosen);
        final EditText EditTextGelarDosen = (EditText)findViewById(R.id.EditTextGelarDosen);
        Button buttonUbahDosen = (Button) findViewById(R.id.buttonUbahDosen);



        pd = new ProgressDialog(DosenUpdateActivity.this);

        buttonUbahDosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> delcall = service.delete_dsn(
                        editTextNidnCari.getText().toString()
                        ,"721802030"




                );

                delcall.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });

                Call<DefaultResult> addcall= service.update_dsn(
                        editTextNidnCari.getText().toString(),
                        EditTextNama2Dosen.getText().toString(),
                        EditTextNidn2.getText().toString(),
                        EditTextAlamat2Dosen.getText().toString(),
                        EditTextEmail2Dosen.getText().toString(),
                        EditTextGelarDosen.getText().toString(),
                        "kosongkan saja",
                        "72180230"




                );
                addcall.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Berhasil disimpan",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


    }
}