package com.example.karen.medappjam1;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.Context;


public class MainActivity extends AppCompatActivity {
    Button loginButton;
    EditText username;
    EditText password;
    EditText result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.login_btn);
        username = (EditText) findViewById(R.id.email_address);
        password = (EditText) findViewById(R.id.password);

        //forum
        button = (Button) findViewById(R.id.buttonUrl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ForumActivity.class);
                startActivity(intent);
            }
        });

    }
}
