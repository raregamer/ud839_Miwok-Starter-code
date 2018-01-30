package com.example.android.miwok;

/**
 * Created by Samuel on 1/30/2018.
 */

public class Word {

    private String defaultTranslation;
    private String miwokTranslation;

    //Constructor to make word.
    public Word(String defaultTranslation, String miwokTranslation){
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }
    //getter for default translation of word(native language i.e(ENGLISH)
    public String getDefaultTranslation() {

        return defaultTranslation;

    }

    //Getter for the Miwok word
    public String getMiwokTranslation() {
        return miwokTranslation;
    }


}
