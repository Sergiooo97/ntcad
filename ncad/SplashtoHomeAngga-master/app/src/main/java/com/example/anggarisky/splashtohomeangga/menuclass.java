package com.example.anggarisky.splashtohomeangga;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;

public class menuclass extends AppCompatActivity {
    ImageView bien, natan;
    Button btnca, btncon, btnin;
    Animation frombotton;
    TextView txtca, txtcon, txtiin;
    Spinner spm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);




        this.frombotton = AnimationUtils.loadAnimation(this, R.anim.frombottom);
       this.btnin = (Button) findViewById(R.id.btnIncribir);
        this.btncon = (Button) findViewById(R.id.btnConsultar);
        this.btnca = (Button) findViewById(R.id.btnDIn);
        this.txtca = (TextView) findViewById(R.id.txtcall);
        this.txtcon = (TextView) findViewById(R.id.txtIns2);
        this.txtiin = (TextView) findViewById(R.id.txtins);
        this.bien = (ImageView) findViewById(R.id.imgbien);
        spm = (Spinner)findViewById(R.id.spmenu);
        this.natan = (ImageView) findViewById(R.id.imgnatan);
        this.btnin.startAnimation(this.frombotton);
        this.txtiin.startAnimation(this.frombotton);
        this.btncon.startAnimation(this.frombotton);
        this.txtcon.startAnimation(this.frombotton);
        this.txtca.startAnimation(this.frombotton);
        this.btnca.startAnimation(this.frombotton);
        this.spm.startAnimation(this.frombotton);

        this.bien.animate().translationY(120.0f).setDuration(600).setStartDelay(500);
        this.natan.animate().translationY(120.0f).setDuration(700).setStartDelay(500);

        // ((Button) findViewById(R.id.btnIncribir)).setOnClickListener(new C00291());

        /*Button Botonin = (Button)findViewById(R.id.btnIncribir);
        Botonin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform =new Intent(menuclass.this,  Formulario_class.class);
                startActivity(nuevoform);
            }
        });*/


        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform =new Intent(menuclass.this,  Formulario_class.class);
                startActivity(nuevoform);
            }
        });

        btncon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform =new Intent(menuclass.this,  Consulta.class);
                startActivity(nuevoform);
            }
        });





    }

    public Connection conexionBDm () {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado m", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "no hay conexion", Toast.LENGTH_SHORT).show();
            finish();
        }
        return conexion;
    }
}