package com.example.moher.cis350project;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


//learn numbers by matching pictures to numbers
public class MathGame1 extends AppCompatActivity {
    private int score;
    private Map<Integer, Integer> problemAnswers;
    private Map<Integer, String> problemQuestions;
    private int currKey;
    private int index;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game1);

        problemAnswers = new HashMap<Integer, Integer>();
        problemQuestions = new HashMap<Integer, String>();


        //fill maps of images, answers, and questions
        problemAnswers.put(R.drawable.puppies, 4);
        problemQuestions.put(R.drawable.puppies, "puppies");
        problemAnswers.put(R.drawable.oranges, 4);
        problemQuestions.put(R.drawable.oranges, "oranges");
        problemAnswers.put(R.drawable.apples, 3);
        problemQuestions.put(R.drawable.apples, "apples");
        problemAnswers.put(R.drawable.flowers, 7);
        problemQuestions.put(R.drawable.flowers, "flowers");
        problemAnswers.put(R.drawable.cars, 5);
        problemQuestions.put(R.drawable.cars, "cars");
        problemAnswers.put(R.drawable.ducks, 5);
        problemQuestions.put(R.drawable.ducks, "ducks");



        //pick random problem to start
        index = rand.nextInt(problemAnswers.size());

        currKey = Integer.parseInt(problemAnswers.keySet().toArray()[index].toString());


        final ImageView currImage = findViewById(R.id.myimage);
        currImage.setImageResource(currKey);

        final TextView currProblem = findViewById(R.id.problem);
        currProblem.setText("How many " + problemQuestions.get(currKey).toString() + " are there?");


        Button submitAnswer = findViewById(R.id.submitAnswer);
        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView currAnswer = findViewById(R.id.answer);

                int answer = Integer.parseInt(currAnswer.getText().toString());

                //check if answer is correct
                if (answer == problemAnswers.get(currKey)) {
                    //if correct, increment score, display correct toast
                    score++;

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Correct!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 400);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.GREEN);

                    toast.show();

                    index = rand.nextInt(problemAnswers.size());
                    currKey = Integer.parseInt(problemAnswers.keySet().toArray()[index].toString());


                    currImage.setImageResource(currKey);
                    currProblem.setText("How many " + problemQuestions.get(currKey).toString() + " are there?");

                }

                //if incorrect, display incorrect toast
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Try again", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 400);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.RED);

                    toast.show();
                }

                currAnswer.setText("");
            }
        });


    }
}
