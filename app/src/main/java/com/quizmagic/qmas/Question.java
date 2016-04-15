package com.quizmagic.qmas;

import android.graphics.drawable.Drawable;

public class Question {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private Drawable picture;

    public Question(String question,
                    String optionA,
                    String optionB,
                    String optionC,
                    Drawable picture){
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.picture = picture;
    }

    public String getQuestion(){return question;}

    public String getOptionA(){return optionA;}

    public String getOptionB(){return optionB;}

    public String getOptionC(){return optionC;}

    public Drawable getPicture(){return picture;}
}

