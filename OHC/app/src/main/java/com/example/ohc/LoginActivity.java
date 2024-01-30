package com.example.ohc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform login functionality
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // For demonstration purposes, we'll use a hardcoded login check.
                // Replace this with your actual authentication logic (Firebase or SQLite).
                if (isValidCredentials(email, password)) {
                    // If login is successful, navigate to the HomeActivity
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Prevent going back to LoginActivity on pressing the back button.
                } else {
                    // Show an error message (e.g., toast) for invalid login.
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the RegistrationActivity
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    // Replace this with your actual login authentication logic.
    private boolean isValidCredentials(String email, String password) {
        // Dummy check for demonstration purposes.
        // Replace this with actual validation logic (e.g., Firebase or SQLite).
        return email.equals("test@example.com") && password.equals("password123");
    }
}
