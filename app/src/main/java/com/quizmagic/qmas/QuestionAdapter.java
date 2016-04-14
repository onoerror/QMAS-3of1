package com.quizmagic.qmas;

/**
 * Created by student on 2016/4/14.
 */
public interface QuestionAdapter {
    int getQuestionCount();
    CharSequence getQuestion(int index);
    CharSequence getQuestionOptionA(int index);
    CharSequence getQuestionOptionB(int index);
    CharSequence getQuestionOptionC(int index);
}
