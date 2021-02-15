package com.example.c2021_02_15;

import android.content.Intent;
import android.os.Bundle;

import com.example.c2021_02_15.controller.NextQuestion;
import com.example.c2021_02_15.controller.Score;
import com.example.c2021_02_15.model.AllQuestions;
import com.example.c2021_02_15.model.Question;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView questionView = null;
    private TextView scoreView = null;
    private Button trueButton = null;
    private Button falseButton = null;
    private Button nextButton = null;
    private Button doneButton = null;

    private static final String TAG_INDEX = "GAME_MAIN_ACTIVITY";

    AllQuestions allQuestions = new AllQuestions();

    NextQuestion nextQuestion = new NextQuestion(allQuestions.length());

    Score score = new Score();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionView = findViewById(R.id.questionView);
        scoreView = findViewById(R.id.scoreView);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        doneButton = findViewById(R.id.done_button);
        questionView.setText(R.string.q_start);
        scoreView.setText(R.string.initial_score);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                i.putExtra("score", score.getScore());
            }
        });
    }

    public void buttonClick(View v) {
        int index = nextQuestion.getCurrentQuestion();
        Question question = null;
        try {
            question = allQuestions.getQuestion(index);

        }
        catch (Exception e) {
            Log.d(TAG_INDEX, "index out of bounds");

        }
        if (v.getId() == R.id.true_button) {
            if (question.isQuestionTrue()) {
                score.correctAnswer();
                scoreView.setText(String.valueOf(score.getScore()));
            }


        }
        else if (v.getId() == R.id.false_button) {
            if (!question.isQuestionTrue()) {
                score.correctAnswer();
                scoreView.setText(String.valueOf(score.getScore()));
            }
        }

        else {
            score.skipQuestion();
            scoreView.setText(String.valueOf(score.getScore()));
        }

        index = nextQuestion.getNextQuestionIndex();
        questionView.setText(allQuestions.getQuestion(index).getQuestionID());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}