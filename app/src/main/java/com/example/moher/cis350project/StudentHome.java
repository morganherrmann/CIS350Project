package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        Intent current = getIntent();
        String username = current.getStringExtra("name");

        TextView welcome = findViewById(R.id.welcome);

        welcome.setText("Welcome " + username + "!");

        Button math = findViewById(R.id.doMath);
        Button reading = findViewById(R.id.doReading);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentHome.this, MathGame.class);
                startActivity(intent);

            }

        });

        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentHome.this, ReadingGameMain.class);
                startActivity(intent);

            }

        });



    }
}
