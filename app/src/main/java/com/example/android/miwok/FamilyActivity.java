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

        familyList.add(new Word(R.drawable.family_father,"Father","әpә"));
        familyList.add(new Word(R.drawable.family_mother,"Mother","әṭa"));
        familyList.add(new Word(R.drawable.family_son,"Son","Angsi"));
        familyList.add(new Word(R.drawable.family_daughter,"Daughter","Tune"));
        familyList.add(new Word(R.drawable.family_older_brother,"Older Brother","Taachi"));
        familyList.add(new Word(R.drawable.family_younger_brother,"Younger Brother","Chalitti"));
        familyList.add(new Word(R.drawable.family_older_sister,"Older Sister","Tete"));
        familyList.add(new Word(R.drawable.family_younger_sister,"Younger Sister","Kolliti"));
        familyList.add(new Word(R.drawable.family_grandmother,"Grandmother","Ama"));
        familyList.add(new Word(R.drawable.family_grandfather,"Grandfather","Paapa"));


        WordAdapter familyAdapter = new WordAdapter(this,familyList);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(familyAdapter);

    }
}
