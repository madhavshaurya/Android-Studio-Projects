package com.example.lab82;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    Button b1,b2,winner;
    int v1,v2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        winner=findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                v1= random.nextInt(7);
                t1.setText(Integer.toString(v1));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                v2= random.nextInt(7);
                t2.setText(Integer.toString(v2));
            }
        });
        winner.setOnClickListener(new View.OnClickListener() {
            int notificationID = 1;
            @Override
            public void onClick(View view) {
                String CHANNEL_ID="CHANNEL_ID";
                NotificationManager notificationManager =
                        (NotificationManager)
                                getSystemService(Context.NOTIFICATION_SERVICE);
                if(v1>v2){
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
                        NotificationChannel nc = new
                                NotificationChannel(CHANNEL_ID,"Mychannal",NotificationManager.IMPORTANCE_DEFAULT);
                        notificationManager.createNotificationChannel(nc);
                    }
                    NotificationCompat.Builder notifBuilder = new
                            NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("🙌ROLL DICE WINNER🙌")
                            .setContentText("Congrats, Winner is User1.");
                    notificationManager.notify(notificationID, notifBuilder.build());
                }
                else{
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
                        NotificationChannel nc = new
                                NotificationChannel(CHANNEL_ID,"Mychannal",NotificationManager.IMPORTANCE_DEFAULT);
                        notificationManager.createNotificationChannel(nc);
                    }
                    NotificationCompat.Builder notifBuilder = new
                            NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("🙌ROLL DICE WINNER🙌")
                            .setContentText("Congrats, Winner is User2.");
                    notificationManager.notify(notificationID, notifBuilder.build());
                }}
        });
    }
}
