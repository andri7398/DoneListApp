package com.example.donelistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MasukActivity extends AppCompatActivity {
    private EditText email, password;
    private Button login;
    UserLocalStore userLocalStore;

    private static String value;
    public static String getValue() {
        return value;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        //userLocalStore = new UserLocalStore(this);
    }

    public void login(){
//        User user = new User(null, null);
//        userLocalStore.storeUserData(user);
//        userLocalStore.setUserLoggedIn(true);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
