package com.example.lab92;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button registerButton, loginButton, readDataButton;
    private TextView textView1, textView2;

    private SharedPreferences sharedPreferences;
    private int loginAttempts = 0;
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        readDataButton = findViewById(R.id.readDataButton);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        readDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readUserData();
            }
        });
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!username.isEmpty() && !password.isEmpty()) {
            int x = Integer.parseInt(username);
            int f_x = x * x + 5;

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(username, f_x);
            editor.apply();

            Toast.makeText(this, "User registered successfully.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter valid credentials.", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (!username.isEmpty() && !password.isEmpty()) {
            int x = Integer.parseInt(username);
            int f_x = x * x + 5;

            int enteredPassword = Integer.parseInt(password);

            if (sharedPreferences.contains(username)) {
                int storedPassword = sharedPreferences.getInt(username, -1);
                if (storedPassword == f_x && enteredPassword == f_x) {
                    Toast.makeText(this, "Login successful.", Toast.LENGTH_SHORT).show();
                } else {
                    loginAttempts++;
                    if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                        loginButton.setEnabled(false);
                        Toast.makeText(this, "Maximum login attempts reached.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Incorrect credentials. Attempts remaining: " + (MAX_LOGIN_ATTEMPTS - loginAttempts), Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "User not registered.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter valid credentials.", Toast.LENGTH_SHORT).show();
        }
    }

    private void readUserData() {
        String username = usernameEditText.getText().toString().trim();

        if (!username.isEmpty()) {
            int storedPassword = sharedPreferences.getInt(username, -1);
            if (storedPassword != -1) {
                textView2.setText("Password: " + storedPassword);
            } else {
                textView2.setText("Password not found.");
            }
        } else {
            Toast.makeText(this, "Please enter a username.", Toast.LENGTH_SHORT).show();
        }
    }
}
