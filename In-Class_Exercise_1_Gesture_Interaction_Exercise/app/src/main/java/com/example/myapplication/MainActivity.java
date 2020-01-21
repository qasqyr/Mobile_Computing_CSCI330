package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, View.OnTouchListener {

    private ImageView imageView;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        gestureDetector = new GestureDetectorCompat(this, this);

        imageView.setOnTouchListener(MainActivity.this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.v("SCROLL: \n", "X: " + distanceX + "\nY: " + distanceY);
        if (distanceX < -20) {
            imageView.setColorFilter(Color.argb(128, 255, 0, 0));
        } else if (distanceX > 20) {
            imageView.setColorFilter(Color.argb(128, 0, 255, 0));
        } else if (distanceY < -20) {
            imageView.setColorFilter(Color.argb(128, 0, 0, 255));
        } else if (distanceY > 20) {
            imageView.setColorFilter(Color.argb(128, 255, 255, 255));
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        imageView.setColorFilter(Color.argb(0, 0, 0, 0));
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        imageView.setColorFilter(Color.argb(0, 0, 0, 0));
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        Log.v("TOUCH: ", "YOU TOUCHED");
        return true;
    }
}
