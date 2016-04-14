package com.quizmagic.qmas;

import android.content.res.Resources;
import android.text.Html;

import java.util.ArrayList;
import java.util.List;

public class QuestionFromStringResource implements QuestionAdapter {

    List<Question>list = new ArrayList<>();// 陣列存放所有的 Question 物件
    // 建構子
    public QuestionFromStringResource(Resources res){
        // 在陣列中建立 3 個 Question
        list.add(new Question(res.getString(R.string.question_1),
                res.getString(R.string.question_1_radio_a),
                res.getString(R.string.question_1_radio_b),
                res.getString(R.string.question_1_radio_b))
        );
        list.add(new Question(res.getString(R.string.question_2),
                        res.getString(R.string.question_2_radio_a),
                        res.getString(R.string.question_2_radio_b),
                        res.getString(R.string.question_2_radio_b))
        );
        list.add(new Question(res.getString(R.string.question_3),
                        res.getString(R.string.question_3_radio_a),
                        res.getString(R.string.question_3_radio_b),
                        res.getString(R.string.question_3_radio_b))
        );
    }

    @Override
    public int getQuestionCount() {
        return list.size();// 一共有 3 題
    }

    @Override
    public CharSequence getQuestion(int index) {
        Question question = list.get(index);// 讀取一個 Question 物件
        String text = question.getQuestion();
        return Html.fromHtml(text);// 字串內容有 HTML 語法，需轉換
    }

    @Override
    public CharSequence getQuestionOptionA(int index) {
        return Html.fromHtml(list.get(index).getOptionA());
    }

    @Override
    public CharSequence getQuestionOptionB(int index) {
        return Html.fromHtml(list.get(index).getOptionB());
    }

    @Override
    public CharSequence getQuestionOptionC(int index) {
        return Html.fromHtml(list.get(index).getOptionC());
    }
}
