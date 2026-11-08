package com.example.multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        if (getIntent() != null && getIntent().hasExtra(MainActivity.EXTRA_COUNTER)) {
            counter = getIntent().getIntExtra(MainActivity.EXTRA_COUNTER, 0);
        }

        TextView tvCounter = findViewById(R.id.tv_counter);
        tvCounter.setText(String.valueOf(counter));

        Button btnGoToActivity1 = findViewById(R.id.btn_go_to_activity1);
        Button btnGoToActivity2 = findViewById(R.id.btn_go_to_activity2);

        btnGoToActivity1.setOnClickListener(v -> navigateToActivity1());
        btnGoToActivity2.setOnClickListener(v -> navigateToActivity2());

        View mainLayout = findViewById(R.id.third_main_layout);
        mainLayout.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {
                navigateToActivity1();
            }

            @Override
            public void onSwipeRight() {
                navigateToActivity2();
            }
        });
    }

    private void navigateToActivity1() {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_COUNTER, counter);
        startActivity(intent);
    }

    private void navigateToActivity2() {
        Intent intent = new Intent(ThirdActivity.this, HelloActivity.class);
        intent.putExtra(MainActivity.EXTRA_COUNTER, counter);
        startActivity(intent);
    }
}