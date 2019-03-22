package com.example.moher.cis350project;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MinuteMath extends AppCompatActivity  {
    public int counter;
    Button button;
    Button checkAnswer;
    TextView textView;
    boolean done = false;
    TextView problem;
    Iterator it;


    HashMap<String, Integer> problems = new HashMap<>();
    Map.Entry curr_problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minute_math);
        button= findViewById(R.id.button);
        textView= findViewById(R.id.textView);
        problem = findViewById(R.id.mathProb);



        checkAnswer = findViewById(R.id.checkAnswer);

        problems.put("10 + 2", 12);
        problems.put("12 - 3", 9);
        problems.put("9 + 7", 16);
        problems.put("7 + 14", 21);
        problems.put("3 + 8", 11);
        problems.put("9 + 10", 19);
        problems.put("3 + 4", 7);
        problems.put("30 - 15", 15);
        problems.put("17 - 7", 10);
        problems.put("12 + 16", 18);
        problems.put("17 + 5", 22);

        it = problems.entrySet().iterator();
        curr_problem = (Map.Entry)it.next();


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                problem.setText(curr_problem.getKey().toString());

                new CountDownTimer(30000, 1000){
                    public void onTick(long millisUntilFinished){
                        textView.setText(String.valueOf(counter));
                        counter++;
                    }
                    public void onFinish(){
                        textView.setText("TIME IS UP!!");
                        done = true;
                    }
                }.start();
            }
        });

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView solut = findViewById(R.id.solution);
                String num = solut.getText().toString();
                int ans = Integer.parseInt(num);

                if (ans == (int) curr_problem.getValue()){
                    Toast toast = Toast.makeText(getApplicationContext(), "CORRECT!", Toast.LENGTH_SHORT);
                    toast.show();
                    curr_problem = (Map.Entry) it.next();
                    problem.setText(curr_problem.getKey().toString());
                    solut.setText("");
                } else {
                    solut.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), "TRY AGAIN", Toast.LENGTH_SHORT);
                    toast.show();

                }

            }

        });
    }
}
