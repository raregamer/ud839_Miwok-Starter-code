package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word(R.drawable.color_red,"Red","Weṭeṭṭi"));
        colorWords.add(new Word(R.drawable.color_green,"Green","Chokokki"));
        colorWords.add(new Word(R.drawable.color_brown,"Brown","ṭakaakki"));
        colorWords.add(new Word(R.drawable.color_gray,"Gray","ṭopoppi"));
        colorWords.add(new Word(R.drawable.color_black,"Black","Kululli"));
        colorWords.add(new Word(R.drawable.color_white,"White","Kelelli"));
        colorWords.add(new Word(R.drawable.color_dusty_yellow,"Dusty Yellow","ṭopiisә"));
        colorWords.add(new Word(R.drawable.color_mustard_yellow,"Mustard Yellow","Chiwiiṭә"));

        WordAdapter colorAdapter = new WordAdapter(this,colorWords,R.color.category_colors);

        ListView colorList = (ListView) findViewById(R.id.list);

        colorList.setAdapter(colorAdapter);



    }
}
