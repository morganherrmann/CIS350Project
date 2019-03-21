package com.example.moher.cis350project;

/**
 * Created by Angel on 3/20/2019.
 */
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ReadingGame1 extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_game_level1);

        // loads imageview with the animation
        ImageView img = (ImageView)findViewById(R.id.alphabet_song);
        img.setBackgroundResource(R.drawable.alphabet_song_animation);

        // gets the background to be animated
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        MediaPlayer ring= MediaPlayer.create(ReadingGame1.this,R.raw.alphabet_song);
        ring.start();
        // start the animation
        frameAnimation.start();
    }

}
