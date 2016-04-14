package com.quizmagic.qmas;

import android.content.res.Resources;

/**
 * Created by student on 2016/4/14.
 */
public class QuestionAdapterFactory { // 轉接器工廠
    // 靜態成員
    private static QuestionAdapter adapter;

    public static QuestionAdapter getQuestionAdapter(){
        if(adapter == null){
            // 透過 MyApp 取得 Context，進一步取得 Resources
            Resources res = MyApp.getContext().getResources();
            adapter = new QuestionFromStringResource(res);
        }
        return adapter;
    }

    private QuestionAdapterFactory(){
        //產生轉接器
    }
}
