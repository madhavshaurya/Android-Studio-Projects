package com.example.lab74;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;
public class MainActivity extends AppCompatActivity {
    ToggleButton t1, t2, t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.toggleButton);
        t2 = findViewById(R.id.toggleButton2);
        t3 =findViewById(R.id.toggleButton3);
        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean
                                                                                       isChecked) {
                                                      if(isChecked){
                                                          Toast.makeText(getApplicationContext(),"Bedroom is on",Toast.LENGTH_SHORT).show();
                                                      }else {
                                                          Toast.makeText(getApplicationContext(),"Bedroom is off",Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
        t2.setOnCheckedChangeListener(new
                                              CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean
                                                                                       isChecked) {
                                                      if(isChecked){
                                                          Toast.makeText(getApplicationContext(),"Kitchen is on",Toast.LENGTH_SHORT).show();
                                                      }else {
                                                          Toast.makeText(getApplicationContext(),"Kitchen is off",Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
        t3.setOnCheckedChangeListener(new
                                              CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean
                                                                                       isChecked) {
                                                      if(isChecked){
                                                          Toast.makeText(getApplicationContext(),"Garage on",Toast.LENGTH_SHORT).show();
                                                      }else {
                                                          Toast.makeText(getApplicationContext(),"Garage is off",Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
    }
}