package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener mCompletionListener =  new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

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


        final ArrayList<Word> colorWords = new ArrayList<Word>();

        colorWords.add(new Word(R.drawable.color_red,"Red","Weṭeṭṭi",R.raw.color_red));
        colorWords.add(new Word(R.drawable.color_green,"Green","Chokokki",R.raw.color_green));
        colorWords.add(new Word(R.drawable.color_brown,"Brown","ṭakaakki",R.raw.color_brown));
        colorWords.add(new Word(R.drawable.color_gray,"Gray","ṭopoppi",R.raw.color_gray));
        colorWords.add(new Word(R.drawable.color_black,"Black","Kululli",R.raw.color_black));
        colorWords.add(new Word(R.drawable.color_white,"White","Kelelli",R.raw.color_white));
        colorWords.add(new Word(R.drawable.color_dusty_yellow,"Dusty Yellow","ṭopiisә",R.raw.color_dusty_yellow));
        colorWords.add(new Word(R.drawable.color_mustard_yellow,"Mustard Yellow","Chiwiiṭә",R.raw.color_mustard_yellow));

        WordAdapter colorAdapter = new WordAdapter(this,colorWords,R.color.category_colors);

        ListView colorList = (ListView) findViewById(R.id.list);

        colorList.setAdapter(colorAdapter);

        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();

                Word word = colorWords.get(position);

                int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    Toast.makeText(ColorActivity.this, word.getDefaultTranslation(), Toast.LENGTH_SHORT).show();

                    mMediaPlayer = MediaPlayer.create(ColorActivity.this, word.getAudioFile());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
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

            mAudioManager.abandonAudioFocus(audioFocusChangeListener);

        }
    }

    //AudioFocusListener
   private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange ==
                    AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ) {
                // Pause playback because your Audio Focus was
                mMediaPlayer.pause();
                // temporarily stolen, but will be back soon.
                // i.e. for a phone call
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Stop playback, because you lost the Audio Focus.
                // i.e. the user started some other playback app
                // Remember to unregister your controls/buttons here.
                // And release the kra — Audio Focus!
                // You’re done.
                releaseMediaPlayer();

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume playback, because you hold the Audio Focus
                // again!
                // i.e. the phone call ended or the nav directions
                // are finished
                // If you implement ducking and lower the volume, be
                // sure to return it to normal here, as well.
                mMediaPlayer.start();
            }

        }
    };

}
