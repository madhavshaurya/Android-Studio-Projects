package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton add_btn, toast1, toast2, toast3;
    Animation fabOpen, fabClose, rotateOpen, rotateClose;
    Boolean isOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.add_fab);
        toast1 = findViewById(R.id.toast1);
        toast2 = findViewById(R.id.toast2);
        toast3 = findViewById(R.id.toast3);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.close);
        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.open);
        rotateClose = AnimationUtils.loadAnimation(this, R.anim.close);

        isOpen = false;
        toast1.setVisibility(View.GONE);
        toast2.setVisibility(View.GONE);
        toast3.setVisibility(View.GONE);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        toast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 2", Toast.LENGTH_SHORT).show();
            }
        });

        toast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 1", Toast.LENGTH_SHORT).show();
            }
        });

        toast3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button 3", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void animateFab() {
        if (!isOpen) {
            add_btn.startAnimation(rotateOpen);
            toast1.setClickable(true);
            toast2.setClickable(true);
            toast3.setClickable(true);
            toast1.show();
            toast2.show();
            toast3.show();
            isOpen = true;
        } else {
            add_btn.startAnimation(rotateClose);
            toast1.setClickable(false);
            toast2.setClickable(false);
            toast3.setClickable(false);
            toast1.hide();
            toast2.hide();
            toast3.hide();
            isOpen = false;
        }
    }
}