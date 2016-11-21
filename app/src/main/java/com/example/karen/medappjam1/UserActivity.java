package com.example.karen.medappjam1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private static final int REQUEST_NEW_EVENT_CODE = 0;
    private String event_info;
    private List<String> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        displayEvents();


    }
    private void displayEvents(){
        TextView top = (TextView) findViewById(R.id.eventButtonText);
        TextView bottom = (TextView) findViewById(R.id.eventButton2Text);
        if(events.size() == 0) {
            View b = findViewById(R.id.secondEventButton);
            b.setVisibility(View.GONE);
            top.setText("\n           + \n    Add New \n      Activity \n");
        }
        else{
            if(events.size() == 1){
                View b = findViewById(R.id.secondEventButton);
                TextView second = (TextView) findViewById(R.id.eventButtonText2);
                second.setText(events.get(0));
                b.setVisibility(View.VISIBLE);

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent event){
        if(requestCode == REQUEST_NEW_EVENT_CODE){
            if(resultCode == Activity.RESULT_OK){
                event_info = event.getStringExtra("new_activity");
                events.add(event_info);
            }
        }
        else{
            event_info = event.getStringExtra("new_activity");
            events.add(event_info);
        }
        displayEvents();
    }

    public void createEvent(View view){
        Intent intent = new Intent(this, add_event.class);
        startActivityForResult(intent, REQUEST_NEW_EVENT_CODE);

    }

}
