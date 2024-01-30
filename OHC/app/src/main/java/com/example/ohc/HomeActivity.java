package com.example.ohc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private Button btnAppointments;
    private Button btnDoctors;
    private Button btnPatientRecords;
    private Button btnMedicalHistory; // Newly added button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAppointments = findViewById(R.id.btn_appointments);
        btnDoctors = findViewById(R.id.btn_doctors);
        btnPatientRecords = findViewById(R.id.btn_patient_records);
        btnMedicalHistory = findViewById(R.id.btn_medical_history); // Find the newly added button

        btnAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the AppointmentsActivity
                Intent intent = new Intent(HomeActivity.this, AppointmentsActivity.class);
                startActivity(intent);
            }
        });

        btnDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the DoctorsActivity
                Intent intent = new Intent(HomeActivity.this, DoctorsActivity.class);
                startActivity(intent);
            }
        });

        btnPatientRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the PatientRecordsActivity
                Intent intent = new Intent(HomeActivity.this, PatientRecordsActivity.class);
                startActivity(intent);
            }
        });

        btnMedicalHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the MedicalHistoryActivity
                Intent intent = new Intent(HomeActivity.this, MedicalHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
