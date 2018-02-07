package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
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

        final ArrayList<Word> numberWords = new ArrayList<Word>();

        numberWords.add(new Word(R.drawable.number_one,"One","Lutti",R.raw.number_one));
        numberWords.add(new Word(R.drawable.number_two,"Two","Otiiko",R.raw.number_two));
        numberWords.add(new Word(R.drawable.number_three,"Three","Tolookosu",R.raw.number_three));
        numberWords.add(new Word(R.drawable.number_four,"Four","Oyyisa",R.raw.number_four));
        numberWords.add(new Word(R.drawable.number_five,"Five","Massokka",R.raw.number_five));
        numberWords.add(new Word(R.drawable.number_six,"Six","Temmokka",R.raw.number_six));
        numberWords.add(new Word(R.drawable.number_seven,"Seven","Kenekaku",R.raw.number_seven));
        numberWords.add(new Word(R.drawable.number_eight,"Eight","Kawinta",R.raw.number_eight));
        numberWords.add(new Word(R.drawable.number_nine,"Nine","Wo'e",R.raw.number_nine));
        numberWords.add(new Word(R.drawable.number_ten,"Ten","Na'aacha",R.raw.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this, numberWords,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word wordClicked = numberWords.get(i);

                int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback

                    Toast.makeText(NumbersActivity.this, wordClicked.getDefaultTranslation(), Toast.LENGTH_SHORT).show();
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, wordClicked.getAudioFile());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });






        for (int i = 0; i < numberWords.size();i++) {

            Log.v("NumbersActivity", "Words at index " + i + " " + numberWords.get(i));

        }
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
