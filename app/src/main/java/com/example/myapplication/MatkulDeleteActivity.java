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

public class MatkulDeleteActivity extends AppCompatActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_delete);

        EditText editTextKodeMatkulCari = (EditText)findViewById(R.id.editTextKodeMatkulCari);
        Button buttonDeleteMatkul = (Button)findViewById(R.id.buttonDeleteMatkul);

        pd = new ProgressDialog(MatkulDeleteActivity.this);

        buttonDeleteMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Tunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_matkul(
                        editTextKodeMatkulCari.getText().toString(),
                        "72180230"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulDeleteActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulDeleteActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


    }
}