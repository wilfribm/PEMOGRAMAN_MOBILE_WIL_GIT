package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {
//    private int waktu_loading=4000;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pref);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //setelah loading maka akan langsung berpindah ke home activity
//                //Intent home=new Intent(SplashActivity.this, LoginActivity.class);
////                startActivity(home);
//                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//                finish();
//
//
//
//
//            }
//        },waktu_loading);
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    //menghilangkan ActionBar
//    setContentView(R.layout.activity_splash);
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
    }, 3000L); //3000 L = 3 detik

}
}