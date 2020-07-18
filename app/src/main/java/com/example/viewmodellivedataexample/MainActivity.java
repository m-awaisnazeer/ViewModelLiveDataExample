package com.example.viewmodellivedataexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView score;
    Button addScore, reset_Score;

    ScoreViewModel scoreViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
                            /* ****Live Data **** */
        scoreViewModel.getScoreLive().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                score.setText(String.valueOf(integer));
            }
        });

        score = findViewById(R.id.score);
        addScore = findViewById(R.id.addScore);
        reset_Score = findViewById(R.id.reset_Score);

//        score.setText(String.valueOf(scoreViewModel.getScore())); // Without Live Data
        reset_Score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        /* **** Without Live Data **** */

//                scoreViewModel.resetScore();
//                score.setText(String.valueOf(scoreViewModel.getScore()));

                        /* ****With Live Data **** */

                scoreViewModel.resetScoreLive();

            }
        });
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* **** Without Live Data **** */
//                scoreViewModel.addScore();
//                score.setText(String.valueOf(scoreViewModel.getScore()));

                /* **** With Live Data **** */
                scoreViewModel.addScoreLive();
            }
        });


    }
}