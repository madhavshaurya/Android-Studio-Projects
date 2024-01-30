package com.example.playing_cards;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity2 extends AppCompatActivity
{
    int a,b,c,d,e,sum;
    Button reply;
    EditText num1,num2,num3,num4,num5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        reply=findViewById(R.id.reply);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        final int arr[]=new int[5];
        Intent
                i=getIntent();
        a=i.getIntExtra("A",0);
        b=i.getIntExtra("B",0);
        c=i.getIntExtra("C",0);
        d=i.getIntExtra("D",0);
        e=i.getIntExtra("E",0);
        arr[0]=a;
        arr[1]=b;
        arr[2]=c;
        arr[3]=d;
        arr[4]=e;
        for (int k = 0; k < 4; k++)
            for (int j = 0; j < 4; j++) if (arr[j]
                    > arr[j + 1]) {
                int temp = arr[j]; arr[j]
                        = arr[j + 1];arr[j + 1] =
                        temp;
            }
        num1.setText(String.valueOf(arr[0]));
        num2.setText(String.valueOf(arr[1]));
        num3.setText(String.valueOf(arr[2]));
        num4.setText(String.valueOf(arr[3]));
        num5.setText(String.valueOf(arr[4]));
        sum=a+b+c+d+e;
        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new
                        Intent(getApplicationContext(),MainActivity.class);
                in.putExtra("S",sum);
                startActivity(in);
            }
        });
    }
}