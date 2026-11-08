package com.example.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        if (getIntent() != null && getIntent().hasExtra(MainActivity.EXTRA_COUNTER)) {
            counter = getIntent().getIntExtra(MainActivity.EXTRA_COUNTER, 0);
        }

        TextView tvCounter = findViewById(R.id.tv_counter);
        tvCounter.setText(String.valueOf(counter));

        Button btnGoToActivity1 = findViewById(R.id.btn_go_to_activity1);
        btnGoToActivity1.setOnClickListener(v -> {
            Intent intent = new Intent(HelloActivity.this, MainActivity.class);
            intent.putExtra(MainActivity.EXTRA_COUNTER, counter);
            startActivity(intent);
        });
    }
}