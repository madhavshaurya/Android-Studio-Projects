package com.example.iotstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText quantity1EditText;
    private EditText quantity2EditText;
    private EditText quantity3EditText;
    private Button submitButton;
    private Button clearButton;
    private TextView resultViewText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantity1EditText = findViewById(R.id.aurdinoquantity);
        quantity2EditText = findViewById(R.id.bluetoothquantity);
        quantity3EditText = findViewById(R.id.wifiquantity);
        resultViewText = findViewById(R.id.displayamount);

        submitButton = findViewById(R.id.submit);
        clearButton = findViewById(R.id.clear);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //read numbers
                String quantity1value  = quantity1EditText.getText().toString();
                String quantity2value = quantity2EditText.getText().toString();
                String quantity3value = quantity3EditText.getText().toString();

                //convert Strings to numbers
                double quantity1 = Double.parseDouble(quantity1value);
                double quantity2 = Double.parseDouble(quantity2value);
                double quantity3 = Double.parseDouble(quantity3value);


                //calc

                double calc1 = quantity1 * 500;
                double calc2 = quantity2 * 250;
                double calc3 = quantity3 * 200;

                double total = calc1+calc2+calc3;
                String result = String.valueOf(total);
                resultViewText.setText(result);

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }
}