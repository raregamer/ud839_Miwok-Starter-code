package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word("Red","Weṭeṭṭi"));
        colorWords.add(new Word("Green","Chokokki"));
        colorWords.add(new Word("Brown","ṭakaakki"));
        colorWords.add(new Word("Gray","ṭopoppi"));
        colorWords.add(new Word("Black","Kululli"));
        colorWords.add(new Word("White","Kelelli"));
        colorWords.add(new Word("Dusty Yellow","ṭopiisә"));
        colorWords.add(new Word("Mustard Yellow","Chiwiiṭә"));

        WordAdapter colorAdapter = new WordAdapter(this,colorWords);

        ListView colorList = (ListView) findViewById(R.id.list);

        colorList.setAdapter(colorAdapter);

    }
}
