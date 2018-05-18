package com.example.grassetk.tpcapteurs;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Exercice4 extends AppCompatActivity {


    SensorManager manager;
    Sensor accelerometre;

    private TextView textviewx;
    private TextView textviewa;
    private TextView textviewy;
    private TextView textviewz;
    private TextView direction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        textviewx=(TextView)findViewById(R.id.textView1);
        textviewa=(TextView)findViewById(R.id.textView4);
        textviewy=(TextView)findViewById(R.id.textView2);
        textviewz=(TextView)findViewById(R.id.textView3);
        direction=(TextView)findViewById(R.id.Direction);


        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0)
        {
            accelerometre = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            textviewa.setText("Accélérateur présent...");
        }
        else
        {
            textviewa.setText("Il n'y a pas d'accélérateur présent sur cet appareil !");
        }
    }

    public void onResume ()
    {
        super.onResume();

        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0)
        {
            manager.registerListener(mySensorListener, accelerometre, SensorManager.SENSOR_DELAY_UI);
        }
    }


    protected void onPause() {

        super.onPause();
        manager.unregisterListener(mySensorListener);

    }


    SensorEventListener mySensorListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1) {

        }

        @Override

        public void onSensorChanged(SensorEvent event) {

            if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
                return;

            float mSensorX = event.values[SensorManager.DATA_X];
            float mSensorY = event.values[SensorManager.DATA_Y];
            float mSensorZ = event.values[SensorManager.DATA_Z];

            textviewx.setText("X:" + String.valueOf(Math.round(mSensorX)));
            textviewy.setText("Y:" + String.valueOf(Math.round(mSensorY)));
            textviewz.setText("Z:" + String.valueOf(Math.round(mSensorZ)));

            if(Math.round(mSensorX) == 0)
            {
                direction.setText("CENTRE");
            }
            if(Math.round(mSensorX) < 0)
            {
                direction.setText("DROITE");
            }
            if(Math.round(mSensorX) > 0)
            {
                direction.setText("GAUCHE");
            }
            if(Math.round(mSensorY) > 0)
            {
                direction.setText("HAUT");
            }
            if(Math.round(mSensorY) < 0)
            {
                direction.setText("BAS");
            }
        }
    };
}
