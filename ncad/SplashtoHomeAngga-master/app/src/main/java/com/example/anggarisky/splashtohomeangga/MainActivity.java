package com.example.anggarisky.splashtohomeangga;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;

public class MainActivity extends AppCompatActivity {

    ImageView bgapp, nata, corazon,sol, nombre, bienv;
    TextView textbien, txtca, txtcon, txtiin, tvv2;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;
    Button btnin, btncon, btnca, btndin, bacerca;
    Spinner spm;
    MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText btUser, btPass;
        final Button botonacceder;

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        botonacceder = (Button)findViewById(R.id.btnAccedeer);
        btUser = (EditText) findViewById(R.id.txtUser);
        spm = (Spinner)findViewById(R.id.spmenu);
        btPass = (EditText)findViewById(R.id.txtPassword);
        bgapp = (ImageView) findViewById(R.id.backgroudInicio);
        corazon = (ImageView) findViewById(R.id.imgcorazoon);
        sol = (ImageView) findViewById(R.id.imgSool);
        nombre = (ImageView) findViewById(R.id.imgAcaNom);
        bienv = (ImageView) findViewById(R.id.imgbien);
        tvv2 = (TextView)findViewById(R.id.tv2);


        textsplash = (LinearLayout) findViewById(R.id.txtSplash);
        textbien = (TextView) findViewById(R.id.txtBienve);
        texthome = (LinearLayout) findViewById(R.id.txtHome);
        menus = (LinearLayout) findViewById(R.id.Menuu);
        this.btnin = (Button) findViewById(R.id.btnIncribir);
        this.btncon = (Button) findViewById(R.id.btnConsultar);
        this.btnca = (Button) findViewById(R.id.btnDIn);
        this.txtca = (TextView) findViewById(R.id.txtcall);
        this.txtcon = (TextView) findViewById(R.id.txtIns2);
        this.txtiin = (TextView) findViewById(R.id.txtins);
        this.btnin = (Button) findViewById(R.id.btnIncribir);
        this.btncon = (Button) findViewById(R.id.btnConsultar);
        this.btndin = (Button) findViewById(R.id.btnDIn);
        this.bacerca = (Button) findViewById(R.id.btnAbout);

        bacerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent form = new Intent(MainActivity.this, acerca.class);
                startActivity(form);

            }
        });

        mp = (MediaPlayer.create(this, R.raw.pop));



        spm.setVisibility(View.INVISIBLE);
        btnin.setVisibility(View.INVISIBLE);
        tvv2.setVisibility(View.INVISIBLE);

        btnca.setVisibility(View.INVISIBLE);
        btncon.setVisibility(View.INVISIBLE);
        String [] opciones = {"todos", "1ª", "2ª", "3ª", "4ª", "5ª", "6ª"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spm.setAdapter(adapter);




        Button bootonDin = (Button)findViewById(R.id.btnDIn);
        bootonDin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexionDInero();
                mp.start();



            }
        });


        Button Boton = (Button)findViewById(R.id.btnAccedeer);
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Usuario = ((EditText) findViewById(R.id.txtUser)).getText().toString();
                String Contraseña = ((EditText) findViewById(R.id.txtPassword)).getText().toString();
                mp.start();

                if (Usuario.equals("a") && Contraseña.equals("b")) {
conexionBD();
                    Animation frombotton;
                    frombotton = AnimationUtils.loadAnimation(MainActivity.this, R.anim.frombottom);
                    spm.setVisibility(View.VISIBLE);
                    btnin.setVisibility(View.VISIBLE);
                    btnca.setVisibility(View.VISIBLE);
                    btncon.setVisibility(View.VISIBLE);

                            /*Intent nuevoform =new Intent(MainActivity.this,  menuclass.class);
                            startActivity(nuevoform);*/


                    bgapp.animate().translationY(-1575.0f).setDuration(700).setStartDelay(1000);
                    sol.animate().translationY(-350.0f).setDuration(400).setStartDelay(1000);
                    corazon.animate().translationY(-350.0f).setDuration(500).setStartDelay(1000);
                    nombre.animate().translationY(-350.0f).setDuration(600).setStartDelay(1000);
                    textbien.animate().translationY(300.0f).alpha(0.0f).setDuration(600).setStartDelay(1000);
                    bienv.animate().translationY(300.0f).alpha(0.0f).setDuration(600).setStartDelay(1000);


                    btUser.animate().translationY(300.0f).alpha(0.0f).setDuration(600).setStartDelay(1000);
                    botonacceder.animate().translationY(300.0f).alpha(0.0f).setDuration(600).setStartDelay(1000);
                    btPass.animate().translationY(300.0f).alpha(0.0f).setDuration(600).setStartDelay(1000);

                    btUser.setFocusable(false);
                    btUser.setEnabled(false);
                    btUser.setCursorVisible(false);
                    btUser.setKeyListener(null);
                    btPass.setFocusable(false);
                    btPass.setEnabled(false);
                    btPass.setCursorVisible(false);
                    btPass.setKeyListener(null);

                    btnin.startAnimation(frombotton);
                    txtiin.startAnimation(frombotton);
                    btncon.startAnimation(frombotton);
                    txtcon.startAnimation(frombotton);
                    txtca.startAnimation(frombotton);
                    btnca.startAnimation(frombotton);
                    spm.startAnimation(frombotton);


                            /*btUser.startAnimation(this.frombottom);
                            botonacceder.startAnimation(this.frombottom);
                            btPass.startAnimation(this.frombottom);*/





                }
                else{
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevoform =new Intent(MainActivity.this,  Formulario_class.class);
                startActivity(nuevoform);
                mp.start();

            }
        });




        btncon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Consult();
                mp.start();


            }
        });




    }

    public Connection conexionBD() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public  void Consult() {

        String seleccion = this.spm.getSelectedItem().toString();

        if (seleccion.equals("todos")) {
            conexionBDTODOS();
        }
        if (seleccion.equals("1ª")) {
            conexionBD01();
        }
        if (seleccion.equals("2ª")) {
            conexionBD02();
        }
        if (seleccion.equals("3ª")) {
            conexionBD03();
        }
        if (seleccion.equals("4ª")) {
            conexionBD04();
        }
        if (seleccion.equals("5ª")) {
            conexionBD05();
        }
        if (seleccion.equals("6ª")) {
            conexionBD06();
        }
    }
    public Connection conexionBD01() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("1");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public Connection conexionBD02() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("2");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public Connection conexionBD03() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("3");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public Connection conexionBD04() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("4");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public Connection conexionBD05() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("5");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public Connection conexionBD06() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("6");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public Connection conexionBDTODOS() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            tvv2.setText("T");
            Intent nuevoform =new Intent(MainActivity.this,  Consulta.class);
            nuevoform.putExtra("selec", tvv2.getText().toString());
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

        }
        return conexion;

    }
    public Connection conexionDInero() {
        Connection conexion = null;
        try {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
            Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

            Intent nuevoform = new Intent(MainActivity.this, dinero_class.class);
            startActivity(nuevoform);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No hay conexion", Toast.LENGTH_SHORT).show();

        }
        return conexion;

    }

}