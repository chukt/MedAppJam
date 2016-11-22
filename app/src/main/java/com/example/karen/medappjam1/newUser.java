package com.example.karen.medappjam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class newUser extends AppCompatActivity {

    ArrayList<String> usernameList = new ArrayList<String>();
    EditText usernameWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);




        usernameWidget = (EditText)findViewById(R.id.username);

    }

    public void signUp(View view) {

        String username = usernameWidget.getText().toString();
        usernameList.add(username);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("usernameList", usernameList);
        startActivity(intent);
    }

//    public ArrayList<String> getUsernameList()
}
