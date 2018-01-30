package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        String [] words = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};

        Log.v("NumbersActivity","Words at index 0 " + words[0]);
        Log.v("NumbersActicity","Words at index 1 " + words[1]);

    }
}
