package com.example.hw2_cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    private int addOneScore = 0;
    private int addTwoScore = 0;
    private int addFiveScore = 0;
    private int addTenScore = 0;

    private Button addOne;
    private Button addOnePerSec;
    private Button addTwoPerSec;
    private Button addFivePerSec;
    private Button addTenPerSec;
    private TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreView = findViewById(R.id.score);

        addOne = findViewById(R.id.button_add_one);
        addOnePerSec = findViewById(R.id.button_add_one_per_sec);
        addTwoPerSec = findViewById(R.id.button_add_two_per_sec);
        addFivePerSec = findViewById(R.id.button_add_five_per_sec);
        addTenPerSec = findViewById(R.id.button_add_ten_per_sec);

        Thread thread_add_one = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    score += addOneScore;
                    score += addTwoScore;
                    score += addFiveScore;
                    score += addTenScore;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            scoreView.setText(String.valueOf(score));
                        }
                    });
                }
            }
        });

        thread_add_one.start();

        addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                scoreView.setText(new Integer(score).toString());
            }
        });

        addOnePerSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score >= 10) {
                    addOneScore++;
                    score -= 10;
                } else {
                    Toast.makeText(MainActivity.this , "NOT ENOUGH MONEY!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        addTwoPerSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score >= 20) {
                    addTwoScore += 2;
                    score -= 20;
                } else {
                    Toast.makeText(MainActivity.this , "NOT ENOUGH MONEY!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        addFivePerSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score >= 50) {
                    addFiveScore += 5;
                    score -= 50;
                } else {
                    Toast.makeText(MainActivity.this , "NOT ENOUGH MONEY!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        addTenPerSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score >= 100) {
                    addTenScore += 10;
                    score -= 100;
                } else {
                    Toast.makeText(MainActivity.this , "NOT ENOUGH MONEY!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
