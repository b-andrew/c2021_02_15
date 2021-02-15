package com.example.c2021_02_15.controller;

public class NextQuestion {
    public NextQuestion(int total_qs) {
        total_number_of_questions = total_qs;
    }

    private static int index = 0;
    private static int total_number_of_questions = 0;
    public int getCurrentQuestion() {
        return index;
    }

    public int getNextQuestionIndex() {
        index = (index + 1) % total_number_of_questions;
        return index;
    }
}
