package com.example.lab42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameInput;
    private EditText lastNameInput;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        displayText = findViewById(R.id.displayText);
    }
    public void displayFullName(View view) {
        String firstName = firstNameInput.getText().toString();
        String lastName = lastNameInput.getText().toString();
        String fullName = firstName + " " + lastName;
        displayText.setText("Your Full Name is " + fullName);
    }
}