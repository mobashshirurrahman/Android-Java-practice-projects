package com.example.a5numbertableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void tableFun(int timeTableNumber){
        ArrayList<String> tableList = new ArrayList<String>();
        for(int j=1; j<=10;j++){
            tableList.add(Integer.toString(timeTableNumber) +" "+ "*"+ " "+Integer.toString(j)+" "+"="+" "+ Integer.toString( j*timeTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tableList);


        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);

        listView = (ListView) findViewById(R.id.NumberListView);
        Random random = new Random();
        int rn= random.nextInt(20 - 1) + 1;
        tableFun(rn);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timeTableNumber;
                if (progress<min){
                    timeTableNumber = min;
                    seekBar.setProgress(min);
                }else {
                    timeTableNumber = progress;
                }
                tableFun(timeTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                Toast.makeText(MainActivity.this, nameList.get(i).toString(), Toast.LENGTH_LONG).show();
//            }
//        });


    }

}