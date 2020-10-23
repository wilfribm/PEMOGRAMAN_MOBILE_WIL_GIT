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

public class MahasiswaUpdateActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);

        EditText editTextNimCari = (EditText)findViewById(R.id.editTextNimCari);
        EditText EditTextNama2 = (EditText)findViewById(R.id.EditTextNama2);
        EditText EditTextNim2 = (EditText)findViewById(R.id.EditTextNim2);
        EditText EditTextAlamat2 = (EditText)findViewById(R.id.EditTextAlamat2);
        EditText EditTextEmail2 = (EditText)findViewById(R.id.EditTextEmail2);
        Button buttonUbah = (Button) findViewById(R.id.buttonUbah);



        pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        buttonUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        editTextNimCari.getText().toString(),
                        EditTextNama2.getText().toString(),
                        EditTextNim2.getText().toString(),
                        EditTextAlamat2.getText().toString(),
                        EditTextEmail2.getText().toString()
                        , "72180230"


                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


    }
}