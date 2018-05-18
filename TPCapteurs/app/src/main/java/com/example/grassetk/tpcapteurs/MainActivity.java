package com.example.grassetk.tpcapteurs;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private ListView mListView;
    ArrayList arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Exercice1.class);
        startActivity(intent);
    }

    public void onClick2(View v) {
        Intent intent = new Intent(MainActivity.this, Exercice2.class);
        startActivity(intent);
    }

    public void onClick3(View v) {
        Intent intent = new Intent(MainActivity.this, Exercice3.class);
        startActivity(intent);
    }

    public void onClick4(View v) {
        Intent intent = new Intent(MainActivity.this, Exercice4.class);
        startActivity(intent);
    }

    public void onClick5(View v) {
        Intent intent = new Intent(MainActivity.this, Exercice5.class);
        startActivity(intent);
    }

    public void onClick6(View v) {
        Intent intent = new Intent(MainActivity.this, Exercice6.class);
        startActivity(intent);
    }
}
