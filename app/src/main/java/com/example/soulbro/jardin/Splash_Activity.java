package com.example.soulbro.jardin;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_Activity extends AppCompatActivity {

    private static final long Delay = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Para esconder la barra de titulo de la actividad
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent intent = new Intent(Splash_Activity.this,LoginActivity.class);
                startActivity(intent);
                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, Delay);
    }
}
