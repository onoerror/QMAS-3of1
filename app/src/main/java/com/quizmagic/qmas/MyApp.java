package com.quizmagic.qmas;

import android.app.Application;
import android.content.Context;

/**
 * Created by student on 2016/4/14.
 */
public class MyApp extends Application{
    private static Context context;

    public static Context getContext(){return context;}

    public MyApp(){context = this;}
}
