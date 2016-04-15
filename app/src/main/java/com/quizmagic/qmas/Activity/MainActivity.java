package com.quizmagic.qmas.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.quizmagic.qmas.R;


public class MainActivity extends AppCompatActivity {

    private static final int SELECT_COLOR_REQUEST = 0;
    private static final int EDIT_TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);
    }

    public void next(View view) {
        Intent intent = new Intent(this,Activity1.class);
    }
}
