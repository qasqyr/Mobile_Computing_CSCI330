package com.example.inclass_exercise_4_camera_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView imageView;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button camera_button = findViewById(R.id.camera_button);
        camera_button.setOnClickListener(this);
        imageView = findViewById(R.id.image);
    }

    @Override
    public void onClick(View v) {
        dispatchTakePictureIntent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Bitmap resBitmap = imageBitmap.copy(imageBitmap.getConfig(), true);

            for (int x = 0; x < imageBitmap.getWidth(); x++) {
                for (int y = 0; y < imageBitmap.getHeight(); y++) {
                    int p = imageBitmap.getPixel(x, y);
                    int R = (p >> 16) & 0xff;
                    int G = (p >> 8) & 0xff;
                    int B = p & 0xff;
                    Log.i("RGB: ", R + " " + G + " " + B + "\n");
                    int average = (R + G + B) / 3;
                    resBitmap.setPixel(x, y, Color.rgb(average, average, average));
                }
            }

            imageView.setImageBitmap(resBitmap);
        }
    }
}
