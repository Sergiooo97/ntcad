package com.example.anggarisky.splashtohomeangga;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class acerca extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);

        mp = (MediaPlayer.create(this, R.raw.ss));
        mp.start();



    }

    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first
        Toast.makeText(getApplicationContext(), "volviendo al menu...", Toast.LENGTH_LONG).show();

        mp.stop();
    }
}
