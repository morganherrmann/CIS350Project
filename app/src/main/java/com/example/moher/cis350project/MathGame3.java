package com.example.moher.cis350project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MathGame3 extends AppCompatActivity {

    private Map<String, Integer> sampleProblems;
    private int score;
    private int index;
    private String currKey;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game3);

        sampleProblems = new HashMap<String, Integer>();

        //fill map- put in separate map
        sampleProblems.put("3 + 9", 12);
        sampleProblems.put("6 * 7", 42);
        sampleProblems.put("15 - 7", 8);
        sampleProblems.put("54 / 6", 9);
        sampleProblems.put("12 + 5", 17);

        final TextView currProblem = findViewById(R.id.problem);

        //pick a random problem
        index = rand.nextInt(sampleProblems.size());
        currKey = sampleProblems.keySet().toArray()[index].toString();
        currProblem.setText(currKey);


        Button submitAnswer = findViewById(R.id.submitAnswer);

        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView currAnswer = findViewById(R.id.answer);

                int answer = Integer.parseInt(currAnswer.getText().toString());

                //check if answer is correct
                if (answer == sampleProblems.get(currKey)) {
                    //if correct, increment score, display correct toast
                    score++;

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Correct!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, -190);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.GREEN);

                    toast.show();

                    //pick next random problem (different from curr problem)
                    int prevIndex = index;
                    while(index == prevIndex) {
                        index = rand.nextInt(sampleProblems.size());
                    }
                    currKey = sampleProblems.keySet().toArray()[index].toString();
                    currProblem.setText(currKey);
                }

                //if incorrect, display incorrect toast
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Try again", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, -190);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.RED);

                    toast.show();
                }
                currAnswer.setText("");
            }

        });

    }
}
