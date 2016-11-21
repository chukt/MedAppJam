package com.example.karen.medappjam1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    private Button button;
    private Button calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");

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


}
