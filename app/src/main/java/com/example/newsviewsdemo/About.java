package com.example.newsviewsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView userTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        userTV = findViewById(R.id.hellouserTV);

        Intent intent = getIntent();
    }
}
