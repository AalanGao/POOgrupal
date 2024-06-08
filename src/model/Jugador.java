package model;

import java.util.Random;

public abstract class Jugador implements Observado{

    //private int    id;
    private String nombre;
    private String color;
    private int    posicion;
    private int    cantTurno;
    public static Random random = new Random();

    public Jugador(int cantTurno, String color, String nombre, int posicion) {
        this.cantTurno = cantTurno;
        this.color = color;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public void update(){
        this.setCantTurno(1);
    }
    public abstract int lanzarDados();

    public int getCantTurno() {
        return cantTurno;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setCantTurno(int cantTurno) {
        this.cantTurno = cantTurno;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
