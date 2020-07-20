package com.somercelik.runnables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        stopButton.setEnabled(false);
        number = 0;
    }

    public void start(View view) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + number);
                number++;
                textView.setText("Time: " + number);
                handler.postDelayed(runnable, 1000);
            }
        };
        handler.post(runnable);
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public void stop(View view) {
        startButton.setEnabled(true);
        handler.removeCallbacks(runnable);
        number = 0;
        stopButton.setEnabled(false);
        textView.setText("Time: " + number);
    }
}