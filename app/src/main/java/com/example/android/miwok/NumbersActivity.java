package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words,"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten");

        for (int i = 0; i < words.size();i++) {

            Log.v("NumbersActivity", "Words at index " + i + " " + words.get(i));

        }
    }
}
