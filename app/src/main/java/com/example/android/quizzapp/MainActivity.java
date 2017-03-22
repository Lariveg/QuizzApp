package com.example.android.quizzapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int currentQuestion = 0;
    CardView cardQuestion1;
    CardView cardQuestion2;
    CardView cardQuestion3;
    CardView cardQuestion4;
    CardView cardQuestion5;
    CardView cardQuestion6;
    CardView cardQuestion7;
    CardView[] cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleText = (TextView)findViewById(R.id.quiz_title);
        Typeface title_font = Typeface.createFromAsset(getAssets(),  "fonts/Princess-and-the-frog.ttf");
        titleText.setTypeface(title_font);

        cardQuestion1 = (CardView) findViewById(R.id.cardViewQuestion1);
        cardQuestion2 = (CardView) findViewById(R.id.cardViewQuestion2);
        cardQuestion3 = (CardView) findViewById(R.id.cardViewQuestion3);
        cardQuestion4 = (CardView) findViewById(R.id.cardViewQuestion4);
        cardQuestion5 = (CardView) findViewById(R.id.cardViewQuestion5);
        cardQuestion6 = (CardView) findViewById(R.id.cardViewQuestion6);
        cardQuestion7 = (CardView) findViewById(R.id.cardViewQuestion7);
        cards = new CardView[]{cardQuestion1, cardQuestion2, cardQuestion3, cardQuestion4, cardQuestion5, cardQuestion6, cardQuestion7};

//      Make the card-questions invisible at the start, except for the first one
        for(int i = 1; i < 7; i++){
            cards[i].setVisibility(View.GONE);
        }

    }

    /**
     * Show next Card/Question.
     */
    public void nextQuestionBtn(View v) {
        cards[currentQuestion].setVisibility(View.GONE);
        currentQuestion+= 1;
        cards[currentQuestion].setVisibility(View.VISIBLE);
    }

    /**
     * Show previous Card/Question.
     */
    public void previousQuestionBtn(View v) {
        cards[currentQuestion].setVisibility(View.GONE);
        currentQuestion-= 1;
        cards[currentQuestion].setVisibility(View.VISIBLE);
    }

    /**
     * Show the score.
     */
    public void getScoreBtn(View v) {
        calculateScore();
        Toast.makeText(this, "Your score is " + score + " out of 7", Toast.LENGTH_SHORT).show();
    }

    /**
     * Calculate the score.
     */
    private void calculateScore() {
        score = 0;
        checkAnswer1();
        checkAnswer2();
        checkAnswer3();
        checkAnswer4();
        checkAnswer5();
        checkAnswer6();
        checkAnswer7();
    }

    /**
     * Check answer for question 1
     */
    private void checkAnswer1() {
        EditText a1EditText = (EditText) findViewById(R.id.a1);
        if (a1EditText.getText().toString().equals(getString(R.string.a1_editText))) {
            score += 1;
        }
    }
    /**
     * Check answer for question 2
     */
    private void checkAnswer2() {
        CheckBox a2CheckBoxA = (CheckBox) findViewById(R.id.a2_a_checkbox);
        CheckBox a2CheckBoxC = (CheckBox) findViewById(R.id.a2_c_checkbox);
        CheckBox a2CheckBoxB = (CheckBox) findViewById(R.id.a2_b_checkbox);
        CheckBox a2CheckBoxD = (CheckBox) findViewById(R.id.a2_d_checkbox);
        if(a2CheckBoxA.isChecked() && a2CheckBoxC.isChecked() && !a2CheckBoxB.isChecked() && !a2CheckBoxD.isChecked()){
            score += 1;
        }
    }

    /**
     * Check answer for question 3
     */
    private void checkAnswer3() {
        CheckBox a3CheckBoxA = (CheckBox) findViewById(R.id.a3_a_checkbox);
        CheckBox a3CheckBoxC = (CheckBox) findViewById(R.id.a3_c_checkbox);
        CheckBox a3CheckBoxB = (CheckBox) findViewById(R.id.a3_b_checkbox);
        CheckBox a3CheckBoxD = (CheckBox) findViewById(R.id.a3_d_checkbox);
        if(!a3CheckBoxA.isChecked() && a3CheckBoxC.isChecked() && a3CheckBoxB.isChecked() && !a3CheckBoxD.isChecked()){
            score += 1;
        }
    }

    /**
     * Check answer for question 4
     */
    private void checkAnswer4() {
        RadioButton a4RadioButtonD = (RadioButton) findViewById(R.id.a4_d_radio_button);
        if(a4RadioButtonD.isChecked()){
            score += 1;
        }
    }

    /**
     * Check answer for question 5
     */
    private void checkAnswer5() {
        RadioButton a5RadioButtonA = (RadioButton) findViewById(R.id.a5_a_radio_button);
        if(a5RadioButtonA.isChecked()){
            score += 1;
        }
    }

    /**
     * Check answer for question 6
     */
    private void checkAnswer6() {
        RadioButton a6RadioButtonB = (RadioButton) findViewById(R.id.a6_b_radio_button);
        if(a6RadioButtonB.isChecked()){
            score += 1;
        }
    }

    /**
     * Check answer for question 7
     */
    private void checkAnswer7() {
        EditText a7EditText = (EditText) findViewById(R.id.a7);
        if (a7EditText.getText().toString().equals(getString(R.string.a7_editText))) {
            score += 1;
        }
    }
}
