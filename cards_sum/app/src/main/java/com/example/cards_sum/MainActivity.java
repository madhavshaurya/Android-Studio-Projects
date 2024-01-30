package com.example.cards_sum;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    EditText n1,n2,n3,n4,n5,sum;
    Button b1,b2;
    int displaysum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        sum=findViewById(R.id.sum);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2); final int
                arr[]=new int[5];
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand=new Random();
                arr[0]=rand.nextInt(13);
                n1.setText(String.valueOf(arr[0]));
                arr[1]=rand.nextInt(13);
                n2.setText(String.valueOf(arr[1]));
                arr[2]=rand.nextInt(13);
                n3.setText(String.valueOf(arr[2]));
                arr[3]=rand.nextInt(13);
                n4.setText(String.valueOf(arr[3]));
                arr[4]=rand.nextInt(13);
                n5.setText(String.valueOf(arr[4]));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new
                        Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("A",Integer.parseInt(n1.getText().toString()));
                i.putExtra("B",Integer.parseInt(n2.getText().toString()));
                i.putExtra("C",Integer.parseInt(n3.getText().toString()));
                i.putExtra("D",Integer.parseInt(n4.getText().toString()));
                i.putExtra("E",Integer.parseInt(n5.getText().toString()));
                startActivity(i);
            }
        });
        Intent t=getIntent();
        displaysum=t.getIntExtra("S",0);
        sum.setText(String.valueOf(displaysum));
    }
}
