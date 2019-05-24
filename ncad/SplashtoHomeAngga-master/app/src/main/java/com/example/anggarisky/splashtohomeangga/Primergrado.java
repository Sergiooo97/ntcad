package com.example.anggarisky.splashtohomeangga;

public class Primergrado {
    private String nombre1, edad1, grado1, apellido1;
    private int imageEst;

    public Primergrado() {
    }

    public Primergrado(String nombre1, String edad1, String grado1, String apellido1, int imageEst) {
        this.nombre1 = nombre1;
        this.edad1 = edad1;
        this.grado1 = grado1;
        this.imageEst = imageEst;
        this.apellido1 = apellido1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getEdad1() {
        return edad1;
    }

    public void setEdad1(String edad1) {
        this.edad1 = edad1;
    }

    public String getGrado1() {
        return grado1;
    }

    public void setGrado1(String grado1) {
        this.grado1 = grado1;
    }

    public int getImageEst() {
        return imageEst;
    }

    public void setImageEst(int imageEst) {
        this.imageEst = imageEst;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
}
