package com.example.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.NameListView);
        ArrayList <String> nameList = new ArrayList<String>();
        nameList.add("Sidduiqui");
        nameList.add("Umar");
        nameList.add("Osman");
        nameList.add("Ali");
        nameList.add("Bin AbdulAziz");
        nameList.add("Muavia");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nameList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public  void onItemClick(AdapterView<?> adapterView, View view,int i, long l){
                Log.i("name",nameList.get(i));
                Toast.makeText(MainActivity.this, nameList.get(i).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}