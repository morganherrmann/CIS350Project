package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class StudentLogin extends AppCompatActivity {

    private HashMap<String, String> usernames = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);






        Button login = findViewById(R.id.studentLogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentLogin.this, StudentHome.class);
                Intent current = getIntent();
                usernames = (HashMap) current.getSerializableExtra("data");

                TextView username = findViewById(R.id.studentUser);
                TextView password = findViewById(R.id.studentPass);


                String user = username.getText().toString();
                String pass = password.getText().toString();


                if (usernames.get(user).equals(pass)){
                    startActivity(intent);
                }
            }

        });


    }
}
