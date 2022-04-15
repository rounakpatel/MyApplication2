package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private TextView redScoreDevilsTextView;
    private TextView blueScoreJaysTextView;

    private int incrementBy;
    private int redDevilsScore;
    private int blueJaysScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redDevilsScore = 0;
        blueJaysScore = 0;


        RadioGroup radioGroup = findViewById(R.id.radio_group);

        redScoreDevilsTextView = findViewById(R.id.red_score_devils);
        blueScoreJaysTextView= findViewById(R.id.blue_score_jays);

        blueScoreJaysTextView.setText(Integer.toString(blueJaysScore));
        redScoreDevilsTextView.setText(Integer.toString(redDevilsScore));

        Button upButtonDevils = findViewById(R.id.buttonUp_devils);
        Button downButtonDevils = findViewById(R.id.buttonDown_devils);
        Button upButtonJays = findViewById(R.id.buttonUp_jays);
        Button downButtonJays = findViewById(R.id.buttonDown_jays);

        radioGroup.setOnCheckedChangeListener(this);
        upButtonDevils.setOnClickListener(this);
        downButtonDevils.setOnClickListener(this);
        upButtonJays.setOnClickListener(this);
        downButtonJays.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case 1:
                incrementBy = 1;
                break;
            case 2:
                incrementBy = 2;
                break;
            case 3:
                incrementBy = 3;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.buttonUp_jays:
                blueJaysScore += incrementBy;
                blueScoreJaysTextView.setText(Integer.toString(blueJaysScore));
                break;
            case R.id.buttonDown_jays:
                blueJaysScore -= incrementBy;
                blueScoreJaysTextView.setText(Integer.toString(blueJaysScore));
                break;
            case R.id.buttonUp_devils:
                redDevilsScore += incrementBy;
                redScoreDevilsTextView.setText(Integer.toString(redDevilsScore));
                break;
            case R.id.buttonDown_devils:
                redDevilsScore -= incrementBy;
                redScoreDevilsTextView.setText(Integer.toString(redDevilsScore));
                break;
        }
    }
}