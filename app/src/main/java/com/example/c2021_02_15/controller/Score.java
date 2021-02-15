package com.example.c2021_02_15.controller;

import com.example.c2021_02_15.model.AllQuestions;

public class Score {
    public final int CORRECT_ANSWER = 10;
    public final int SKIP_QUESTION = -5;
    public int score;
    public Score() {
        score = 0;

    }

    public void correctAnswer() {
        score = score + CORRECT_ANSWER;

    }


    public int getScore() {
        return score;
    }

    public void skipQuestion() {
        score = score + SKIP_QUESTION;
    }

    AllQuestions allQs = new AllQuestions();
}
