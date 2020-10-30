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
import retrofit2.http.Field;

public class MatkulUpdateActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_update);

        final EditText editTextKodeMatkulCari = (EditText)findViewById(R.id.editTextKodeMatkulCari);
        final EditText EditTextNama2Matkul = (EditText)findViewById(R.id.EditTextNama2Matkul);
        final EditText EditTextKode2Matkul = (EditText)findViewById(R.id.EditTextKode2Matkul);
        final EditText editTextHari = (EditText)findViewById(R.id.editTextHari);
        final EditText editTextSesi = (EditText)findViewById(R.id.editTextSesi);
        final EditText editTextSks = (EditText)findViewById(R.id.editTextSks);
        Button buttonUbahMatkul = (Button) findViewById(R.id.buttonUbahMatkul);



        pd = new ProgressDialog(MatkulUpdateActivity.this);

        buttonUbahMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> delcall = service.delete_matkul(
                        EditTextKode2Matkul.getText().toString()
                        , "72180230"


                );

                delcall.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this, "Data Berhasil Diubah", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });

                Call<DefaultResult> updatecall= service.update_matkul(
                        editTextKodeMatkulCari.getText().toString(),
                        EditTextNama2Matkul.getText().toString(),
                        EditTextKode2Matkul.getText().toString(),
                        editTextHari.getText().toString(),
                        editTextSesi.getText().toString(),
                        editTextSks.getText().toString(),
                        "72180230"


                );
                updatecall.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Berhasil disimpan",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


    }
}