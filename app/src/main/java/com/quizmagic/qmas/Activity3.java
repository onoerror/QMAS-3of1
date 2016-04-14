package com.quizmagic.qmas;

public class Activity3 extends QuestionActivity {

    @Override
    protected Class getBackActivityClass() {
        return Activity2.class;
    }

    @Override
    protected Class getNextActivityClass() {
        return null;
    }

    @Override
    protected int getBackButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }

    @Override
    protected int getNextButtonVisibility() {
        return QuestionActivity.VISIBLE;
    }
}