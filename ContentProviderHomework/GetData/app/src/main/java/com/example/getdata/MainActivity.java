package com.example.getdata;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.text);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriExample = (new Uri.Builder())
                        .authority("com.example.contentprovider")
                        .scheme("content")
                        .build();
                Cursor cursor = getContentResolver().query(uriExample, null, null, null, null);
                cursor.moveToFirst();
                String name = "";
                do {
                    name = name + ", " + cursor.getString(cursor.getColumnIndex("name"));
                } while (cursor.moveToNext());
                textView.setText(name);
            }
        });

    }
}
