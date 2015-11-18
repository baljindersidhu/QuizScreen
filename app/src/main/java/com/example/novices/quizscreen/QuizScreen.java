package com.example.novices.quizscreen;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class QuizScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
        ImageButton but = (ImageButton) findViewById(R.id.NextButton);
        final Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.vibrate(50);
            }
        });
    }
}
