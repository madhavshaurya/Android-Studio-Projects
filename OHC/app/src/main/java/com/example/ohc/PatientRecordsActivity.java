package com.example.ohc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PatientRecordsActivity extends AppCompatActivity {
    private ListView listViewRecords;
    private String[] records = {"Diagnosis: Flu", "Prescription: Paracetamol", "Lab Results: Blood Test"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_records);

        listViewRecords = findViewById(R.id.list_view_records);

        // Create an ArrayAdapter to populate the ListView with patient records
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, records);

        // Set the ArrayAdapter to the ListView
        listViewRecords.setAdapter(adapter);

        // Handle item click to view details of the selected patient record
        listViewRecords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedRecord = records[position];

                // For demonstration purposes, show a toast with the selected patient record.
                Toast.makeText(PatientRecordsActivity.this, selectedRecord, Toast.LENGTH_SHORT).show();

                // Implement logic to open a new activity or dialog to show detailed patient record.
                // You can use a database (Firebase or SQLite) to store and retrieve patient records.
            }
        });
    }
}
