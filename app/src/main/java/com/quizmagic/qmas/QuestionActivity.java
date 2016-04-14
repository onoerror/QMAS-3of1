package com.quizmagic.qmas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
// abstract activity 不需要宣告在 manifest
public abstract class QuestionActivity extends AppCompatActivity{

    private TextView m_tv_no,m_tv_question;
    private RadioButton m_radio_a,m_radio_b,m_radio_c;
    private Button m_btn_back,m_btn_next;

    private static int sLastQuestionIndex,// 上個畫面的 index
                        sQuestionIndex = 0;// 只需要一個 index，所以宣告為靜態
    // 只需要一個 adapter，所以宣告為靜態
    private static QuestionAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);//
        initQuestions();
        initBackNextButtons();
        Log.d(this.toString(),"onCreat,index ="+sQuestionIndex);
    }
    // 抑制 setVisibility() 錯誤訊息
    @SuppressWarnings("ResourceType")
    private void initBackNextButtons() {
        m_btn_back = (Button) findViewById(R.id.but_back);
        m_btn_next = (Button) findViewById(R.id.but_next);

        // 設定 Back Next 按鈕是否能看見
        // Visibility 只能設定為 View.VISIBLE / View.INVISIBLE / View.GONE
        m_btn_back.setVisibility(getBackButtonVisibility());
        m_btn_next.setVisibility(getNextButtonVisibility());
    }

    private void initQuestions() {
        m_tv_no = (TextView) findViewById(R.id.tv_no);
        m_tv_question = (TextView) findViewById(R.id.tv_question);
        m_radio_a = (RadioButton) findViewById(R.id.radio_a);
        m_radio_b = (RadioButton) findViewById(R.id.radio_b);
        m_radio_c = (RadioButton) findViewById(R.id.radio_c);


        String no = String.valueOf(sQuestionIndex+1);
        m_tv_no.setText(no);

        if(sAdapter == null){
            sAdapter = QuestionAdapterFactory.getQuestionAdapter();
        }

        m_tv_question.setText(sAdapter.getQuestion(sQuestionIndex));
        m_radio_a.setText(sAdapter.getQuestionOptionA(sQuestionIndex));
        m_radio_b.setText(sAdapter.getQuestionOptionB(sQuestionIndex));
        m_radio_c.setText(sAdapter.getQuestionOptionC(sQuestionIndex));
    }

    // 按下 BACK
    public void back(View view) {
        sLastQuestionIndex = sQuestionIndex; // 準備要切換到前一個 Activity，備份目前 index
        sQuestionIndex--;  // 1
        // 建立新 Intent: new Intent( 來源 , 目的)
        Intent intent = new Intent(this, getBackActivityClass());
        // 將先前的 Acvivity 移到最上層，而非產生新的 Activity
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        // overridePendingTransition( 進場效果 , 出場效果 )
        // overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
    }

    // 按下 NEXT
    public void next(View view) {
        sLastQuestionIndex = sQuestionIndex; // 準備要切換到前一個 Activity，備份目前 index
        sQuestionIndex++;
        // 建立新 Intent: new Intent( 來源 , 目的)
        Intent intent = new Intent(this, getNextActivityClass());
        // 將先前的 Acvivity 移到最上層，而非產生新的 Activity
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

        // overridePendingTransition( 進場效果 , 出場效果 )
        // overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    // 設定 Back 按鈕文字
    public void setBackButtonText(CharSequence text) {
        m_btn_back.setText(text);
    }

    // 設定 Next 按鈕文字
    public void setNextButtonText(CharSequence text) {
        m_btn_next.setText(text);
    }

    // 按下 RadioButton 按鈕
    public void click(View view) {

    }

    @Override
    public void onBackPressed() { // 當按下返回鍵
        return; // 直接返回不處理
    }

    @Override
    protected void onPause() { // 當畫面暫時離開
        super.onPause();
        Log.d(this.toString(), "onPause , index = " + sQuestionIndex);

    }

    @Override
    protected void onResume() { // 當畫面恢復(重現)，執行轉場動畫
        super.onResume();
        Log.d(this.toString(), "onResume , index = " + sQuestionIndex);
        if(sQuestionIndex < sLastQuestionIndex) { // 比較當前的 index 與 上個 Activity 的 index
            overridePendingTransition(R.anim.left, R.anim.right);
        } else if(sQuestionIndex > sLastQuestionIndex) {
            overridePendingTransition(R.anim.right, R.anim.left);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(this.toString(), "onDestroy , index = " + sQuestionIndex);
    }

    // 子類別實現以下功能
    protected abstract Class getBackActivityClass(); // 切換下個畫面的 Activity.class
    protected abstract Class getNextActivityClass(); // 切換上個畫面的 Activity.class
    protected abstract @Visibility int getBackButtonVisibility(); // Back 按鈕是否能被看見
    protected abstract @Visibility int getNextButtonVisibility(); // Next 按鈕是否能被看見


    // @Visibility 返回的 int 只能是 View.VISIBLE View.INVISIBLE View.GONE 其中之一
    public static final int VISIBLE = View.VISIBLE;
    public static final int INVISIBLE = View.INVISIBLE;
    public static final int GONE = View.GONE;

    @IntDef({VISIBLE, INVISIBLE, GONE})
    public @interface Visibility {
    }
}
