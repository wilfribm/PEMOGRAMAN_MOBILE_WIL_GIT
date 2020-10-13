package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //variable
        TextView txtHelp = (TextView)findViewById(R.id.textViewHelp);

        Bundle b = getIntent().getExtras();
        String textHelp = b.getString("help_string");
        txtHelp.setText(textHelp);

    }
}