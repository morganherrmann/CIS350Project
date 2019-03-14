package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class ParentLogin extends AppCompatActivity {

    private HashMap<String, String> usernames = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);


        Intent current = getIntent();
        usernames = (HashMap) current.getSerializableExtra("data");
    }
}
