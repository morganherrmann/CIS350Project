package com.example.moher.cis350project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class ParentLogin extends AppCompatActivity {

    private HashMap<String, String> usernames = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);


        Intent current = getIntent();
        usernames = (HashMap) current.getSerializableExtra("data");
        Log.i("In login for parents " , " "+ usernames.size() );


        Button login = findViewById(R.id.parentLogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParentLogin.this, ParentHome.class);

                TextView username = findViewById(R.id.parentUser);
                TextView password = findViewById(R.id.parentPass);


                String user = username.getText().toString();
                String pass = password.getText().toString();

//                Map.Entry<String,String> entry = usernames.entrySet();
//                String key = entry.getKey();
//                String value = entry.getValue();
//
//                Log.i("Key and value ", key + " " + value);

                if (usernames != null && usernames.get(user) != null){
                    if (usernames.get(user).equals(pass)) {
                        intent.putExtra("name", user);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Wrong password!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "User doesn't exist!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        });
    }
}
