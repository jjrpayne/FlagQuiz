package com.gamehut.flagquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String QUESTIONS = "com.gamehut.flagquiz.extra.QUESTIONS";
    public static final String POSITION = "com.gamehut.flagquiz.extra.POSITION";
    public static final String SCORE = "com.gamehut.flagquiz.extra.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shortQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(SCORE, 0);
        intent.putExtra(POSITION, 0);
        intent.putExtra(QUESTIONS, 25);
    }

    public void allCountries(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra(SCORE, 0);
        intent.putExtra(POSITION, 0);
        intent.putExtra(QUESTIONS, 196);
    }
}
