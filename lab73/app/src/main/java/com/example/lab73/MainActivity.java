package com.example.lab73;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.switch1);
        s2 = findViewById(R.id.switch3);
        s3 = findViewById(R.id.switch4);
        s4 = findViewById(R.id.switch5);
        s1.setOnCheckedChangeListener(new
                                              CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean b) {
                                                      if (s1.isChecked()) {
                                                          Toast.makeText(getApplicationContext(), s1.getText() +
                                                                          " is on",
                                                                  Toast.LENGTH_SHORT).show();
                                                      } else {
                                                          Toast.makeText(getApplicationContext(), s1.getText() +
                                                                          " is off",
                                                                  Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
        s2.setOnCheckedChangeListener(new
                                              CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean b) {
                                                      if (s2.isChecked()) {
                                                          Toast.makeText(getApplicationContext(), s2.getText() +
                                                                          " is on",
                                                                  Toast.LENGTH_SHORT).show();
                                                      } else {
                                                          Toast.makeText(getApplicationContext(), s2.getText() +
                                                                          " is off",
                                                                  Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
        s3.setOnCheckedChangeListener(new
                                              CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean b) {
                                                      if (s3.isChecked()) {
                                                          Toast.makeText(getApplicationContext(), s3.getText() +
                                                                          " is on",
                                                                  Toast.LENGTH_SHORT).show();
                                                      } else {
                                                          Toast.makeText(getApplicationContext(), s3.getText() +
                                                                          " is off",
                                                                  Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
        s4.setOnCheckedChangeListener(new
                                              CompoundButton.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(CompoundButton compoundButton,
                                                                               boolean b) {
                                                      if (s4.isChecked()) {
                                                          Toast.makeText(getApplicationContext(), s4.getText() +
                                                                          " is on",
                                                                  Toast.LENGTH_SHORT).show();
                                                      } else {
                                                          Toast.makeText(getApplicationContext(), s4.getText() +
                                                                          "is off",
                                                                  Toast.LENGTH_SHORT).show();
                                                      }
                                                  }
                                              });
    }
}