package com.example.karen.medappjam1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button newUserButton;
    Button loginButton;
    EditText username;
    EditText password;
    EditText result;

    private Button button;

    ArrayList<String> usernameList;


    String user;
    private static final String KEY_INDEX = "username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newUserButton = (Button) findViewById(R.id.new_user);
        loginButton = (Button) findViewById(R.id.login_btn);
        username = (EditText) findViewById(R.id.email_address);
        password = (EditText) findViewById(R.id.password);
//        Log.d("tag", "Log is working");
    }

//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState){
//        user = username.getText().toString();
//        super.onSaveInstanceState(savedInstanceState);
//        savedInstanceState.putString(KEY_INDEX, user);
//
//    }

    public void new_user(View view){
        Intent intent = new Intent(this, newUser.class);
        startActivity(intent);
        Intent intent2 = getIntent();
        usernameList = intent2.getStringArrayListExtra("usernameList");

    }

    public void login(View view){
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("username", user);
        Log.d("random", "Log is working");
        //String userSize = Integer.toString(usernameList.size());
//        Log.d("usernameList Size", Integer.toString(usernameList.size()));
//        for(int i = 0; i<usernameList.size(); i++)
//        {
//            if(usernameList.get(i) == user)
//                startActivity(intent);
//            Log.d("Something", usernameList.get(i));
//        }
        startActivity(intent);
    }
}
// References
//http://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field
//https://developer.android.com/reference/android/view/ViewGroup.MarginLayoutParams.html
//https://developer.android.com/training/index.html
//http://stackoverflow.com/questions/14579671/how-to-send-variables-from-main-activity-to-multiple-activities-in-android