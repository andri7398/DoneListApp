package com.example.donelistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    // Database name
    private static final String DATABASE_NAME = "ACTIVITY_LIST";

    // table name
    private static final String TABLE_TALL = "ACTIVITY_TABLE";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "activity";


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "ActivityList", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE  IF NOT EXISTS ACTIVITY_TABLE (ID INT PRIMARY KEY AUTOINCREMENT, ACTIVITY VARCHAR)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(SQLiteDatabase sqLiteDatabase, String activity){
        SQLiteDatabase db = getWritableDatabase();

        String insert = "INSERT INTO ACTIVITY_TABLE (ACTIVITY) VALUES ("+ activity + ")";
        db.execSQL(insert);
    }

    public String getData(SQLiteDatabase sqLiteDatabase, int i){
        String data, query;
        query = "SELECT ACTIVITY FROM ACTIVITY_LIST WHERE id = "+i+"";
        SQLiteDatabase db = getWritableDatabase();

        Cursor result = db.rawQuery(query,null);
        String activity = result.getString(0);

        return activity;
    }

}
