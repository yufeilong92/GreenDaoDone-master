package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        double score = 0;
        for (int i = 0; i < 11; i++) {
            if (i == 5) {
                score += 1;
            }
            if (i == 10) {
                score += 2;
            }
            if (i == 2) {

                score += 0.5;

                score += 0.5;

                score += 0.5;

                score += 0.5;

                score += 0.5;
            }
        }
        Log.e("yfl", "onCreate: " + String.valueOf(score));
    }
}
