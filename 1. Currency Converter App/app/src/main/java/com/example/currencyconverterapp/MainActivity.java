package com.example.currencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean press = false;
    public void Fade(View view){

        ImageView curr= (ImageView) findViewById(R.id.imageView);
        ImageView tree= (ImageView) findViewById(R.id.treeImageView);
        if(press == false){
            curr.animate().alpha(0).setDuration(2000);
            tree.animate().alpha(1).setDuration(2000);
            press = true;
        }
        else{
            tree.animate().alpha(0).setDuration(2000);
            curr.animate().alpha(1).setDuration(2000);
            press= false;
        }



    }

    public void ConvertFun(View view){
        EditText currency = (EditText) findViewById(R.id.editTextTextPersonName);
        String s = currency.getText().toString();
        int con = Integer.parseInt(s)*78;
        currency.setText(Integer.toString(con)+" $");
        Toast.makeText(this, Integer.toString(con), Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}