package com.example.karen.medappjam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_event extends AppCompatActivity {
    Button done;
    EditText activity_name;
    EditText date;
    EditText time;
    EditText location;
    EditText additional_details;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

    }


    public void exit(View view){
        activity_name = (EditText) findViewById(R.id.activity_name);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        location = (EditText) findViewById(R.id.location);
        additional_details = (EditText) findViewById(R.id.additional_details);
        done = (Button) findViewById(R.id.done);

        result = activity_name.getText().toString() + "\n" + date.getText().toString() + "\n at " +
                time.getText().toString() +"\n at " + location.getText().toString();
        Intent event = new Intent();
        event.putExtra("new_activity", result);
        event.putExtra("additional_info", additional_details.getText().toString());
        setResult(RESULT_OK, event);
        finish();
    }
}
