package com.example.hello5;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText plainText;
    private EditText password;
    private EditText numericPassword;
    private EditText email;
    private EditText phone;
    private EditText date;
    private EditText multilineText;
    private EditText time;
    private EditText signedNumber;
    private EditText decimalNumber;
    private EditText autoComplete;
    private EditText multiAutoComplete;
    private TextView checkedText;
    private EditText postalAddress;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plainText = findViewById(R.id.plainText);
        password = findViewById(R.id.password);
        numericPassword = findViewById(R.id.numericPassword);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        date = findViewById(R.id.date);
        multilineText = findViewById(R.id.multilineText);
        time = findViewById(R.id.time);
        signedNumber = findViewById(R.id.signedNumber);
        decimalNumber = findViewById(R.id.decimalNumber);
        autoComplete = findViewById(R.id.autoComplete);
        multiAutoComplete = findViewById(R.id.multiAutoComplete);
        checkedText = findViewById(R.id.checkedText);
        postalAddress = findViewById(R.id.postalAddress);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the entered values
                String plainTextValue = plainText.getText().toString();
                String passwordValue = password.getText().toString();
                String numericPasswordValue = numericPassword.getText().toString();
                String emailValue = email.getText().toString();
                String phoneValue = phone.getText().toString();
                String dateValue = date.getText().toString();
                String multilineTextValue = multilineText.getText().toString();
                String timeValue = time.getText().toString();
                String signedNumberValue = signedNumber.getText().toString();
                String decimalNumberValue = decimalNumber.getText().toString();
                String autoCompleteValue = autoComplete.getText().toString();
                String multiAutoCompleteValue = multiAutoComplete.getText().toString();
                boolean isChecked = checkedText.createAccessibilityNodeInfo().isChecked();
                String postalAddressValue = postalAddress.getText().toString();

                // Display the entered values
                String result = "Plain Text: " + plainTextValue +
                        "\nPassword: " + passwordValue +
                        "\nNumeric Password: " + numericPasswordValue +
                        "\nEmail: " + emailValue +
                        "\nPhone: " + phoneValue +
                        "\nDate: " + dateValue +
                        "\nMultiline Text: " + multilineTextValue +
                        "\nTime: " + timeValue +
                        "\nSigned Number: " + signedNumberValue +
                        "\nDecimal Number: " + decimalNumberValue +
                        "\nAutoComplete: " + autoCompleteValue +
                        "\nMultiAutoComplete: " + multiAutoCompleteValue +
                        "\nChecked Text: " + isChecked +
                        "\nPostal Address: " + postalAddressValue;

                TextView resultTextView = findViewById(R.id.resultTextView);
                resultTextView.setText(result);
            }
        });
    }
}