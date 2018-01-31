package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
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
        setContentView(R.layout.activity_family);
        ArrayList<String> familyList = new ArrayList<String>();

        Collections.addAll(familyList,"Mother","Brother");
        familyList.add("Father");
        familyList.add("Sister");

        ArrayAdapter<String> familyAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,familyList);

        Spinner list = (Spinner) findViewById(R.id.list_family);

        list.setAdapter(familyAdapter);

    }
}
