package com.example.anggarisky.splashtohomeangga;

import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dinero_class extends AppCompatActivity {

    TextView dinerito;
    EditText edtretirar, edtdescripcion;
    Button btnretirar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinero);

        dinerito = (TextView)findViewById(R.id.tvDInerito);
        edtretirar = (EditText) findViewById(R.id.txtCantidad);
        edtdescripcion = (EditText) findViewById(R.id.txtDescripcion);
        btnretirar = (Button) findViewById(R.id.btnRetirar);
        ejecutar();
        btnretirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                agregarretiro();
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
            Toast.makeText(getApplicationContext(), "No hay conexion", Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public void consultarP (){

        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from DineroNT");
            while (rs.next()) {
                dinerito.setText(rs.getString(2)+" $");

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }
    public void agregarretiro() {
        try {

            PreparedStatement pst = conexionBD().prepareStatement("insert into DineroS values (?,?,?)");
                pst.setString(1, "234");
                pst.setString(2, this.edtretirar.getText().toString());
                pst.setString(3, this.edtdescripcion.getText().toString());
                pst.executeUpdate();
            this.edtretirar.setText("");
            this.edtdescripcion.setText("");
            Toast.makeText(getApplicationContext(), "el retiro se realizo con exito", Toast.LENGTH_SHORT).show();

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }

    }
    private void ejecutar(){
        final Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                metodoEjecutar();//llamamos nuestro metodo
                handler.postDelayed(this,50);//se ejecutara cada 10 segundos
            }
        },5);//empezara a ejecutarse después de 5 milisegundos
    }
    private void metodoEjecutar() {


        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from DineroNT");
            while (rs.next()) {
                dinerito.setText(rs.getString(2)+" $");


            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "No hay conexion", Toast.LENGTH_SHORT).show();

        }
        return;

    }
}









