package com.example.grassetk.tpcapteurs;

import android.content.Context;
import android.content.pm.PackageManager;

import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Exercice5 extends AppCompatActivity {

    // flash light
    private CameraManager mCameraManager;
    private String mCameraId;
    private ImageButton mTorchOnOffButton;
    private Float i;
    private Boolean isTorchOn;


    private TextView textviewx;
    SensorManager manager;
    Sensor accelerometre;
    private TextView textviewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        textviewx=(TextView)findViewById(R.id.textView1);
        textviewa=(TextView)findViewById(R.id.textView4);

        Log.d("FlashLightActivity", "onCreate()");
        Boolean isFlashAvailable = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

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

        public void onSensorChanged(SensorEvent event) {



            if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
                return;

            float mSensorX = event.values[SensorManager.DATA_X];

            textviewx.setText("X:" + String.valueOf(Math.round(mSensorX)));

            if (Math.round(mSensorX) < 0 || Math.round(mSensorX) > 0) {
                isTorchOn = true;
            }
        }
    };
}

