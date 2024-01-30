package com.example.lab45;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
    }
    public void checkCredentials(View view) {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter both username and password.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.equals("shaurya") && password.equals("shaurya7091")) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}