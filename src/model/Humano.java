package model;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Humano extends Jugador{

    public Humano(int cantTurno, String color, String nombre, int posicion) {
        super(cantTurno, color, nombre, posicion);
    }

    @Override
    public int lanzarDados() {
        //return Jugador.random.nextInt(6)+1;
        return 6;
    }

}
