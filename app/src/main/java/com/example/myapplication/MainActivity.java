package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Catatan Jika ingin menjalankan layout silakan off kan variable dan action dibawah
        // Serta ganti nama layout yang ingin di run (diatas)
       //variable
        final TextView txtView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText = (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById(R.id.btnHelp);
        Button btnTracker = (Button)findViewById(R.id.btnTracker);

       //action
        txtView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Log.d("Cobaa Klikkkkkkkk",myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HelpActivity.class);
                Bundle b = new Bundle();
                b.putString("help_string",myEditText.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kemainactivity = new Intent(MainActivity.this,TrackerActivity.class);
                startActivity(kemainactivity);
            }
        });

        //List View
        Button btnList = (Button)findViewById(R.id.buttonListView);
        Button btnRecycler = (Button)findViewById(R.id.buttonRecyclerView);
        Button btnCard = (Button)findViewById(R.id.buttonCardView);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);

            }
        });

        //Recycler View
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecyclerActivity.class);
                startActivity(intent);
            }
        });

        //Card view
        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CardActivity.class);
                startActivity(intent);
            }
        });




    }
}