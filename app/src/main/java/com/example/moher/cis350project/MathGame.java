package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MathGame extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);

        Button level3 = findViewById(R.id.mathlevel3);
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGame.this, MathGame3.class);
                startActivity(intent);


            }
        });

        Button level2 = findViewById(R.id.mathlevel2);
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGame.this, MathGame2.class);
                startActivity(intent);


            }
        });

        Button level1 = findViewById(R.id.mathlevel1);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGame.this, MathGame1.class);
                startActivity(intent);


            }
        });

        Button minuteMath = findViewById(R.id.minutemath);
        minuteMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGame.this, MinuteMath.class);
                startActivity(intent);


            }
        });

        Button mainMenu = findViewById(R.id.mainmenu);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MathGame.this, StudentHome.class);
                startActivity(intent);
            }
        });


    }



}
