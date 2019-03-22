package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;


public class CreateAccount extends AppCompatActivity {


    private String id;
    private String firstName;
    private String lastName;

    private String userName;
    private String password;

    private HashMap<String, String> usernames;



    private void setInfo(){

        TextView first = findViewById(R.id.firstName);
        firstName = first.getText().toString();

        TextView last = findViewById(R.id.lastName);
        lastName = last.getText().toString();

        TextView user = findViewById(R.id.userName);
        userName = user.getText().toString();

        TextView pass = findViewById(R.id.userPassword);
        password = pass.getText().toString();

    }

    private boolean isValid(){

        if (firstName == null || lastName == null || userName == null || password == null){
            return false;
        }

        if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty() || password.isEmpty()){
            return false;
        }

        if (usernames.containsKey(userName)){
            return false;
        }

        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);



        Button parent = findViewById(R.id.createParentAcc);
        Button student = findViewById(R.id.createStudentAcc);

        Intent current = getIntent();
        usernames = (HashMap) current.getSerializableExtra("data");

        if (usernames == null){
            usernames = new HashMap<>();
        }



        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, LoginPage.class);

                setInfo();
                if (isValid()) {
                    usernames.put(userName, password);
                    intent.putExtra("data", usernames);
                    startActivity(intent);
                }
            }

        });


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, LoginPage.class);

                setInfo();

                if (isValid()) {
                    usernames.put(userName, password);
                    intent.putExtra("data", usernames);
                    startActivity(intent);
                }


            }

        });
    }


}
