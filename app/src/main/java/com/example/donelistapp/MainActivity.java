package com.example.donelistapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button logout, add;
    private TextView hello, done;
    private EditText nama, email, password;
    UserLocalStore userLocalStore;
    DBHelper helper = new DBHelper(this,null,null,1);


    private static String list = "";
    public static String getlist() {
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        nama = findViewById(R.id.nama);
        add = findViewById(R.id.add_button);

        //logout = findViewById(R.id.logout_button);
        hello = findViewById(R.id.hello_text);
        done = findViewById(R.id.done_text);

        list = done.getText().toString().trim();

        hello.setText("Hello " + DaftarActivity.getValue());

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAddActivity();
            }
        });

        SQLiteDatabase db = openOrCreateDatabase("ACTIVTITY_LIST",MODE_PRIVATE,null);
        Cursor result = db.rawQuery("SELECT ACTIVITY FROM ACTIVITY_LIST ORDER BY ASCENDING", null);

        String activities = "";

        for(int i = 0; i<result.getCount(); i++){
            activities = activities+ result.getString(i)+"\n";
        }

        done.setText(activities);


//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                userLogout();
//            }
//        });

       // userLocalStore = new UserLocalStore(this);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if(authenticate() == true){
//            User user = userLocalStore.getLoggedInUser();
//            hello.setText(user.name);
//        }
//    }

    public void gotoAddActivity(){
        Intent intent = new Intent(this, DoneActivity.class);
        startActivity(intent);
    }

    private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    }

    public void userLogout(){
        userLocalStore.clearUserData();
        userLocalStore.setUserLoggedIn(false);

        startActivity(new Intent(this, MasukActivity.class));

    }


}


