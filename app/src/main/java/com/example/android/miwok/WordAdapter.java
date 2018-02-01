package com.example.android.miwok;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by samuel on 1/31/2018.
 */

public class WordAdapter extends ArrayAdapter<Word>{


    public WordAdapter(Activity context, ArrayList<Word> words) {

        super(context,0,words);

    }
@Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        //making a text view for the default language word to put in the list.
        TextView defaultLanguage = (TextView) listItemView.findViewById(R.id.translation_word);
        defaultLanguage.setText(currentWord.getDefaultTranslation());

        //making a  textView for the miwok word.
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_word);
        miwokWord.setText(currentWord.getMiwokTranslation());

        //make the image view come to life!
    ImageView wordIconImage = (ImageView) listItemView.findViewById(R.id.image_icon);
    wordIconImage.setImageResource(currentWord.getImageWordIcon());


    return listItemView;



}


}
