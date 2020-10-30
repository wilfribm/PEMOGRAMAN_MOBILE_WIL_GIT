package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginActivity extends AppCompatActivity {

    ProgressDialog pd;
    List<User> users;
    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        Toast.makeText(LoginActivity.this, "Ini Login", Toast.LENGTH_SHORT).show();
        session = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        if(!session.getString("nimnik", "").isEmpty() && !session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(LoginActivity.this, HalamanUtamaActivity.class));
            return;
        }

        EditText nimnik = (EditText) findViewById(R.id.edNim);
        EditText password = (EditText) findViewById(R.id.edPass);
        Button btnSimpan = (Button)findViewById(R.id.btnLogin);
        pd = new ProgressDialog(LoginActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<List<User>> call = service.login(
                        nimnik.getText().toString(),
                        password.getText().toString()
                );

                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        pd.dismiss();
                        users = response.body();
                        assert users != null;
                        User u = users.get(0);
                        SharedPreferences.Editor editor = session.edit();
                        editor.clear();
                        editor.putString("nimnik", u.getNimnik());
                        editor.putString("nama", u.getNama());
                        editor.apply();
                        finish();
                        Intent intent = new Intent(LoginActivity.this, HalamanUtamaActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}