package com.example.lab93;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editId, editName, editFatherName, editVITEERank;
    private RadioGroup genderRadioGroup;
    private Button btnRegister, btnDelete, btnModify;

    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editFatherName = findViewById(R.id.editFatherName);
        editVITEERank = findViewById(R.id.editVITEERank);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);

        btnRegister = findViewById(R.id.btnRegister);
        btnDelete = findViewById(R.id.btnDelete);
        btnModify = findViewById(R.id.btnModify);

        // Create or open the database
        database = openOrCreateDatabase("students_data.db", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS students_data " +
                "(id INTEGER PRIMARY KEY, name TEXT, father_name TEXT, vitee_rank TEXT, gender TEXT);");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteStudent();
            }
        });

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyStudent();
            }
        });
    }

    private void registerStudent() {
        String id = editId.getText().toString();
        String name = editName.getText().toString();
        String fatherName = editFatherName.getText().toString();
        String viteeRank = editVITEERank.getText().toString();
        String gender = ((RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId())).getText().toString();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("father_name", fatherName);
        values.put("vitee_rank", viteeRank);
        values.put("gender", gender);

        database.insert("students_data", null, values);

        Toast.makeText(this, "Student registered successfully.", Toast.LENGTH_SHORT).show();
    }

    private void deleteStudent() {
        String id = editId.getText().toString();
        int rowsDeleted = database.delete("students_data", "id=?", new String[]{id});

        if (rowsDeleted > 0) {
            Toast.makeText(this, "Student deleted successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Student not found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void modifyStudent() {
        String id = editId.getText().toString();
        String name = editName.getText().toString();
        String fatherName = editFatherName.getText().toString();
        String viteeRank = editVITEERank.getText().toString();
        String gender = ((RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId())).getText().toString();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("father_name", fatherName);
        values.put("vitee_rank", viteeRank);
        values.put("gender", gender);

        int rowsUpdated = database.update("students_data", values, "id=?", new String[]{id});

        if (rowsUpdated > 0) {
            Toast.makeText(this, "Student information updated successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Student not found.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database != null) {
            database.close();
        }
    }
}
