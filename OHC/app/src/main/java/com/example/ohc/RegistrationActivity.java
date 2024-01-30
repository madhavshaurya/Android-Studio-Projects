package com.example.ohc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etFullName = findViewById(R.id.et_full_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform user registration functionality
                String fullName = etFullName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // For demonstration purposes, we'll just finish the registration without actual validation.
                // Replace this with your actual registration logic (Firebase or SQLite).
                if (isValidRegistrationData(fullName, email, password)) {
                    // If registration is successful, automatically log in the user and redirect to HomeActivity.
                    // In a real app, you'd handle registration and authentication separately.
                    // Here, we assume the registration is valid and simply redirect the user to HomeActivity.
                    Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Prevent going back to RegistrationActivity on pressing the back button.
                } else {
                    // Show an error message (e.g., toast) for invalid registration data.
                }
            }
        });
    }

    // Replace this with your actual registration data validation logic.
    private boolean isValidRegistrationData(String fullName, String email, String password) {
        // Dummy check for demonstration purposes.
        // Replace this with actual validation logic (e.g., Firebase or SQLite).
        return !fullName.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() >= 6;
    }
}
