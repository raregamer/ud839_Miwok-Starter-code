package com.example.android.miwok;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Samuel on 1/30/2018.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageWordIconResource = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    //Constructor to make word.
    public Word(String defaultTranslation, String miwokTranslation){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    //Constructor to make a word with image.

        public Word(int imageResourceID, String defaultTranslation, String miwokTranslation){

            this.mDefaultTranslation = defaultTranslation;
            this.mMiwokTranslation = miwokTranslation;
            this.mImageWordIconResource = imageResourceID;

        }

    //getter for default translation of word(native language i.e(ENGLISH)
    public String getDefaultTranslation() {

        return mDefaultTranslation;

    }

    //Getter for the Miwok word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //Getter for image icon in word.

    public int getImageWordIcon() {
            return mImageWordIconResource;
    }

    public boolean hasImage(){
            return mImageWordIconResource != NO_IMAGE_PROVIDED;
    }


}
