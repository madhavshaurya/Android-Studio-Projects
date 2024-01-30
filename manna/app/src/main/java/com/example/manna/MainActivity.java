package com.example.manna;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.manna.R;

public class MainActivity extends AppCompatActivity {

    private EditText plainText;
    private EditText phoneText;
    private EditText dateText;
    private EditText numberText;
    private EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plainText = findViewById(R.id.plainText);
        phoneText = findViewById(R.id.phoneText);
        dateText = findViewById(R.id.dateText);
        numberText = findViewById(R.id.numberText);
        addressText = findViewById(R.id.addressText);
    }
}