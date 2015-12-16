package com.example.novices.quizscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private static RadioGroup rg_topic;
    private static RadioButton rb_topic;
    private static ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Deepan", "onCreate called Main");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // disable button
        img =(ImageButton) findViewById(R.id.NextButtonQuiz);
        img.setEnabled(false);

        rg_topic = (RadioGroup) findViewById(R.id.rg_topic);
        rg_topic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // enabling the button to perform given action
                img.setEnabled(true);

            }
        });

        final Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizScreen.class);
                vib.vibrate(50);
                startActivity(intent);
            }
        });
    }
}
