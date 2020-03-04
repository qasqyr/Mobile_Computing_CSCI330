package com.example.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExampleDatabaseHelper extends SQLiteOpenHelper {

    private static final String EX_DB = "my-db";
    private static final int DBVER = 1;

    ExampleDatabaseHelper(Context context) {
        super(context, EX_DB, null, DBVER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE CITIESKZ ("
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + " NAME TEXT , "
                + " KZREGION Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
