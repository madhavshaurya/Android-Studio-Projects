    package com.example.lab71;

    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.widget.Button;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.TimePicker;
    import android.app.TimePickerDialog;
    import java.util.*;

    import androidx.appcompat.app.AppCompatActivity;
            import android.os.Bundle;
            import android.widget.Button;
            import android.view.View;
            import android.widget.EditText;
            import android.widget.TimePicker;
            import android.app.TimePickerDialog;
            import java.util.*;
    public class MainActivity extends AppCompatActivity {
        EditText t1,t2,t3;
        Button b1,b2,b3; TimePicker ti;
        int Time1[]=new int[2];
        int Time2[]=new int[2];
        int Time3[]=new int[2];
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b1=findViewById(R.id.button);
            b2=findViewById(R.id.button2);
            b3=findViewById(R.id.button3);
            t1=findViewById(R.id.editTextTime);
            t2=findViewById(R.id.editTextTime2);
            t3=findViewById(R.id.editTextTime3);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    time(Time1,t1);
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    time(Time2,t2);
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    time(Time3,t3);
                }
            });
        }
        private void time(int[] t, EditText e) {
            final Calendar c = Calendar.getInstance();
            t[0] = c.get(Calendar.HOUR_OF_DAY);
            t[1] = c.get(Calendar.MINUTE);
    // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new
                    TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            e.setText(String.valueOf(hourOfDay + ":" +
                                    minute));
                            t[0]=hourOfDay;
                            t[1]=minute;
                        }
                    }, t[0], t[1], true);
            timePickerDialog.show();
        }
    }

