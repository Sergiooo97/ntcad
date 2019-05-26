package com.example.anggarisky.splashtohomeangga;

import android.os.Bundle;
import android.os.StrictMode;
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

            PreparedStatement pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?)");

            //PreparedStatement pst;
            String seleccion = this.spgrad.getSelectedItem().toString();

            if (seleccion.equals("1°")) {
                pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, this.edtnombre.getText().toString());
                pst.setString(2, this.edtApellidos.getText().toString());
                pst.setString(3, this.edtedad.getText().toString()+ " Años");
                pst.setString(4, "1 Grado");
                pst.setString(5, this.edtfechaa.getText().toString());
                pst.setString(6, this.edtmunicipio.getText().toString());
                pst.setString(7, this.edtdir.getText().toString());
                pst.setString(8, this.edtTutor.getText().toString());
                pst.setString(9, this.edtapellidosT.getText().toString());
                pst.setString(10, this.edtcelular.getText().toString());
                pst.executeUpdate();
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
            }


            if (seleccion.equals("2°")) {
              pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?)");
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
                pst.executeUpdate();
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();

            }
            if (seleccion.equals("3°")) {
                pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?)");
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
                pst.executeUpdate();
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
            }


            if (seleccion.equals("4°")) {
                pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?)");
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
                pst.executeUpdate();
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
            }


            if (seleccion.equals("5°")) {
                pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, this.edtnombre.getText().toString());
                pst.setString(2, this.edtApellidos.getText().toString());
                pst.setString(3, this.edtedad.getText().toString()+ " Años");
                pst.setString(4, "5 Grado");
                pst.setString(5, this.edtfechaa.getText().toString());
                pst.setString(6, this.edtmunicipio.getText().toString());
                pst.setString(7, this.edtdir.getText().toString());
                pst.setString(8, this.edtTutor.getText().toString());
                pst.setString(9, this.edtapellidosT.getText().toString());
                pst.setString(10, this.edtcelular.getText().toString());
                pst.executeUpdate();
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
            }


            if (seleccion.equals("6°")) {
                pst = conexionBD().prepareStatement("insert into natacadT values (?,?,?,?,?,?,?,?,?,?)");
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
                pst.executeUpdate();
                //Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_SHORT).show();
            }


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
            Toast.makeText(getApplicationContext(), "Registro agregado ", Toast.LENGTH_LONG).show();


        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }

    }

}
