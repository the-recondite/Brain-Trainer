package com.example.user.braintrainerapp;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    TextView seconds;
    ConstraintLayout constraintLayout;
    ConstraintLayout constraintLayout2;
    TextView statement;
    TextView questions;
    Button firstOption;
    Button secondOption;
    Button thirdOption;
    Button fourthOption;
    int i;
    TextView scores;
    int top;
    int bottom;
    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        constraintLayout.setVisibility(View.VISIBLE);
        random();
        timer();
    }
    public void timer () {
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondss = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                seconds.setText(String.valueOf(secondss));
            }

            @Override
            public void onFinish() {
                seconds.setText("0");
                statement.setText("Done!");
                constraintLayout2.setVisibility(View.VISIBLE);
                nonclick();
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.goButton);
        constraintLayout = findViewById(R.id.secondMain);
        seconds = findViewById(R.id.seconds);
        statement =  findViewById(R.id.statement);
        constraintLayout2 = findViewById(R.id.main2);
        questions = findViewById(R.id.questions);
        firstOption = findViewById(R.id.firstOption);
        secondOption = findViewById(R.id.secondOption);
        thirdOption = findViewById(R.id.thirdOption);
        fourthOption = findViewById(R.id.fourthOption);
        scores = findViewById(R.id.scores);
    }
    public void random() {
        firstOption.setClickable(true);
        secondOption.setClickable(true);
        thirdOption.setClickable(true);
        fourthOption.setClickable(true);
        Random rand = new Random();
        int a = rand.nextInt(11);
        int b = rand.nextInt(11);
        questions.setText(a + " + " + b);
        int answer = a + b;
        int w1 = rand.nextInt(21);
        int w2 = rand.nextInt(21);
        int w3 = rand.nextInt(21);
        i = rand.nextInt(4);
        if (i == 0) {
            firstOption.setText(String.valueOf(answer));
            secondOption.setText(String.valueOf(w1));
            thirdOption.setText(String.valueOf(w2));
            fourthOption.setText(String.valueOf(w3));
        }
        else if (i == 1) {
            secondOption.setText(String.valueOf(answer));
            firstOption.setText(String.valueOf(w1));
            thirdOption.setText(String.valueOf(w2));
            fourthOption.setText(String.valueOf(w3));
        }
        else if (i == 2) {
            thirdOption.setText(String.valueOf(answer));
            firstOption.setText(String.valueOf(w1));
            secondOption.setText(String.valueOf(w2));
            fourthOption.setText(String.valueOf(w3));
        }
        else if (i == 3) {
            fourthOption.setText(String.valueOf(answer));
            firstOption.setText(String.valueOf(w1));
            secondOption.setText(String.valueOf(w2));
            thirdOption.setText(String.valueOf(w3));
        }
    }
    public void button(View view) {
                int ans = Integer.valueOf(view.getTag().toString());
                bottom++;
                Log.i("tag", view.getTag().toString() + " " + String.valueOf(i));
                if (i == ans) {
                    statement.setText("Correct :)");
                    top++;
                    scores.setText(String.valueOf(top)+"/"+String.valueOf(bottom));
                    random();
                }
                else {
                    statement.setText("Wrong :(");
                    scores.setText(String.valueOf(top)+"/"+String.valueOf(bottom));
                    random();
                }
        }
        public void nonclick(){
            firstOption.setClickable(false);
            secondOption.setClickable(false);
            thirdOption.setClickable(false);
            fourthOption.setClickable(false);
        }
        public void tryAgain(View view){
            scores.setText("0/0");
            random();
            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long secondss = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                    seconds.setText(String.valueOf(secondss));
                }

                @Override
                public void onFinish() {
                    seconds.setText("0");
                    statement.setText("Done!");
                    constraintLayout2.setVisibility(View.VISIBLE);
                    nonclick();
                }
            }.start();
        }
}
