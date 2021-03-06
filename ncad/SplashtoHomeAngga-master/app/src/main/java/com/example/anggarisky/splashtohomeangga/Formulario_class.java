package com.example.anggarisky.splashtohomeangga;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Formulario_class extends AppCompatActivity {
    Button butonagregar;
    EditText edtApellidos;
    EditText edtTutor;
    EditText edtapellidosT;
    EditText edtcelular;
    EditText edtdir;
    EditText edtedad;
    EditText edtfechaa;
    EditText edtgrado;
    EditText edtmunicipio;
    EditText edtnombre;
    Spinner spgrad;
    TextView tvcont;
    FloatingActionButton floatb;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_layout);

        this.edtnombre = (EditText) findViewById(R.id.txtNombre);
        this.edtApellidos = (EditText) findViewById(R.id.txtApellidos);
        this.edtapellidosT = (EditText) findViewById(R.id.txtApellidosT);
        this.edtedad = (EditText) findViewById(R.id.txtEdad);
        this.edtmunicipio = (EditText) findViewById(R.id.txtMunicipio);
        this.spgrad = (Spinner) findViewById(R.id.spGrado);
        this.edtTutor = (EditText) findViewById(R.id.txtNombreT);
        this.edtcelular = (EditText) findViewById(R.id.txtCElular);
        this.butonagregar = (Button) findViewById(R.id.btnIncribir);
        this.edtfechaa = (EditText) findViewById(R.id.txtFecha);
        this.edtdir = (EditText) findViewById(R.id.txtDIreccion);
        this.floatb = (FloatingActionButton)findViewById(R.id.btnbu);
        mp = (MediaPlayer.create(this, R.raw.aplausos));

        floatb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connection conexion = null;
                try {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
                    Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                    conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");
                    Toast.makeText(getApplicationContext(), "conectado", Toast.LENGTH_SHORT).show();

                    Intent nuevoform =new Intent(Formulario_class.this,  Consulta.class);
                    nuevoform.putExtra("selec","T");
                    startActivity(nuevoform);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "No hay conexion",Toast.LENGTH_SHORT).show();

                }


            }
        });








        butonagregar = (Button) findViewById(R.id.btnRegistrar);

        String [] opciones = {"Seleccione un grado", "1°", "2°", "3°", "4°", "5°", "6°"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spgrad.setAdapter(adapter);

        //this.spgrad.setAdapter(new ArrayAdapter(this, 17367049, new String[]{"Seleccione un grado", "1°", "2°", "3°", "4°", "5°", "6°"}));

        Button Boton = (Button) findViewById(R.id.btnRegistrar);
        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                agregarusuario();



            }


        });
    }
    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first

        mp.stop();
    }


    public Connection conexionBD() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }




    public void agregarusuario() {
        try {

            PreparedStatement pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?)");
            String seleccion = this.spgrad.getSelectedItem().toString();

            if (seleccion.equals("1°")) {

                if (edtnombre.getText().toString().trim().equalsIgnoreCase("")){
                    edtnombre.setError("este campo no puede quedar vacio");

                }
                if (edtApellidos.getText().toString().trim().equalsIgnoreCase("")){
                    edtApellidos.setError("este campo no puede quedar vacio");

                }
                if (edtapellidosT.getText().toString().trim().equalsIgnoreCase("")){
                    edtapellidosT.setError("este campo no puede quedar vacio");

                }
                if (edtedad.getText().toString().trim().equalsIgnoreCase("")){
                    edtedad.setError("este campo no puede quedar vacio");

                }
                if (edtmunicipio.getText().toString().trim().equalsIgnoreCase("")){
                    edtmunicipio.setError("este campo no puede quedar vacio");

                }
                if (edtTutor.getText().toString().trim().equalsIgnoreCase("")){
                    edtTutor.setError("este campo no puede quedar vacio");

                }
                if (edtcelular.getText().toString().trim().equalsIgnoreCase("")){
                    edtcelular.setError("este campo no puede quedar vacio");

                }
                if (edtfechaa.getText().toString().trim().equalsIgnoreCase("")){
                    edtfechaa.setError("este campo no puede quedar vacio");
                }
                if (edtdir.getText().toString().trim().equalsIgnoreCase("")){
                    edtdir.setError("este campo no puede quedar vacio");

                }
               if(!edtnombre.getText().toString().isEmpty() && !edtApellidos.getText().toString().isEmpty() && !edtedad.getText().toString().isEmpty()
                       && !edtfechaa.getText().toString().isEmpty() && !edtmunicipio.getText().toString().isEmpty() && !edtdir.getText().toString().isEmpty()
                       && !edtTutor.getText().toString().isEmpty()&& !edtapellidosT.getText().toString().isEmpty() && !edtcelular.getText().toString().isEmpty()) {
                    pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, this.edtnombre.getText().toString());
                    pst.setString(2, this.edtApellidos.getText().toString());
                    pst.setString(3, this.edtedad.getText().toString() + " Años");
                    pst.setString(4, "1 Grado");
                    pst.setString(5, this.edtfechaa.getText().toString());
                    pst.setString(6, this.edtmunicipio.getText().toString());
                    pst.setString(7, this.edtdir.getText().toString());
                    pst.setString(8, this.edtTutor.getText().toString());
                    pst.setString(9, this.edtapellidosT.getText().toString());
                    pst.setString(10, this.edtcelular.getText().toString());
                    pst.setString(11, "234");
                    pst.setString(12, "1500");


                    pst.executeUpdate();
                   mp.start();
                    Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
                    this.edtnombre.setText("");
                    this.edtfechaa.setText("");
                    this.edtApellidos.setText("");
                    this.edtfechaa.setText("");
                    this.edtcelular.setText("");
                    this.edtdir.setText("");
                    this.edtTutor.setText("");
                    this.edtmunicipio.setText("");

                    this.edtedad.setText("");
                    this.edtapellidosT.setText("");
                }

            }


            if (seleccion.equals("2°")) {

                if (edtnombre.getText().toString().trim().equalsIgnoreCase("")){
                    edtnombre.setError("este campo no puede quedar vacio");
                }
                if (edtApellidos.getText().toString().trim().equalsIgnoreCase("")){
                    edtApellidos.setError("este campo no puede quedar vacio");
                }
                if (edtapellidosT.getText().toString().trim().equalsIgnoreCase("")){
                    edtapellidosT.setError("este campo no puede quedar vacio");
                }
                if (edtedad.getText().toString().trim().equalsIgnoreCase("")){
                    edtedad.setError("este campo no puede quedar vacio");
                }
                if (edtmunicipio.getText().toString().trim().equalsIgnoreCase("")){
                    edtmunicipio.setError("este campo no puede quedar vacio");
                }
                if (edtTutor.getText().toString().trim().equalsIgnoreCase("")){
                    edtTutor.setError("este campo no puede quedar vacio");
                }
                if (edtcelular.getText().toString().trim().equalsIgnoreCase("")){
                    edtcelular.setError("este campo no puede quedar vacio");
                }
                if (edtfechaa.getText().toString().trim().equalsIgnoreCase("")){
                    edtfechaa.setError("este campo no puede quedar vacio");
                }
                if (edtdir.getText().toString().trim().equalsIgnoreCase("")){
                    edtdir.setError("este campo no puede quedar vacio");
                }
                if(!edtnombre.getText().toString().isEmpty() && !edtApellidos.getText().toString().isEmpty() && !edtedad.getText().toString().isEmpty()
                        && !edtfechaa.getText().toString().isEmpty() && !edtmunicipio.getText().toString().isEmpty() && !edtdir.getText().toString().isEmpty()
                        && !edtTutor.getText().toString().isEmpty()&& !edtapellidosT.getText().toString().isEmpty() && !edtcelular.getText().toString().isEmpty()) {

                    pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, this.edtnombre.getText().toString());
                    pst.setString(2, this.edtApellidos.getText().toString());
                    pst.setString(3, this.edtedad.getText().toString() + " Años");
                    pst.setString(4, "2 Grado");
                    pst.setString(5, this.edtfechaa.getText().toString());
                    pst.setString(6, this.edtmunicipio.getText().toString());
                    pst.setString(7, this.edtdir.getText().toString());
                    pst.setString(8, this.edtTutor.getText().toString());
                    pst.setString(9, this.edtapellidosT.getText().toString());
                    pst.setString(10, this.edtcelular.getText().toString());
                    pst.setString(11, "234");
                    pst.setString(12, "1500");
                    pst.executeUpdate();
                    mp.start();




                    Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
                    this.edtnombre.setText("");
                    this.edtfechaa.setText("");
                    this.edtApellidos.setText("");
                    this.edtfechaa.setText("");
                    this.edtcelular.setText("");
                    this.edtdir.setText("");
                    this.edtTutor.setText("");
                    this.edtmunicipio.setText("");

                    this.edtedad.setText("");
                    this.edtapellidosT.setText("");
                }

            }


            //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();


            if (seleccion.equals("3°")) {
                if (edtnombre.getText().toString().trim().equalsIgnoreCase("")){
                    edtnombre.setError("este campo no puede quedar vacio");
                }
                if (edtApellidos.getText().toString().trim().equalsIgnoreCase("")){
                    edtApellidos.setError("este campo no puede quedar vacio");
                }
                if (edtapellidosT.getText().toString().trim().equalsIgnoreCase("")){
                    edtapellidosT.setError("este campo no puede quedar vacio");
                }
                if (edtedad.getText().toString().trim().equalsIgnoreCase("")){
                    edtedad.setError("este campo no puede quedar vacio");
                }
                if (edtmunicipio.getText().toString().trim().equalsIgnoreCase("")){
                    edtmunicipio.setError("este campo no puede quedar vacio");
                }
                if (edtTutor.getText().toString().trim().equalsIgnoreCase("")){
                    edtTutor.setError("este campo no puede quedar vacio");
                }
                if (edtcelular.getText().toString().trim().equalsIgnoreCase("")){
                    edtcelular.setError("este campo no puede quedar vacio");
                }
                if (edtfechaa.getText().toString().trim().equalsIgnoreCase("")){
                    edtfechaa.setError("este campo no puede quedar vacio");
                }
                if (edtdir.getText().toString().trim().equalsIgnoreCase("")){
                    edtdir.setError("este campo no puede quedar vacio");
                }
                if(!edtnombre.getText().toString().isEmpty() && !edtApellidos.getText().toString().isEmpty() && !edtedad.getText().toString().isEmpty()
                        && !edtfechaa.getText().toString().isEmpty() && !edtmunicipio.getText().toString().isEmpty() && !edtdir.getText().toString().isEmpty()
                        && !edtTutor.getText().toString().isEmpty()&& !edtapellidosT.getText().toString().isEmpty() && !edtcelular.getText().toString().isEmpty()) {
                    pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, this.edtnombre.getText().toString());
                    pst.setString(2, this.edtApellidos.getText().toString());
                    pst.setString(3, this.edtedad.getText().toString() + " Años");
                    pst.setString(4, "3 Grado");
                    pst.setString(5, this.edtfechaa.getText().toString());
                    pst.setString(6, this.edtmunicipio.getText().toString());
                    pst.setString(7, this.edtdir.getText().toString());
                    pst.setString(8, this.edtTutor.getText().toString());
                    pst.setString(9, this.edtapellidosT.getText().toString());
                    pst.setString(10, this.edtcelular.getText().toString());
                    pst.setString(11, "234");
                    pst.setString(12, "1500");
                    pst.executeUpdate();
                    mp.start();

                    Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
                    this.edtnombre.setText("");
                    this.edtfechaa.setText("");
                    this.edtApellidos.setText("");
                    this.edtfechaa.setText("");
                    this.edtcelular.setText("");
                    this.edtdir.setText("");
                    this.edtTutor.setText("");
                    this.edtmunicipio.setText("");

                    this.edtedad.setText("");
                    this.edtapellidosT.setText("");


                }
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
            }


            if (seleccion.equals("4°")) {
                if (edtnombre.getText().toString().trim().equalsIgnoreCase("")){
                    edtnombre.setError("este campo no puede quedar vacio");
                }
                if (edtApellidos.getText().toString().trim().equalsIgnoreCase("")){
                    edtApellidos.setError("este campo no puede quedar vacio");
                }
                if (edtapellidosT.getText().toString().trim().equalsIgnoreCase("")){
                    edtapellidosT.setError("este campo no puede quedar vacio");
                }
                if (edtedad.getText().toString().trim().equalsIgnoreCase("")){
                    edtedad.setError("este campo no puede quedar vacio");
                }
                if (edtmunicipio.getText().toString().trim().equalsIgnoreCase("")){
                    edtmunicipio.setError("este campo no puede quedar vacio");
                }
                if (edtTutor.getText().toString().trim().equalsIgnoreCase("")){
                    edtTutor.setError("este campo no puede quedar vacio");
                }
                if (edtcelular.getText().toString().trim().equalsIgnoreCase("")){
                    edtcelular.setError("este campo no puede quedar vacio");
                }
                if (edtfechaa.getText().toString().trim().equalsIgnoreCase("")){
                    edtfechaa.setError("este campo no puede quedar vacio");
                }
                if (edtdir.getText().toString().trim().equalsIgnoreCase("")){
                    edtdir.setError("este campo no puede quedar vacio");
                }
                if(!edtnombre.getText().toString().isEmpty() && !edtApellidos.getText().toString().isEmpty() && !edtedad.getText().toString().isEmpty()
                && !edtfechaa.getText().toString().isEmpty() && !edtmunicipio.getText().toString().isEmpty() && !edtdir.getText().toString().isEmpty()
                && !edtTutor.getText().toString().isEmpty()&& !edtapellidosT.getText().toString().isEmpty() && !edtcelular.getText().toString().isEmpty()  ) {
                    pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, this.edtnombre.getText().toString());
                    pst.setString(2, this.edtApellidos.getText().toString());
                    pst.setString(3, this.edtedad.getText().toString() + " Años");
                    pst.setString(4, "4 Grado");
                    pst.setString(5, this.edtfechaa.getText().toString());
                    pst.setString(6, this.edtmunicipio.getText().toString());
                    pst.setString(7, this.edtdir.getText().toString());
                    pst.setString(8, this.edtTutor.getText().toString());
                    pst.setString(9, this.edtapellidosT.getText().toString());
                    pst.setString(10, this.edtcelular.getText().toString());
                    pst.setString(11, "234");
                    pst.setString(12, "1500");
                    pst.executeUpdate();
                    mp.start();

                    Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
                    this.edtnombre.setText("");
                    this.edtfechaa.setText("");
                    this.edtApellidos.setText("");
                    this.edtfechaa.setText("");
                    this.edtcelular.setText("");
                    this.edtdir.setText("");
                    this.edtTutor.setText("");
                    this.edtmunicipio.setText("");

                    this.edtedad.setText("");
                    this.edtapellidosT.setText("");

                }
            }


            if (seleccion.equals("5°")) {
                if (edtnombre.getText().toString().trim().equalsIgnoreCase("")){
                    edtnombre.setError("este campo no puede quedar vacio");
                }
                if (edtApellidos.getText().toString().trim().equalsIgnoreCase("")){
                    edtApellidos.setError("este campo no puede quedar vacio");
                }
                if (edtapellidosT.getText().toString().trim().equalsIgnoreCase("")){
                    edtapellidosT.setError("este campo no puede quedar vacio");
                }
                if (edtedad.getText().toString().trim().equalsIgnoreCase("")){
                    edtedad.setError("este campo no puede quedar vacio");
                }
                if (edtmunicipio.getText().toString().trim().equalsIgnoreCase("")){
                    edtmunicipio.setError("este campo no puede quedar vacio");
                }
                if (edtTutor.getText().toString().trim().equalsIgnoreCase("")){
                    edtTutor.setError("este campo no puede quedar vacio");
                }
                if (edtcelular.getText().toString().trim().equalsIgnoreCase("")){
                    edtcelular.setError("este campo no puede quedar vacio");
                }
                if (edtfechaa.getText().toString().trim().equalsIgnoreCase("")){
                    edtfechaa.setError("este campo no puede quedar vacio");
                }
                if (edtdir.getText().toString().trim().equalsIgnoreCase("")){
                    edtdir.setError("este campo no puede quedar vacio");
                }
                if(!edtnombre.getText().toString().isEmpty() && !edtApellidos.getText().toString().isEmpty() && !edtedad.getText().toString().isEmpty()
                        && !edtfechaa.getText().toString().isEmpty() && !edtmunicipio.getText().toString().isEmpty() && !edtdir.getText().toString().isEmpty()
                        && !edtTutor.getText().toString().isEmpty()&& !edtapellidosT.getText().toString().isEmpty() && !edtcelular.getText().toString().isEmpty()) {
                    pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, this.edtnombre.getText().toString());
                    pst.setString(2, this.edtApellidos.getText().toString());
                    pst.setString(3, this.edtedad.getText().toString() + " Años");
                    pst.setString(4, "5 Grado");
                    pst.setString(5, this.edtfechaa.getText().toString());
                    pst.setString(6, this.edtmunicipio.getText().toString());
                    pst.setString(7, this.edtdir.getText().toString());
                    pst.setString(8, this.edtTutor.getText().toString());
                    pst.setString(9, this.edtapellidosT.getText().toString());
                    pst.setString(10, this.edtcelular.getText().toString());
                    pst.setString(11, "234");
                    pst.setString(12, "1500");
                    pst.executeUpdate();
                    mp.start();

                    Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
                    this.edtnombre.setText("");
                    this.edtfechaa.setText("");
                    this.edtApellidos.setText("");
                    this.edtfechaa.setText("");
                    this.edtcelular.setText("");
                    this.edtdir.setText("");
                    this.edtTutor.setText("");
                    this.edtmunicipio.setText("");

                    this.edtedad.setText("");
                    this.edtapellidosT.setText("");
                }
            }


            if (seleccion.equals("6°")) {
                if (edtnombre.getText().toString().trim().equalsIgnoreCase("")){
                    edtnombre.setError("este campo no puede quedar vacio");
                }
                if (edtApellidos.getText().toString().trim().equalsIgnoreCase("")){
                    edtApellidos.setError("este campo no puede quedar vacio");
                }
                if (edtapellidosT.getText().toString().trim().equalsIgnoreCase("")){
                    edtapellidosT.setError("este campo no puede quedar vacio");
                }
                if (edtedad.getText().toString().trim().equalsIgnoreCase("")){
                    edtedad.setError("este campo no puede quedar vacio");
                }
                if (edtmunicipio.getText().toString().trim().equalsIgnoreCase("")){
                    edtmunicipio.setError("este campo no puede quedar vacio");
                }
                if (edtTutor.getText().toString().trim().equalsIgnoreCase("")){
                    edtTutor.setError("este campo no puede quedar vacio");
                }
                if (edtcelular.getText().toString().trim().equalsIgnoreCase("")){
                    edtcelular.setError("este campo no puede quedar vacio");
                }
                if (edtfechaa.getText().toString().trim().equalsIgnoreCase("")){
                    edtfechaa.setError("este campo no puede quedar vacio");
                }
                if (edtdir.getText().toString().trim().equalsIgnoreCase("")) {
                    edtdir.setError("este campo no puede quedar vacio");
                }

                if(!edtnombre.getText().toString().isEmpty() && !edtApellidos.getText().toString().isEmpty() && !edtedad.getText().toString().isEmpty()
                        && !edtfechaa.getText().toString().isEmpty() && !edtmunicipio.getText().toString().isEmpty() && !edtdir.getText().toString().isEmpty()
                        && !edtTutor.getText().toString().isEmpty()&& !edtapellidosT.getText().toString().isEmpty() && !edtcelular.getText().toString().isEmpty()) {

                    pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, this.edtnombre.getText().toString());
                    pst.setString(2, this.edtApellidos.getText().toString());
                    pst.setString(3, this.edtedad.getText().toString() + " Años");
                    pst.setString(4, "6 Grado");
                    pst.setString(5, this.edtfechaa.getText().toString());
                    pst.setString(6, this.edtmunicipio.getText().toString());
                    pst.setString(7, this.edtdir.getText().toString());
                    pst.setString(8, this.edtTutor.getText().toString());
                    pst.setString(9, this.edtapellidosT.getText().toString());
                    pst.setString(10, this.edtcelular.getText().toString());
                    pst.setString(11, "234");
                    pst.setString(12, "1500");
                    pst.executeUpdate();
                    mp.start();

                    Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
                    this.edtnombre.setText("");
                    this.edtfechaa.setText("");
                    this.edtApellidos.setText("");
                    this.edtfechaa.setText("");
                    this.edtcelular.setText("");
                    this.edtdir.setText("");
                    this.edtTutor.setText("");
                    this.edtmunicipio.setText("");

                    this.edtedad.setText("");
                    this.edtapellidosT.setText("");
                }

                }






        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }

    }

}
