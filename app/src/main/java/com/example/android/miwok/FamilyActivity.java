package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> familyList = new ArrayList<Word>();

        familyList.add(new Word("Father","әpә"));
        familyList.add(new Word("Mother","әṭa"));
        familyList.add(new Word("Son","Angsi"));
        familyList.add(new Word("Daughter","Tune"));
        familyList.add(new Word("Older Brother","Taachi"));
        familyList.add(new Word("Younger Brother","Chalitti"));
        familyList.add(new Word("Older Sister","Tete"));
        familyList.add(new Word("Younger Sister","Kolliti"));
        familyList.add(new Word("Grandmother","Ama"));
        familyList.add(new Word("Grandfather","Paapa"));


        WordAdapter familyAdapter = new WordAdapter(this,familyList);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(familyAdapter);

    }
}
