package com.quizmagic.qmas;

import android.graphics.drawable.Drawable;

/**
 * Created by student on 2016/4/14.
 */
public interface QuestionAdapter {
    int getQuestionCount();
    CharSequence getQuestion(int index);
    CharSequence getQuestionOptionA(int index);
    CharSequence getQuestionOptionB(int index);
    CharSequence getQuestionOptionC(int index);
    Drawable getBackground(int index);
}
