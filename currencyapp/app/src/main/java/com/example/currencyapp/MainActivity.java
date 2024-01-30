package com.example.currencyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inrEditText;
    private RadioGroup currencyRadioGroup;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inrEditText = findViewById(R.id.inrEditText);
        currencyRadioGroup = findViewById(R.id.currencyRadioGroup);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String inrText = inrEditText.getText().toString().trim();
        if (inrText.isEmpty()) {
            resultTextView.setText("Please enter INR amount");
            return;
        }

        double inrAmount = Double.parseDouble(inrText);
        double convertedAmount = 0.0;

        int selectedRadioButtonId = currencyRadioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId == R.id.usdRadioButton) {
            convertedAmount = inrAmount / 75; // Conversion rate from INR to USD
        } else if (selectedRadioButtonId == R.id.euroRadioButton) {
            convertedAmount = inrAmount / 88; // Conversion rate from INR to Euro
        } else if (selectedRadioButtonId == R.id.yenRadioButton) {
            convertedAmount = inrAmount / 0.69; // Conversion rate from INR to Yen
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String result = decimalFormat.format(convertedAmount);
        resultTextView.setText("Converted amount: " + result);
    }

}
