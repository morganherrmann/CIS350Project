package com.example.moher.cis350project;

/**
 * Created by Angel on 3/20/2019.
 */
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ReadingGame3 extends AppCompatActivity{
    private String[] words = new String[] {
            "Apple",
            "Banana",
            "Cat",
            "Dog",
            "Egg",
            "Fan",
            "Goat",
            "Hat",
            "Igloo"
    };

    private int[] recordings = new int[] {
            R.raw.apple,
            R.raw.banana,
            R.raw.cat,
            R.raw.dog,
            R.raw.egg,
            R.raw.fan,
            R.raw.goat,
            R.raw.hat,
            R.raw.igloo
    };

    private int[] images = new int[] {
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.egg,
            R.drawable.fan,
            R.drawable.goat,
            R.drawable.hat,
            R.drawable.igloo
    };

    final boolean[] leftCorrect = {true};
    final int[] count = {0};
    final int[] score = {0};

    ArrayList<Integer> order;

    ImageView leftChoice;
    ImageView rightChoice;
    ImageView sound;
    TextView word;
    TextView gameResults;
    Button playAgain;
    Button goBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_game_level3);

        leftChoice = (ImageView)findViewById(R.id.match_image_left);
        rightChoice = (ImageView)findViewById(R.id.match_image_right);
        sound = (ImageView)findViewById(R.id.word_sound);
        word = (TextView)findViewById(R.id.word_writing);
        gameResults = (TextView)findViewById(R.id.gameResults);
        playAgain = (Button)findViewById(R.id.playAgain);
        goBack = (Button)findViewById(R.id.goBack);

        order = new ArrayList<>();
        for (int i = 0; i < recordings.length; i++) {
            order.add(i);
        }

        Collections.shuffle(order);

        nextWord();

        leftChoice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!leftCorrect[0]) {
                    //Toast.makeText(view.getContext(), "Sorry! That's incorrect. Try again!", Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Try again!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 350);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.RED);

                    toast.show();
                } else {
                    //Toast.makeText(view.getContext(), "That's right!", Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Correct!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 350);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.GREEN);

                    toast.show();
                    score[0]++;
                    count[0]++;
                    nextWord();
                }
            }
        });

        rightChoice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (leftCorrect[0]) {
                    //Toast.makeText(view.getContext(), "Sorry! That's incorrect. Try again!", Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Try again!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 350);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.RED);

                    toast.show();
                } else {
                    //Toast.makeText(view.getContext(), "That's right!", Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Correct!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 350);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.GREEN);

                    toast.show();
                    score[0]++;
                    count[0]++;
                    nextWord();
                }
            }
        });

    }

    private void nextWord() {
        if (count[0] >= recordings.length) {
            endGame();
            return;
        }
        int wrong = (int) (Math.random()*recordings.length);

        while (count[0] == wrong) {
            wrong = (int) (Math.random()*recordings.length);
        }

        final MediaPlayer recording = MediaPlayer.create(ReadingGame3.this, recordings[order.get(count[0])]);

        word.setText(words[order.get(count[0])]);

        if (Math.random() < 0.5) {
            // use left one as correct one
            leftChoice.setImageDrawable(getResources().getDrawable(images[order.get(count[0])]));
            rightChoice.setImageDrawable(getResources().getDrawable(images[order.get(wrong)]));
            leftCorrect[0] = true;
        } else {
            // use right one as correct one
            leftChoice.setImageDrawable(getResources().getDrawable(images[order.get(wrong)]));
            rightChoice.setImageDrawable(getResources().getDrawable(images[order.get(count[0])]));
            leftCorrect[0] = false;
        }

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recording.start();
            }
        });
    }

    private void endGame() {
        gameResults.setVisibility(View.VISIBLE);
        playAgain.setVisibility(View.VISIBLE);
        goBack.setVisibility(View.VISIBLE);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count[0] = 0;
                score[0] = 0;
                Collections.shuffle(order);
                gameResults.setVisibility(View.INVISIBLE);
                playAgain.setVisibility(View.INVISIBLE);
                goBack.setVisibility(View.INVISIBLE);
                nextWord();
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ReadingGameMain.class);
                startActivity(intent);
            }
        });
    }
}
