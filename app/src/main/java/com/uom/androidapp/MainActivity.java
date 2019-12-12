package com.uom.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart chart = (LineChart) this.<View>findViewById(R.id.chart);


        Student[] students = new Student[10];
        List<Entry> entries = new ArrayList<Entry>();


            students[1].setName("s"+1);
            students[1].setGpa(Math.random()%10);
            students[2].setName("s"+2);
            students[2].setGpa(Math.random()%10);
            students[3].setName("s"+2);
            students[3].setGpa(Math.random()%10);


        for (Student data : students) {
            // turn your data into Entry objects
            entries.add(new Entry((float)1, (float)data.getGpa()));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(1);
        dataSet.setValueTextColor(2);

    }
}
