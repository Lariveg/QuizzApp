package com.example.android.quizzapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

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
    }

}
