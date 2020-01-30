package com.example.inclass_exercise_3_leveller_task;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            String s = String.format(" x: %f y : % f z : % f \n ", x, y, z);
            Log.e("SENSORACTIVITY", s);


//            ImageView imageView = new ImageView(MainActivity.this);
//            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.parent);
//            imageView.setImageResource(R.drawable.dot);
//            imageView.setAdjustViewBounds(true);
//            imageView.setMaxHeight(100);
//            imageView.setMaxWidth(100);
//            imageView.setY(-1);
//            imageView.setX(-1);
//            relativeLayout.addView(imageView);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

            if ((int)event.values[0] > 3) {
//                imageView.setX(x);
//                imageView.setY(y);
                params.rightMargin = 500;
                params.topMargin = 0;
                imageView.setAdjustViewBounds(true);
                imageView.setMaxHeight(100);
                imageView.setMaxWidth(100);
                imageView.setLayoutParams(params);
            } else if ((int)event.values[0] < -3) {
                params.leftMargin = 500;
                params.topMargin = 0;
                imageView.setAdjustViewBounds(true);
                imageView.setMaxHeight(100);
                imageView.setMaxWidth(100);
                imageView.setLayoutParams(params);
            } else if ((int)event.values[1] > 3) {
                params.leftMargin = 250;
                params.topMargin = 500;
                imageView.setAdjustViewBounds(true);
                imageView.setMaxHeight(100);
                imageView.setMaxWidth(100);
                imageView.setLayoutParams(params);
            } else if ((int)event.values[1] < -3) {
                params.leftMargin = 250;
                params.bottomMargin = 500;
                imageView.setAdjustViewBounds(true);
                imageView.setMaxHeight(100);
                imageView.setMaxWidth(100);
                imageView.setLayoutParams(params);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        for (Sensor s : sensorManager.getSensorList(Sensor.TYPE_ALL)) {
            Log.v("List Sensors", s.getName());
        }

        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_UI);
        imageView = findViewById(R.id.image_view);
    }
}
