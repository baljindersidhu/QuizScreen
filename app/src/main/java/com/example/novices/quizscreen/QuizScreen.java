package com.example.novices.quizscreen;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class QuizScreen extends AppCompatActivity {

    TextView txtQuestion, txtOptA, txtOptB, txtOptC, txtOptD, txtQnum;
    ImageButton btnNext;
    int ans, noQuestion, subjectChoice;
    static int questionNumber, correct = 0, incorrect = 0;
    Random random;
    Question questions[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        txtQnum = (TextView)findViewById(R.id.QuestionNo);
        txtQuestion = (TextView)findViewById(R.id.question);
        txtOptA = (TextView)findViewById(R.id.optionA);
        txtOptB = (TextView)findViewById(R.id.optionB);
        txtOptC = (TextView)findViewById(R.id.optionC);
        txtOptD = (TextView)findViewById(R.id.optionD);
        btnNext = (ImageButton)findViewById(R.id.NextButton);

        random = new Random();

        subjectChoice = 1;      // ToDo: Get subject choice from MainActivity
        questionNumber = 1;

        if(subjectChoice == 1) {
            noQuestion = 11;
            questions = new Question[noQuestion];

            questions[0] = new Question("Conversion of decimal number 61 to it's binary number equivalent is", "110011", "11001110", "111101", "11111", 3);
            questions[1] = new Question("An OR gate can be imagined as", "switches connected in series", "switches connected in parallel", "MOS transistors connected in series", "None of the above", 2);
            questions[2] = new Question("Address 200H contains the byte 3FH. What is the decimal equivalent of 3FH", "63", "32", "16", "38", 1);
            questions[3] = new Question("Conversion of an octal number 112 to hexadecimal number is", "4A", "5A", "15", "20", 1);
            questions[4] = new Question("The functional difference between SR flip-flop and JK flip-flop is that", "JK flip-flop is faster than SR flip-flop", "JK flip-flop has a feed back path", "JK flip-flop accepts both inputs 1", "JK flip-flop does not require external clock", 3);
            questions[5] = new Question("A p- channel enhancement type MOSFET performs much the same function as a PNP transistor, except that", "it operates much faster", "it is considerably larger", "it is controlled by voltage rather than by current, so that it requires very little current at the control terminal", "it is controlled by current rather than by voltage like a bipolar transistor.", 3);
            questions[6] = new Question("De Morgan's second therm says that NAND gate is equivalent to a bubbled _____ gate.", "AND", "XAND", "XOR", "OR", 4);
            questions[7] = new Question("What logic function is produced by adding an inverter to each input and the output of an AND gate?", "NAND", "NOR", "OR", "XOR", 3);
            questions[8] = new Question("When a transistor is cut off or saturated, transistor _____ have almost no effect", "wave", "variations", "stage", "circuits", 2);
            questions[9] = new Question("Express -7 as 16-bit signed binary numbers.", "0000 0000 0000 0111", "1000 0000 0000 0111", "0111 0000 0000 0001", "0111 0000 0000 0000", 2);
            questions[10] = new Question("The inverter OR gate and AND gate are called decision-making elements because they can recognize some input _____ while disregarding others. A gate recognizes a word when its output is _____", "words, high", "bytes, low", "bytes, high", "character, low", 1);
        }
        refreshQuestion();
        next();
    }


    public void aClicked(View view){
        if (ans == 1) {
            showMessage("Correct", "");
            correct++;
            next();
        }
        else {
            showMessage("Wrong", "Try again!");
            txtOptA.setTextColor(Color.RED);
            incorrect++;
        }
    }
    public void bClicked(View view){
        if (ans == 2) {
            showMessage("Correct", "");
            correct++;
            next();
        }
        else {
            showMessage("Wrong", "Try again!");
            txtOptB.setTextColor(Color.RED);
            incorrect++;
        }
    }
    public void cClicked(View view){
        if (ans == 3) {
            showMessage("Correct", "");
            correct++;
            next();
        }
        else {
            showMessage("Wrong", "Try again!");
            txtOptC.setTextColor(Color.RED);
            incorrect++;
        }
    }
    public void dClicked(View view){
        if (ans == 4) {
            showMessage("Correct", "");
            correct++;
            next();
        }
        else {
            showMessage("Wrong", "Try again!");
            txtOptD.setTextColor(Color.RED);
            incorrect++;
        }
    }

    public void refreshQuestion() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("You answered ")
                        .append(correct)
                        .append(" questions correctly in ")
                        .append(correct + incorrect)
                        .append(" attempts");
                showMessage("Result",buffer.toString());
            }
        });
    }

    public void next(){
        txtQnum.setText("#" + Integer.toString(questionNumber++));
        int rand = (Math.abs(random.nextInt()))%noQuestion;
        txtQuestion.setText(questions[rand].question);
        txtOptA.setText(questions[rand].optA);
        txtOptB.setText(questions[rand].optB);
        txtOptC.setText(questions[rand].optC);
        txtOptD.setText(questions[rand].optD);
        ans = questions[rand].ans;
        txtOptA.setTextColor(Color.argb(255,46,125,50));
        txtOptB.setTextColor(Color.argb(255,46,125,50));
        txtOptC.setTextColor(Color.argb(255,46,125,50));
        txtOptD.setTextColor(Color.argb(255,46,125,50));
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
