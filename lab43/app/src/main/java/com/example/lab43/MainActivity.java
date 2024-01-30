package com.example.lab43;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNumberInput;
    private EditText secondNumberInput;
    private TextView sumText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberInput = findViewById(R.id.firstNumberInput);
        secondNumberInput = findViewById(R.id.secondNumberInput);
        sumText = findViewById(R.id.sumText);
    }
    public void calculateSum(View view) {
        String firstNumberStr = firstNumberInput.getText().toString();
        String secondNumberStr = secondNumberInput.getText().toString();

        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {
            int firstNumber = Integer.parseInt(firstNumberStr);
            int secondNumber = Integer.parseInt(secondNumberStr);
            int sum = firstNumber + secondNumber;
            sumText.setText("Sum: " + sum);
        } else {
            sumText.setText("Please enter valid numbers.");
        }
    }
}