package com.example.anggarisky.splashtohomeangga;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class acerca extends AppCompatActivity {
    MediaPlayer mp;
    ImageView abaan, abaan2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);

        abaan = (ImageView) findViewById(R.id.abnview);
        abaan.setBackgroundResource(R.drawable.aba);

        abaan2 = (ImageView) findViewById(R.id.abnview2);
        abaan2.setBackgroundResource(R.drawable.aba2);

        AnimationDrawable fm = (AnimationDrawable) abaan.getBackground();
        fm.start();

        AnimationDrawable fm2 = (AnimationDrawable) abaan2.getBackground();
        fm2.start();

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
