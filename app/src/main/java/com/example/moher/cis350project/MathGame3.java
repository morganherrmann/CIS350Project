package com.example.moher.cis350project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MathGame3 extends AppCompatActivity {

    private Map<String, Integer> sampleProblems;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game3);

        sampleProblems = new HashMap<String, Integer>();

        //fill map
        sampleProblems.put("3+9", 12);
        sampleProblems.put("6*7", 42);
        sampleProblems.put("15-7", 8);
        sampleProblems.put("54/6", 9);
        sampleProblems.put("12+5", 17);

        final TextView currProblem = findViewById(R.id.problem);

        //pick a random problem
        currProblem.setText("sample problem");


        Button submitAnswer = findViewById(R.id.submitAnswer);

        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView currAnswer = findViewById(R.id.answer);

                int answer = Integer.parseInt(currAnswer.getText().toString());

                //check if answer is correct
                if (answer == 5) {
                    //if correct, increment score, display correct toast
                    score++;

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Correct!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                    currProblem.setText("new problem");
                }

                //if incorrect, display incorrect toast
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Try again", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
                currAnswer.setText("");
            }

        });

    }
}
