package com.example.moher.cis350project;

/**
 * Created by Angel on 3/20/2019.
 */
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ReadingGame4 extends AppCompatActivity{
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

    final int[] count = {0};
    final int[] score = {0};

    ArrayList<Integer> order;

    ImageView image;
    ImageView submit;
    EditText word;

    TextView gameResults;
    Button playAgain;
    Button goBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_game_level4);

        image = (ImageView)findViewById(R.id.imageOfWord);
        submit = (ImageView)findViewById(R.id.submit);
        word = (EditText) findViewById(R.id.word_writing);

        gameResults = (TextView)findViewById(R.id.gameResults);
        playAgain = (Button)findViewById(R.id.playAgain);
        goBack = (Button)findViewById(R.id.goBack);

        order = new ArrayList<>();
        for (int i = 0; i < recordings.length; i++) {
            order.add(i);
        }

        Collections.shuffle(order);

        nextWord();

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!word.getText().toString().toLowerCase().equals(words[order.get(count[0])].toLowerCase())) {
                    Toast.makeText(view.getContext(), "Sorry! That's incorrect. Try again!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(view.getContext(), "That's right!", Toast.LENGTH_SHORT).show();
                    score[0]++;
                    count[0]++;
                    word.setText("");
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

        final MediaPlayer recording = MediaPlayer.create(ReadingGame4.this, recordings[order.get(count[0])]);

        image.setImageDrawable(getResources().getDrawable(images[order.get(count[0])]));

        image.setOnClickListener(new View.OnClickListener() {
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
