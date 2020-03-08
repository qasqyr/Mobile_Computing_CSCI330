package com.example.androidtestingtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {



    private EditText firstName;
    private EditText lastName;
    private Button button;
    private String fname;
    private String lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        button = findViewById(R.id.submit_button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
            fname = firstName.getText().toString();
            lname = lastName.getText().toString();
            intent.putExtra("fname", fname);
            intent.putExtra("lname", lname);
            MainActivity.this.startActivity(intent);
        });
    }

}
