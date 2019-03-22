package com.example.moher.cis350project;

/**
 * Created by Angel on 3/20/2019.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ReadingGameMain extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_game_main);

        Button level1 = findViewById(R.id.reading_level1);
        Button level2 = findViewById(R.id.reading_level2);
        Button level3 = findViewById(R.id.reading_level3);
        Button level4 = findViewById(R.id.reading_level4);
        Button mainMenu = findViewById(R.id.mainmenu);

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingGameMain.this, ReadingGame1.class);
                startActivity(intent);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingGameMain.this, ReadingGame2.class);
                startActivity(intent);
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingGameMain.this, ReadingGame3.class);
                startActivity(intent);
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingGameMain.this, ReadingGame4.class);
                startActivity(intent);
            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReadingGameMain.this, StudentHome.class);
                startActivity(intent);
            }
        });
    }
}
