package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> familyList = new ArrayList<Word>();

        familyList.add(new Word(R.drawable.family_father,"Father","әpә",R.raw.family_father));
        familyList.add(new Word(R.drawable.family_mother,"Mother","әṭa",R.raw.family_mother));
        familyList.add(new Word(R.drawable.family_son,"Son","Angsi",R.raw.family_son));
        familyList.add(new Word(R.drawable.family_daughter,"Daughter","Tune",R.raw.family_daughter));
        familyList.add(new Word(R.drawable.family_older_brother,"Older Brother","Taachi",R.raw.family_older_brother));
        familyList.add(new Word(R.drawable.family_younger_brother,"Younger Brother","Chalitti",R.raw.family_younger_brother));
        familyList.add(new Word(R.drawable.family_older_sister,"Older Sister","Tete",R.raw.family_older_sister));
        familyList.add(new Word(R.drawable.family_younger_sister,"Younger Sister","Kolliti",R.raw.family_younger_sister));
        familyList.add(new Word(R.drawable.family_grandmother,"Grandmother","Ama",R.raw.family_grandmother));
        familyList.add(new Word(R.drawable.family_grandfather,"Grandfather","Paapa",R.raw.family_grandfather));


        WordAdapter familyAdapter = new WordAdapter(this,familyList,R.color.category_family);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(familyAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = familyList.get(position);

                Toast toast = Toast.makeText(FamilyActivity.this, word.getDefaultTranslation(),Toast.LENGTH_SHORT);
                toast.show();


                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getAudioFile());
                mMediaPlayer.start();
            }
        });

    }
}
