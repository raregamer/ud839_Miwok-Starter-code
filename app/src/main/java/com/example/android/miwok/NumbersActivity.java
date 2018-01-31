package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> numberWords = new ArrayList<Word>();

        numberWords.add(new Word("One","Lutti"));
        numberWords.add(new Word("Two","Otiiko"));
        numberWords.add(new Word("Three","Tolookosu"));
        numberWords.add(new Word("Four","Oyyisa"));
        numberWords.add(new Word("Five","Massokka"));
        numberWords.add(new Word("Six","Temmokka"));
        numberWords.add(new Word("Seven","Kenekaku"));
        numberWords.add(new Word("Eight","Kawinta"));
        numberWords.add(new Word("Nine","Wo'e"));
        numberWords.add(new Word("Ten","Na'aacha"));


        WordAdapter itemsAdapter = new WordAdapter(this, numberWords);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




        for (int i = 0; i < numberWords.size();i++) {

            Log.v("NumbersActivity", "Words at index " + i + " " + numberWords.get(i));

        }
    }
}
