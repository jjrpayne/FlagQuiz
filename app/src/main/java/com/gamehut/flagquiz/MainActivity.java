package com.gamehut.flagquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void shortQuiz(View view) {
        // Start quiz
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void allCountries(View view) {
        finish();
        exit(0);
    }
}
