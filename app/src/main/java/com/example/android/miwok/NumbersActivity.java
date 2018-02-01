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

        numberWords.add(new Word(R.drawable.number_one,"One","Lutti"));
        numberWords.add(new Word(R.drawable.number_two,"Two","Otiiko"));
        numberWords.add(new Word(R.drawable.number_three,"Three","Tolookosu"));
        numberWords.add(new Word(R.drawable.number_four,"Four","Oyyisa"));
        numberWords.add(new Word(R.drawable.number_five,"Five","Massokka"));
        numberWords.add(new Word(R.drawable.number_six,"Six","Temmokka"));
        numberWords.add(new Word(R.drawable.number_seven,"Seven","Kenekaku"));
        numberWords.add(new Word(R.drawable.number_eight,"Eight","Kawinta"));
        numberWords.add(new Word(R.drawable.number_nine,"Nine","Wo'e"));
        numberWords.add(new Word(R.drawable.number_ten,"Ten","Na'aacha"));


        WordAdapter itemsAdapter = new WordAdapter(this, numberWords);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




        for (int i = 0; i < numberWords.size();i++) {

            Log.v("NumbersActivity", "Words at index " + i + " " + numberWords.get(i));

        }
    }
}
