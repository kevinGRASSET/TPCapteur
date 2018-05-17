package com.example.grassetk.tpcapteurs;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Exercice1 extends AppCompatActivity {

    private SensorManager sensorManager;
    private ListView mListView;
    ArrayList arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice1);

        mListView = (ListView) findViewById(R.id.listView);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        listSensor();
        mListView.setAdapter(adapter);
    }

    private void listSensor() {
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensors) {
            arrayList.add(sensor.getName());
        }
    }
}
