package com.example.androidtestingtask;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubmitActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_activity);

        Intent intent = getIntent();
        firstName = findViewById(R.id.name);
        lastName = findViewById(R.id.surname);

        firstName.setText(intent.getStringExtra("fname"));
        lastName.setText(intent.getStringExtra("lname"));
    }
}
