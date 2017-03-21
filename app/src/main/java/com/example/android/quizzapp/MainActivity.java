package com.example.android.quizzapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleText = (TextView)findViewById(R.id.quiz_title);
        Typeface title_font = Typeface.createFromAsset(getAssets(),  "fonts/Oregon-LDO-Bold.ttf");
        titleText.setTypeface(title_font);
    }
}
