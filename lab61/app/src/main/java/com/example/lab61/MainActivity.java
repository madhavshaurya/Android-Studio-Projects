package com.example.lab61;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zoomImg2(View view) {
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        ImageView image2 = (ImageView) findViewById(R.id.image2);
        Animation zoom =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        Animation zoom_out =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        image2.startAnimation(zoom);
        image1.startAnimation(zoom_out);
    }

    public void zoomImg1(View view) {
        ImageView image1 = (ImageView) findViewById(R.id.image1);
        ImageView image2 = (ImageView) findViewById(R.id.image2);
        Animation zoom =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        Animation zoom_out =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        image1.startAnimation(zoom);
        image2.startAnimation(zoom_out);
    }
}
