package com.example.karen.medappjam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    EditText username;
    EditText password;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.login_btn);
        username = (EditText) findViewById(R.id.email_address);
        password = (EditText) findViewById(R.id.password);
        String user_text = username.getText().toString();
        result.setText(user_text);
    }
}
