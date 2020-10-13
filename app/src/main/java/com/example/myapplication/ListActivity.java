package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    String[] items={"lorem", "ipsum", "dolor", "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi",
            "vel","ligula", "vitae", "arcu", "aliquet",
            "mollis","etiam", "vel","erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lv = (ListView)findViewById(R.id.lvLatihan);
        Spinner sp = (Spinner)findViewById(R.id.spinnerLatihan);

        lv.setAdapter(new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_list_item_1,items));
       ArrayAdapter<String> aa = new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_spinner_item,items);
      sp.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"Anda Memilih" + items[position],
                        Toast.LENGTH_LONG).show();
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"Anda Memilih : " + items[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ListActivity.this,"Anda Memilih : " ,Toast.LENGTH_LONG).show();
            }
        });

    }
}