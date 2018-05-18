package com.example.grassetk.tpcapteurs;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exercice3 extends AppCompatActivity {


    SensorManager manager;
    Sensor accelerometre;

    private TextView textviewx;
    private TextView textviewa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        textviewx=(TextView)findViewById(R.id.textView1);
        textviewa=(TextView)findViewById(R.id.textView4);



        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0)
        {
            // Il existe, donc mémorisons le, car nous positionnerons un listener dessus
            // Note, il peut exister plusieurs types de sensor, nous, celui qui nous intéresse est l'accéléromètre
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

    // Si notre activité est en pause, défaire le listener qui ne sert plus à rien...
    protected void onPause() {

        super.onPause();
        manager.unregisterListener(mySensorListener);

    }

    // Classe interne pour gérer le listener
    SensorEventListener mySensorListener = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1) {

        }

        @Override
        // Si l'accélérateur change, alors afficher les nouvelles valeurs...
        public void onSensorChanged(SensorEvent event) {
            // Autre qu'accéléromètre, ne rien faire
            if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
                return;

            float mSensorX = event.values[SensorManager.DATA_X];

            textviewx.setText("X:" + String.valueOf(Math.round(mSensorX)));

            if(Math.round(mSensorX) < 0)
            {
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }
            if(Math.round(mSensorX) == 0)
            {
                getWindow().getDecorView().setBackgroundColor(Color.BLACK);
            }
            if(Math.round(mSensorX) > 0)
            {
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
        }
    };
}
