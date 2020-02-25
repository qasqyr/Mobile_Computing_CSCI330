package com.example.inclass_exercise_6_fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DrinkListFragment.DrinkListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void itemClicked(long id) {
        MyFragment f = new MyFragment();
        f.setID(id);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_position, f)
                .commit();
    }
}
