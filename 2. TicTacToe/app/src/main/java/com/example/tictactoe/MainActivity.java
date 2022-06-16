package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
//import android.widget.GridLayout;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    0: Yellow, 1: Red, 2:empty
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions =  {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer = 0;
    String winner = "";
    int round = 0;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        TextView textWinner = (TextView) findViewById(R.id.WinnerTextView);
        Button playAgainButton = (Button) findViewById(R.id.button);
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] ==2 && winner=="") {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 1;
            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);


            round+=1;
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {


                    if (activePlayer == 1) {
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_LONG).show();
                    textWinner.setText("Congrats, "+winner+ " has won!!");
                    textWinner.setVisibility(view.VISIBLE);
                    playAgainButton.setVisibility(view.VISIBLE);

                }
            }
            if (winner=="" && round==9){
                textWinner.setText("OOps, Match drawn!!");
                textWinner.setVisibility(view.VISIBLE);
                playAgainButton.setVisibility(view.VISIBLE);

            }
        }


    }
    public void PlayAgainGame(View view){
        TextView textWinner = (TextView) findViewById(R.id.WinnerTextView);
        Button playAgainButton = (Button) findViewById(R.id.button);
        round = 0;
        GridLayout myGridView = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i < myGridView.getChildCount(); i++) {
            ImageView imgSrc = (ImageView) myGridView.getChildAt(i);
            imgSrc.setImageDrawable(null);
            // do stuff with child view
        }
        for(int i=0;i<gameState.length; i++){
            gameState[i] = 2;
        }
        activePlayer = 0;
        winner = "";

        textWinner.setVisibility(view.INVISIBLE);
        playAgainButton.setVisibility(view.INVISIBLE);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}