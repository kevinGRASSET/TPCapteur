package com.example.grassetk.tpcapteurs;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Exercice6 extends AppCompatActivity {


    SensorManager mySensorManager;
    Sensor myProximitySensor;
    TextView ProximitySensor;

    TextView ProximityReading;
    TextView proximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice6);

        proximity= (TextView)findViewById(R.id.Proximity);
        ProximitySensor = (TextView)findViewById(R.id.proximitySensor);

        ProximityReading = (TextView)findViewById(R.id.proximityReading);
        mySensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null){
            ProximitySensor.setText("No Proximity Sensor!");
        }else{
            ProximitySensor.setText(myProximitySensor.getName());
            mySensorManager.registerListener(proximitySensorEventListener, myProximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }




    }

     SensorEventListener proximitySensorEventListener = new SensorEventListener()
     {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy)
        {
            // TODO Auto-generated method stub
        }
        @Override
        public void onSensorChanged(SensorEvent event)
        {
            // TODO Auto-generated method stub
            if(event.sensor.getType()==Sensor.TYPE_PROXIMITY)
            {
                ProximityReading.setText("Proximity Sensor Reading:"
                        + String.valueOf(Math.round(event.values[0])));
            }

            if(event.values[0] == 0)
            {
                proximity.setText("Proche");
            }
            else
            {
                proximity.setText("Loin");
            }
        }
     };
}
