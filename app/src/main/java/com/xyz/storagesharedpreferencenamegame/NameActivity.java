package com.xyz.storagesharedpreferencenamegame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    TextView tvName;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        tvName= (TextView) findViewById(R.id.tvName);
        sp=getSharedPreferences("MySP1", MODE_PRIVATE);
        String name= sp.getString("n", " ");
        tvName.setText("Welcome " + name);
    }
}
