package com.example.hello4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read the entered numbers
                String number1String = number1EditText.getText().toString();
                String number2String = number2EditText.getText().toString();

                // Convert the strings to numbers
                double number1 = Double.parseDouble(number1String);
                double number2 = Double.parseDouble(number2String);

                // Perform calculations
                double addition = number1 + number2;
                double subtraction = number1 - number2;
                double multiplication = number1 * number2;
                double division = number1 / number2;


                // Display the results
                String result = "Addition: " + addition +
                        "\nSubtraction: " + subtraction +
                        "\nMultiplication: " + multiplication +
                        "\nDivision: " + division;
                resultTextView.setText(result);
            }
        });
    }
}