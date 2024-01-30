package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        displayText = findViewById(R.id.displayText);
    }
    public void displayMessage(View view) {
        String name = nameInput.getText().toString();
        String message = "Your Name is " + name;
        displayText.setText(message);
    }
}