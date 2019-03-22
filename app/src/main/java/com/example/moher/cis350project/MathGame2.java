package com.example.moher.cis350project;

import android.graphics.Color;
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


//solve math problems represented with pictures
public class MathGame2 extends AppCompatActivity {
    private Map<Integer, Integer> problemAnswers;
    private Set<String> operators;
    private int currKeyL;
    private int currKeyR;
    private String currOp;
    private int score;
    private int index;
    private int indexL;
    private int indexR;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game2);

        problemAnswers = new HashMap<Integer, Integer>();
        operators = new HashSet<String>();

        //fill maps of images, answers, and questions
        problemAnswers.put(R.drawable.puppies, 4);
        problemAnswers.put(R.drawable.oranges, 4);
        problemAnswers.put(R.drawable.apples, 3);
        problemAnswers.put(R.drawable.flowers, 7);
        problemAnswers.put(R.drawable.cars, 5);
        problemAnswers.put(R.drawable.ducks, 5);

        //fill set of operators
        operators.add(" + ");
        operators.add(" - ");
        operators.add(" * ");



        //pick random images to start
        indexL = rand.nextInt(problemAnswers.size());
        currKeyL = Integer.parseInt(problemAnswers.keySet().toArray()[indexL].toString());

        indexR = rand.nextInt(problemAnswers.size());
        currKeyR = Integer.parseInt(problemAnswers.keySet().toArray()[indexR].toString());

        final ImageView currImageL = findViewById(R.id.imgL);
        currImageL.setImageResource(currKeyL);
        final ImageView currImageR = findViewById(R.id.imgR);
        currImageR.setImageResource(currKeyR);


        //pick a random operator
        index = rand.nextInt(operators.size());
        final TextView currOperator = findViewById(R.id.operator);
        currOp = operators.toArray()[index].toString();
        currOperator.setText(currOp);


        Button submitAnswer = findViewById(R.id.submitAnswer);
        submitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView currAnswer = findViewById(R.id.answer);

                int answer = Integer.parseInt(currAnswer.getText().toString());

                boolean correct = false;

                //check if answer is correct
                //if addition
                if (currOp.equals(" + ")) {
                    if (answer == problemAnswers.get(currKeyL) + problemAnswers.get(currKeyR)) {
                        correct = true;
                    }
                }
                //if subtraction
                else if (currOp.equals(" - ")) {
                    if (answer == problemAnswers.get(currKeyL) - problemAnswers.get(currKeyR)) {
                        correct = true;
                    }
                }
                //if multiplication
                else if (currOp.equals(" * ")) {
                    if (answer == problemAnswers.get(currKeyL) * problemAnswers.get(currKeyR)) {
                        correct = true;
                    }
                }


                if(correct)  {

                    //if correct, increment score, display correct toast
                    score++;

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Correct!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 80);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.GREEN);

                    toast.show();



                    indexL = rand.nextInt(problemAnswers.size());
                    indexR = rand.nextInt(problemAnswers.size());
                    currKeyL = Integer.parseInt(problemAnswers.keySet().toArray()[indexL].toString());
                    currKeyR = Integer.parseInt(problemAnswers.keySet().toArray()[indexR].toString());

                    currImageL.setImageResource(currKeyL);
                    currImageR.setImageResource(currKeyR);

                    //pick a random operator
                    index = rand.nextInt(operators.size());
                    final TextView currOperator = findViewById(R.id.operator);
                    currOp = operators.toArray()[index].toString();

                    currOperator.setText(currOp);


                }

                //if incorrect, display incorrect toast
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Try again", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 80);
                    View toastView = toast.getView();
                    toastView.setBackgroundColor(Color.RED);

                    toast.show();
                }

                currAnswer.setText("");
            }
        });
    }

}
