package com.example.hello3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidLogin(username, password)) {
                    // Successful login
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Failed login
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}