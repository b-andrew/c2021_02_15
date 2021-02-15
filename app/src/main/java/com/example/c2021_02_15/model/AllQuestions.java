package com.example.c2021_02_15.model;

import com.example.c2021_02_15.R;

public class AllQuestions {
    private int questionIndex;
    private Question[] allQuestions = {
            new Question(R.string.q_start, true),
            new Question(R.string.q_one, true),
            new Question(R.string.q_two, true),
            new Question(R.string.q_three, false)
    };

    public AllQuestions() {
        questionIndex = 0;
    }

    public int length() {
        return allQuestions.length;
    }

    public Question getQuestion(int index) {
        index = index % allQuestions.length;
        return allQuestions[index];
    }
}
