package com.example.android.miwok;

/**
 * Created by Samuel on 1/30/2018.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    //Constructor to make word.
    public Word(String defaultTranslation, String miwokTranslation){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }
    //getter for default translation of word(native language i.e(ENGLISH)
    public String getDefaultTranslation() {

        return mDefaultTranslation;

    }

    //Getter for the Miwok word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }


}
