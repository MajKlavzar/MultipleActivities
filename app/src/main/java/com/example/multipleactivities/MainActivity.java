package com.example.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_COUNTER = "counter";

    private int counter = 0;
    private TextView tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null && getIntent().hasExtra(EXTRA_COUNTER)) {
            counter = getIntent().getIntExtra(EXTRA_COUNTER, 0);
        } else if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(EXTRA_COUNTER, 0);
        }

        tvCounter = findViewById(R.id.tv_counter);
        tvCounter.setText(String.valueOf(counter));

        Button btnGoToActivity2 = findViewById(R.id.btn_go_to_activity2);
        Button btnGoToActivity3 = findViewById(R.id.btn_go_to_activity3);
        Button btnCount = findViewById(R.id.btn_count);

        btnCount.setOnClickListener(v -> {
            counter++;
            tvCounter.setText(String.valueOf(counter));
        });

        btnGoToActivity2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HelloActivity.class);
            intent.putExtra(EXTRA_COUNTER, counter);
            startActivity(intent);
        });

        btnGoToActivity3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putExtra(EXTRA_COUNTER, counter);
            startActivity(intent);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_COUNTER, counter);
    }
}