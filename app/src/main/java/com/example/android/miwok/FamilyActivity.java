package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> familyList = new ArrayList<Word>();

        familyList.add(new Word(R.drawable.family_father,"Father","әpә",R.raw.family_father));
        familyList.add(new Word(R.drawable.family_mother,"Mother","әṭa",R.raw.family_mother));
        familyList.add(new Word(R.drawable.family_son,"Son","Angsi",R.raw.family_son));
        familyList.add(new Word(R.drawable.family_daughter,"Daughter","Tune",R.raw.family_daughter));
        familyList.add(new Word(R.drawable.family_older_brother,"Older Brother","Taachi",R.raw.family_older_brother));
        familyList.add(new Word(R.drawable.family_younger_brother,"Younger Brother","Chalitti",R.raw.family_younger_brother));
        familyList.add(new Word(R.drawable.family_older_sister,"Older Sister","Tete",R.raw.family_older_sister));
        familyList.add(new Word(R.drawable.family_younger_sister,"Younger Sister","Kolliti",R.raw.family_younger_sister));
        familyList.add(new Word(R.drawable.family_grandmother,"Grandmother","Ama",R.raw.family_grandmother));
        familyList.add(new Word(R.drawable.family_grandfather,"Grandfather","Paapa",R.raw.family_grandfather));


        WordAdapter familyAdapter = new WordAdapter(this,familyList,R.color.category_family);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(familyAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                releaseMediaPlayer();

                Word word = familyList.get(position);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    Toast.makeText(FamilyActivity.this, word.getDefaultTranslation(), Toast.LENGTH_SHORT).show();
                    //create media player
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioFile());
                    //start media player
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }

                    });

                }

                }
//            }
        });



    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
                        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);


        }
    }

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };



}


