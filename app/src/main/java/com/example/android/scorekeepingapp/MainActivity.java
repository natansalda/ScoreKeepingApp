package com.example.android.scorekeepingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Tracks score for team A
     */
    int scoreTeamA = 0;

    /**
     * Tracks score for team B
     */
    int scoreTeamB = 0;

    /**
     * Tracks foul for team A
     */
    int foulTeamA = 0;

    /**
     * Tracks foul for team B
     */
    int foulTeamB = 0;

    public TextView scoreViewA;
    public TextView scoreViewB;
    public TextView scoreViewAF;
    public TextView scoreViewBF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // recovering the instance state
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("TEAM_A_SCORE");
            scoreTeamB = savedInstanceState.getInt("TEAM_B_SCORE");
            foulTeamA = savedInstanceState.getInt("TEAM_A_FOUL");
            foulTeamB = savedInstanceState.getInt("TEAM_B_FOUL");
        }

        setContentView(R.layout.activity_main);

        // initialize TextViews so we can manipulate them later
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewAF = (TextView) findViewById(R.id.team_a_fouls);
        scoreViewBF = (TextView) findViewById(R.id.team_b_fouls);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("TEAM_A_SCORE", scoreTeamA);
        outState.putInt("TEAM_B_SCORE", scoreTeamB);
        outState.putInt("TEAM_A_FOUL", foulTeamA);
        outState.putInt("TEAM_B_FOUL", foulTeamB);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        scoreViewA.setText(String.valueOf(savedInstanceState.getInt("TEAM_A_SCORE")));
        scoreViewB.setText(String.valueOf(savedInstanceState.getInt("TEAM_B_SCORE")));
        scoreViewAF.setText(String.valueOf(savedInstanceState.getInt("TEAM_A_FOUL")));
        scoreViewBF.setText(String.valueOf(savedInstanceState.getInt("TEAM_B_FOUL")));
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the fouls for Team A by 1 point.
     */
    public void addFoulForTeamA(View v) {
        foulTeamA = foulTeamA + 1;
        displayFoulsForTeamA(foulTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the fouls for Team B by 2 points.
     */
    public void addFoulForTeamB(View v) {
        foulTeamB = foulTeamB + 1;
        displayFoulsForTeamB(foulTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team A.
     */
    public void displayFoulsForTeamA(int score) {
        scoreViewAF = (TextView) findViewById(R.id.team_a_fouls);
        scoreViewAF.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(score));
    }

    /**
     * Displays the given fouls for Team B.
     */
    public void displayFoulsForTeamB(int score) {
        scoreViewBF = (TextView) findViewById(R.id.team_b_fouls);
        scoreViewBF.setText(String.valueOf(score));
    }

    public void Reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayFoulsForTeamA(foulTeamA);
        displayFoulsForTeamB(foulTeamB);
    }
}