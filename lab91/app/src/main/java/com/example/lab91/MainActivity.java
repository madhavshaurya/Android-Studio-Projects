package com.example.lab91;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab91.CustomGridAdapter;

public class MainActivity extends AppCompatActivity {
    private GridView mGridView;
    private CustomGridAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = findViewById(R.id.gridView);
        mAdapter = new CustomGridAdapter(this);
        mGridView.setAdapter(mAdapter);
    }
}
