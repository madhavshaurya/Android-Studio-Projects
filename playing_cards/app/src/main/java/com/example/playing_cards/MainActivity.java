package com.example.playing_cards;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText num1, num2, num3, num4, num5, sum;
    Button b1, b2;
    int displaySum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.n1);
        num2 = findViewById(R.id.n2);
        num3 = findViewById(R.id.n3);
        num4 = findViewById(R.id.n4);
        num5 = findViewById(R.id.n5);
        sum = findViewById(R.id.sum);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        final int
                arr[] = new int[5];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                arr[0] = rand.nextInt(13);
                num1.setText(String.valueOf(arr[0]));
                arr[1] = rand.nextInt(13);
                num2.setText(String.valueOf(arr[1]));
                arr[2] = rand.nextInt(13);
                num3.setText(String.valueOf(arr[2]));
                arr[3] = rand.nextInt(13);
                num4.setText(String.valueOf(arr[3]));
                arr[4] = rand.nextInt(13);
                num5.setText(String.valueOf(arr[4]));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new
                        Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("A", Integer.parseInt(num1.getText().toString()));
                i.putExtra("B", Integer.parseInt(num2.getText().toString()));
                i.putExtra("C", Integer.parseInt(num3.getText().toString()));
                i.putExtra("D", Integer.parseInt(num4.getText().toString()));
                i.putExtra("E", Integer.parseInt(num5.getText().toString()));
                startActivity(i);
            }
        });
        Intent t = getIntent();
        displaySum = t.getIntExtra("S", 0);
        sum.setText(String.valueOf(displaySum));
    }
}