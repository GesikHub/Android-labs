package com.example.vladushka.trafficlight;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mConstraintLayout;
    private TextView mInfoTextView;
    private Button redButton, yellowButton, greenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        mConstraintLayout.setBackgroundColor(ContextCompat
                .getColor(MainActivity.this, R.color.redColor));
        mInfoTextView = (TextView) findViewById(R.id.textView);
        mInfoTextView.setTextColor(ContextCompat
                .getColor(MainActivity.this, R.color.darkRedColor));
        mInfoTextView.setText(R.string.red);
        redButton = (Button) findViewById(R.id.buttonRed);
        yellowButton = (Button) findViewById(R.id.buttonYellow);
        greenButton = (Button) findViewById(R.id.buttonGreen);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText(R.string.red);
                mInfoTextView.setTextColor(ContextCompat
                        .getColor(MainActivity.this, R.color.darkRedColor));
                mConstraintLayout.setBackgroundColor(ContextCompat
                        .getColor(MainActivity.this, R.color.redColor));

            }
        });
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText(R.string.yellow);
                mInfoTextView.setTextColor(ContextCompat
                        .getColor(MainActivity.this, R.color.darkYellowColor));
                mConstraintLayout.setBackgroundColor(ContextCompat
                        .getColor(MainActivity.this, R.color.yellowColor));

            }
        });
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText(R.string.green);
                mInfoTextView.setTextColor(ContextCompat
                        .getColor(MainActivity.this, R.color.darkGreenColor));
                mConstraintLayout.setBackgroundColor(ContextCompat
                        .getColor(MainActivity.this, R.color.greenColor));
            }
        });
    }
}
