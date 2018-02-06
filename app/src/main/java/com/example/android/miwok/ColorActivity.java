package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word(R.drawable.color_red,"Red","Weṭeṭṭi",R.raw.color_red));
        colorWords.add(new Word(R.drawable.color_green,"Green","Chokokki",R.raw.color_green));
        colorWords.add(new Word(R.drawable.color_brown,"Brown","ṭakaakki",R.raw.color_brown));
        colorWords.add(new Word(R.drawable.color_gray,"Gray","ṭopoppi",R.raw.color_gray));
        colorWords.add(new Word(R.drawable.color_black,"Black","Kululli",R.raw.color_black));
        colorWords.add(new Word(R.drawable.color_white,"White","Kelelli",R.raw.color_white));
        colorWords.add(new Word(R.drawable.color_dusty_yellow,"Dusty Yellow","ṭopiisә",R.raw.color_dusty_yellow));
        colorWords.add(new Word(R.drawable.color_mustard_yellow,"Mustard Yellow","Chiwiiṭә",R.raw.color_mustard_yellow));

        WordAdapter colorAdapter = new WordAdapter(this,colorWords,R.color.category_colors);

        ListView colorList = (ListView) findViewById(R.id.list);

        colorList.setAdapter(colorAdapter);

        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Word word = colorWords.get(position);
                Toast.makeText(ColorActivity.this,word.getDefaultTranslation(),Toast.LENGTH_SHORT).show();

                mMediaPlayer = MediaPlayer.create(ColorActivity.this,word.getAudioFile());
                mMediaPlayer.start();

            }
        });



    }
}
