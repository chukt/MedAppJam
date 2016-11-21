package com.example.karen.medappjam1;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by CTPoonage on 11/20/16.
 * Open-sourced Android Library - (https://github.com/SundeepK/CompactCalendarView)
 */

public class CalendarActivity extends AppCompatActivity {

    //private static final String TAG = "CalendarActivity";
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        // Put the events in a list
        // ListView eventList = (ListView) findViewById(R.id.eventList);
        // eventList.setAdapter(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        // Source Format - https://gist.github.com/skooltch84/b7cb5361a09b687b4b9f434ddc33d2c6

        Event ev1 = new Event(Color.RED, 1479817812000L, "Med AppJam 2016");
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                //System.out.println(dateClicked.toString());
                System.out.println(dateClicked.getTime());
                if (dateClicked.toString().compareTo("Tue Nov 22 00:00:00 PST 2016") == 0)
                {
                    Toast.makeText(context, "Med AppJam 2016", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }

    private long convertDateToEpochLong(Date date)
    {
        return date.getTime();
    }

    private Date convertEpochLongtoDate(long epoch)
    {
        Date date = new Date(epoch * 1000);
        return date;
    }
}
