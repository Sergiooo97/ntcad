package com.example.anggarisky.splashtohomeangga;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Consulta extends AppCompatActivity {


    private RecyclerView recycleviewalumnos1;
    private RecyclerVIewAdap1 adaptadoralumno1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anio_uno);



        String selec = getIntent().getStringExtra("selec");


        if (selec.equals("T")) {
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);


        }

        if(selec.equals("1")){
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD2());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);



        }
        if(selec.equals("2")){
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD3());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);



        }
        if(selec.equals("3")){
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD4());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);



        }
        if(selec.equals("4")){
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD5());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);



        }
        if(selec.equals("5")){
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD6());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);



        }
        if(selec.equals("6")){
            recycleviewalumnos1 = (RecyclerView) findViewById(R.id.Recycleruno);
            recycleviewalumnos1.setLayoutManager(new LinearLayoutManager((this)));
            adaptadoralumno1 = new RecyclerVIewAdap1(obtenerBD7());
            recycleviewalumnos1.setAdapter(adaptadoralumno1);



        }
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
    public Connection conexionBD2() {
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.78;databaseName=natacad;user=SA;password=4973160vvVV");

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "no hay conexion", Toast.LENGTH_SHORT).show();
            finish();

        }
        return conexion;
    }

    public List<Primergrado> obtenerBD() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT ORDER BY Grado, Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"),rs.getString("Id"),  R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }

    public List<Primergrado> obtenerBD2() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT WHERE Grado = '1 Grado' ORDER BY  Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"),rs.getString("Id"), R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }

    public List<Primergrado> obtenerBD3() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT WHERE Grado = '2 Grado' ORDER BY  Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"),rs.getString("Id"), R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }

    public List<Primergrado> obtenerBD4() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT WHERE Grado = '3 Grado' ORDER BY  Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"), rs.getString("Id"), R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }

    public List<Primergrado> obtenerBD5() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT WHERE Grado = '4 Grado' ORDER BY  Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"), rs.getString("Id"), R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }

    public List<Primergrado> obtenerBD6() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT WHERE Grado = '5 Grado' ORDER BY  Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"), rs.getString("Id"), R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }

    public List<Primergrado> obtenerBD7() {
        List<Primergrado> alumno = new ArrayList<>();
        try {
            Statement st = conexionBD().createStatement();
            ResultSet rs = st.executeQuery("select * from natacadT WHERE Grado = '6 Grado' ORDER BY  Edad ASC");
            while (rs.next()) {
                alumno.add(new Primergrado(rs.getString("Nombre"), rs.getString("Edad"), rs.getString("Grado"), rs.getString("Apellidos"), rs.getString("Municipio"), rs.getString("Celular_Tutor"), rs.getString("Id"), R.drawable.estudiante));

            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();


        }
        return alumno;
    }
}