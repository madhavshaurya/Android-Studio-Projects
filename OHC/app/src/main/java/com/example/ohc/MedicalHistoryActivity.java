package com.example.ohc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MedicalHistoryActivity extends AppCompatActivity {
    private ListView listViewMedicalHistory;
    private String[] medicalHistory = {
            "2022-01-15: Diagnosis - Flu",
            "2022-01-20: Prescription - Paracetamol",
            "2022-02-10: Lab Results - Blood Test",
            "2022-03-05: Diagnosis - Allergies",
            "2022-03-10: Prescription - Antihistamine",
            "2022-04-01: Diagnosis - Sinusitis",
            "2022-04-05: Prescription - Antibiotics",
            "2022-05-20: Lab Results - X-Ray"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);

        listViewMedicalHistory = findViewById(R.id.list_view_medical_history);

        // Create an ArrayAdapter to populate the ListView with medical history entries
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, medicalHistory);

        // Set the ArrayAdapter to the ListView
        listViewMedicalHistory.setAdapter(adapter);

        // Handle item click to view details of the selected medical history entry
        listViewMedicalHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedEntry = medicalHistory[position];

                // For demonstration purposes, show a toast with the selected medical history entry.
                Toast.makeText(MedicalHistoryActivity.this, selectedEntry, Toast.LENGTH_SHORT).show();

                // Implement logic to open PatientRecordsActivity to show detailed information for the selected entry.
                Intent intent = new Intent(MedicalHistoryActivity.this, PatientRecordsActivity.class);
                intent.putExtra("selected_entry", selectedEntry);
                startActivity(intent);
            }
        });
    }
}
