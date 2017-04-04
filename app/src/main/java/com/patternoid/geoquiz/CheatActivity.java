package com.patternoid.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.patternoid.geoquiz.answer_is_true";

    private boolean mAnswerIsTrue;

    private TextView mAsnwerTextView;
    private Button   mShowAnswer;



    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = new Intent( packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue );
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAsnwerTextView = (TextView)findViewById(R.id.answer_text_view);

        mShowAnswer = (Button)findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( mAnswerIsTrue ){
                    mAsnwerTextView.setText(R.string.true_button);
                }else{
                    mAsnwerTextView.setText(R.string.false_button);
                }
            }
        });
    }




}
