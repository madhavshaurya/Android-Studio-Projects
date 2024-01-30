package com.example.lab44;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText firstNumberInput;
    private EditText secondNumberInput;
    private RadioGroup operationGroup;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumberInput = findViewById(R.id.firstNumberInput);
        secondNumberInput = findViewById(R.id.secondNumberInput);
        operationGroup = findViewById(R.id.operationGroup);
        resultText = findViewById(R.id.resultText);
    }
    public void performCalculation(View view) {
        String firstNumberStr = firstNumberInput.getText().toString();
        String secondNumberStr = secondNumberInput.getText().toString();

        if (!firstNumberStr.isEmpty() && !secondNumberStr.isEmpty()) {
            int firstNumber = Integer.parseInt(firstNumberStr);
            int secondNumber = Integer.parseInt(secondNumberStr);

            int selectedId = operationGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);

            if (selectedRadioButton != null) {
                String operation = selectedRadioButton.getText().toString();
                int result = 0;

                switch (operation) {
                    case "Addition":
                        result = firstNumber + secondNumber;
                        break;
                    case "Subtraction":
                        result = firstNumber - secondNumber;
                        break;
                    case "Multiplication":
                        result = firstNumber * secondNumber;
                        break;
                    case "Division":
                        if (secondNumber != 0) {
                            result = firstNumber / secondNumber;
                        } else {
                            resultText.setText("Error: Division by zero");
                            return;
                        }
                        break;
                }

                resultText.setText("Result: " + result);
            }
        } else {
            resultText.setText("Please enter valid numbers.");
        }
    }
}