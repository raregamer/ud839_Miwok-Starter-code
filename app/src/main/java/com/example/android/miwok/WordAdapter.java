package com.example.android.miwok;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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

    private int mColorResourceID;


    public WordAdapter(Activity context, ArrayList<Word> words,int color) {

        super(context,0,words);


        mColorResourceID = color;

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
        if(currentWord.hasImage()) {
            wordIconImage.setImageResource(currentWord.getImageWordIcon());
            wordIconImage.setVisibility(View.VISIBLE);
        } else {
            wordIconImage.setVisibility(View.GONE);
        }
         View wordBackgroundColor = listItemView.findViewById(R.id.word_text);

         int color = ContextCompat.getColor(getContext(),mColorResourceID);

         wordBackgroundColor.setBackgroundColor(color);

         return listItemView;



}


}
