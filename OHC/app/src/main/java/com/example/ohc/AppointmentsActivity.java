package com.example.ohc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppointmentsActivity extends AppCompatActivity {
    private TextView tvAppointmentDetails;
    private Button btnAddAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        tvAppointmentDetails = findViewById(R.id.tv_appointment_details);
        btnAddAppointment = findViewById(R.id.btn_add_appointment);

        // Display the list of existing appointments in the TextView (for demonstration purposes)
        StringBuilder appointmentsList = new StringBuilder();
        appointmentsList.append("Appointment 1: 10:00 AM, Dr. Smith\n");
        appointmentsList.append("Appointment 2: 2:30 PM, Dr. Johnson");
        tvAppointmentDetails.setText(appointmentsList);

        btnAddAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic to open a new activity for scheduling a new appointment
                // You can create a new activity or a dialog to handle the appointment scheduling.
            }
        });
    }
}
