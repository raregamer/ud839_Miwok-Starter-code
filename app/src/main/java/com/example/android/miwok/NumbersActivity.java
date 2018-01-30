package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words,"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten");


        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.list_item,words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




        for (int i = 0; i < words.size();i++) {

            Log.v("NumbersActivity", "Words at index " + i + " " + words.get(i));

        }
    }
}
