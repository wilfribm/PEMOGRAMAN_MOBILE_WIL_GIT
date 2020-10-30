package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrefActivity extends AppCompatActivity {
    String isLogin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        Button btnLogin = findViewById(R.id.btnLogin);

        SharedPreferences pref = PrefActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //Membaca pref isLogin apakah true of false
        isLogin = pref.getString("isLogin","0");

        if(isLogin.equals("1")){
            btnLogin.setText("Logout");
        }else{
            btnLogin.setText("Login");
        }

        //Pengisian pref
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin = pref.getString("isLogin","0");
                if(isLogin.equals("0")){
                    editor.putString("isLogin","1");
                    btnLogin.setText("Logout");
                }else{
                    editor.putString("isLogin","1");
                    btnLogin.setText("Login");
                }
                editor.commit();
            }
        });
    }
}