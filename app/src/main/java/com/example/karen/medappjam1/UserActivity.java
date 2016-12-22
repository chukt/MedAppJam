package com.example.karen.medappjam1;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private static final int REQUEST_NEW_EVENT_CODE = 0;
    private String event_info;
    private String event_display;
    private List<String> events = new ArrayList<>();

    private Button button;
    private Button calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        displayEvents();


        //Forum - Code provided by ahrasis (http://www.simplemachines.org/community/index.php?topic=526773.0)
        button = (Button) findViewById(R.id.buttonUrl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ForumActivity.class);
                startActivity(intent);
            }
        });

        // Calendar - Open-sourced Android library: (https://github.com/SundeepK/CompactCalendarView)
        calendarButton = (Button) findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });

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
                event_display = event.getStringExtra("new_activity_details");
                events.add(event_info);
            }
        }
        else{
            event_info = event.getStringExtra("new_activity");
            event_display = event.getStringExtra("new_activity_details");
            events.add(event_info);
        }
        displayEvents();
    }

    public void createEvent(View view){
        Intent intent = new Intent(this, add_event.class);
        startActivityForResult(intent, REQUEST_NEW_EVENT_CODE);

    }

    public void displayDetails(View view){
        Intent intent = new Intent(this, displayEventDetails.class);
        intent.putExtra("event_info", event_display);
        startActivity(intent);
    }

    public void displayDetailsHard(View view){
        String hard_coded = "Title: Diabetes Cooking Class\nDate: 11/28\nTime: 6 pm\nPlace: UC Irvine";
        Intent intent = new Intent(this, displayEventDetails.class);
        intent.putExtra("event_info", hard_coded);
        startActivity(intent);
    }

}
