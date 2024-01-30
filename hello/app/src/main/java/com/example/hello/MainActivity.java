package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast =findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
               Toast.makeText(MainActivity.this, "Demo Toast Message", Toast.LENGTH_SHORT).show();
           }
        });
    }
}