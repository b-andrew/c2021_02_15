package com.example.c2021_02_15.model;

public class Question {
    private int id;
    private boolean answerIsTrue;

    public int getQuestionID() {
        return id;
    }

    public Question(int id, boolean isTrue) {
        this.id = id;
        answerIsTrue = isTrue;
    }

    public boolean isQuestionTrue() {
        return answerIsTrue;
    }
}
