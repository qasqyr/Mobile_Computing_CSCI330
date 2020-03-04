package com.example.contentprovider;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper dbHelper = new ExampleDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL(" DELETE FROM CITIESKZ");
        db.execSQL(" INSERT INTO CITIESKZ ( NAME , KZREGION )"
                + " VALUES (\' Petropavalsk \', \' North \');");
        db.execSQL(" INSERT INTO CITIESKZ ( NAME , KZREGION )"
                + " VALUES (\' Almaty \', \' South \');");

        final EditText editText = findViewById(R.id.text);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Log.v("KOTAK: ", name);
                db.execSQL(" INSERT INTO CITIESKZ ( NAME , KZREGION )"
                        + " VALUES ( \'" + name + "\', \' UNKNOWN \');");

                Toast.makeText(getApplicationContext(), "City Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
