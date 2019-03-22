package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class LoginPage extends AppCompatActivity {

    private String username = "testUser";
    private String password = "pass";

    private HashMap<String, String> usernames = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button create = findViewById(R.id.create);
        Button student = findViewById(R.id.student);
        Button parent = findViewById(R.id.parent);
        Button math = findViewById(R.id.math);
        Button reading = findViewById(R.id.reading);
        Button minutemath = findViewById(R.id.minutemath);

        Intent current = getIntent();

        if (current.getSerializableExtra("data") != null) {

            usernames = (HashMap) current.getSerializableExtra("data");
        }



        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, CreateAccount.class);
                intent.putExtra("data", usernames);
                startActivity(intent);
            }

        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, StudentLogin.class);
                intent.putExtra("data", usernames);
                startActivity(intent);
            }

        });

        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                usernames = (HashMap) i.getSerializableExtra("data");
                Log.i("Size of usernames", " " + usernames.size());
                Intent intent = new Intent(LoginPage.this, ParentLogin.class);
                intent.putExtra("data", usernames);
                startActivity(intent);
            }

        });

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, MathGame.class);
                startActivity(intent);
            }

        });

        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, ReadingGameMain.class);
                startActivity(intent);
            }

        });

        minutemath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, MinuteMath.class);
                startActivity(intent);
            }

        });

    }


}
