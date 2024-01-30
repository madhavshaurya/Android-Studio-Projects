package com.example.ohc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorsActivity extends AppCompatActivity {
    private ListView listViewDoctors;
    private String[] doctorNames = {"Dr. John Smith", "Dr. Jane Johnson", "Dr. Robert Lee"};
    private String[] specialties = {"Cardiologist", "Dermatologist", "Orthopedic Surgeon"};
    private String[] contactInfo = {"Contact: john.smith@example.com", "Contact: jane.johnson@example.com",
            "Contact: robert.lee@example.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        listViewDoctors = findViewById(R.id.list_view_doctors);

        // Create an ArrayAdapter to populate the ListView with doctor names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, doctorNames);

        // Set the ArrayAdapter to the ListView
        listViewDoctors.setAdapter(adapter);

        // Handle item click to view details or schedule appointment
        listViewDoctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedDoctor = doctorNames[position];
                String doctorSpecialty = specialties[position];
                String doctorContact = contactInfo[position];

                // For demonstration purposes, show a toast with doctor details.
                String message = "Doctor: " + selectedDoctor + "\nSpecialty: " + doctorSpecialty + "\n" + doctorContact;
                Toast.makeText(DoctorsActivity.this, message, Toast.LENGTH_LONG).show();

                // Implement logic to open a new activity for detailed doctor information and appointment scheduling.
                // You can create a new activity or a dialog to handle this.
            }
        });
    }
}
