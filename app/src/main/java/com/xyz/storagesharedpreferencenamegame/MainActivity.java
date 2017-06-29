package com.xyz.storagesharedpreferencenamegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnSave;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= (EditText) findViewById(R.id.etName);
        btnSave= (Button) findViewById(R.id.btnSave);

        sp=getSharedPreferences("MySP1", MODE_PRIVATE);

        if(sp.getBoolean("ne", false) == false){

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name= etName.getText().toString();
                    SharedPreferences.Editor editor= sp.edit();
                    editor.putString("n", name);
                    editor.putBoolean("ne", true);
                    editor.commit();
                    Intent i=new Intent(getApplicationContext(), NameActivity.class);
                    startActivity(i);
                    finish();
                }
            });

        }

        else {
            Intent i= new Intent(getApplicationContext(), NameActivity.class);
            startActivity(i);
            finish();
        }
    }
}
