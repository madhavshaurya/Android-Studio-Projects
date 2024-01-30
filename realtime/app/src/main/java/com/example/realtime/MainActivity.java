package com.example.realtime;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText employeeNameEdt, employeePhoneEdt, employeeAddressEdt;
    private Button sendDatabtn, startChatButton;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private EmployeeInfo employeeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeNameEdt = findViewById(R.id.idEdtEmployeeName);
        employeePhoneEdt = findViewById(R.id.idEdtEmployeePhoneNumber);
        employeeAddressEdt = findViewById(R.id.idEdtEmployeeAddress);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("EmployeeInfo");

        employeeInfo = new EmployeeInfo();

        sendDatabtn = findViewById(R.id.idBtnSendData);
        startChatButton = findViewById(R.id.idBtnChat);

        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = employeeNameEdt.getText().toString();
                String phone = employeePhoneEdt.getText().toString();
                String address = employeeAddressEdt.getText().toString();

                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)) {
                    Toast.makeText(MainActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    addDatatoFirebase(name, phone, address);
                }
            }
        });

        startChatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addDatatoFirebase(String name, String phone, String address) {
        // Create a reference to the "EmployeeInfo" node
        DatabaseReference employeeNode = databaseReference.child(name);

        // Check if an employee with the same name already exists
        employeeNode.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Employee with the same name exists, update the details
                    EmployeeInfo existingEmployee = snapshot.getValue(EmployeeInfo.class);
                    existingEmployee.setEmployeeContactNumber(phone);
                    existingEmployee.setEmployeeAddress(address);
                    employeeNode.setValue(existingEmployee);

                    Toast.makeText(MainActivity.this, "Employee details updated", Toast.LENGTH_SHORT).show();
                } else {
                    // No employee with the same name, create a new entry
                    EmployeeInfo newEmployee = new EmployeeInfo();
                    newEmployee.setEmployeeName(name);
                    newEmployee.setEmployeeContactNumber(phone);
                    newEmployee.setEmployeeAddress(address);
                    employeeNode.setValue(newEmployee);

                    Toast.makeText(MainActivity.this, "New employee details added", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
