package com.example.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontActivity extends AppCompatActivity {

    private Button masuk, daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        masuk = findViewById(R.id.masuk_button);
        daftar = findViewById(R.id.daftar_button);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMasukActivity();
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDaftarActivity();
            }
        });


    }

    public void openMasukActivity(){
        Intent intent = new Intent(this, MasukActivity.class);
        startActivity(intent);
    }

    public void openDaftarActivity(){
        Intent intent = new Intent(this, DaftarActivity.class);
        startActivity(intent);
    }
}
