package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3,b4;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        timePicker=findViewById(R.id.timePicker);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String

                        currentTime="Time:"+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
                ed1.setText(currentTime);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String

                        currentTime="Time:"+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
                ed2.setText(currentTime);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String

                        currentTime="Time:"+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
                ed3.setText(currentTime);
            }
        });
    }
}