package com.example.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity {

    private Button daftar;
    private EditText nama,email,password;
    private static String value;
    public static String getValue() {
        return value;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        daftar = findViewById(R.id.daftar_button2);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        nama = findViewById(R.id.nama);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validate = email.getText().toString().trim();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(nama.length() == 0 || email.length() == 0 || password.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else if(!validate.matches(emailPattern) || email.length() < 0){
                    Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_SHORT).show();
                }

                else{


                    //User registeredData = new User(inputName, inputEmail, inputPassword);
                    openMain();

                }

            }
        });
    }

    public void openMain(){
        String inputName = nama.getText().toString();
        String inputEmail = email.getText().toString();
        String inputPassword = password.getText().toString();

        value = nama.getText().toString().trim();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
