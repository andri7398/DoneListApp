package com.example.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DoneActivity extends AppCompatActivity {
    private EditText activity;
    private Button tambah;
    private TextView home;

    private static String value;
    public static String getValue() {
        return value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        activity = findViewById(R.id.text_activity);
        tambah = findViewById(R.id.add_activity_button);
        home = findViewById(R.id.head_text);
        home.setText("WHAT ARE YOU GONNA DO " + DaftarActivity.getValue() + "?");

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addActivity();
            }
        });
    }

    public void addActivity(){
        value = activity.getText().toString().trim();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
