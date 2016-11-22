package com.example.karen.medappjam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class displayEventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_event_details);

        String value = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            value = extras.getString("event_info");
        }
        TextView d = (TextView) findViewById(R.id.display);
        d.setTextSize(25);
        d.setText(value);
        //Log.d("value", value);


    }
}
