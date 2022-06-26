package com.example.eggtimerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar timerSeekBar;
    public void ButtonClick(View view){
        CountDownTimer countDownTimer = new CountDownTimer(timerSeekBar.getProgress()*1000 ,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
//                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                MediaPlayer mediaPlayer = (MediaPlayer) MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                mediaPlayer.start();
//                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
    public void updateTimer(int secondLeft){
        int minute = secondLeft/60;
        int seconds = secondLeft - (minute*60);
        textView.setText(Integer.toString(minute)+":"+Integer.toString(seconds));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         timerSeekBar = (SeekBar) findViewById(R.id.seekBar);
         textView = (TextView) findViewById(R.id.textView);
        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {

                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}