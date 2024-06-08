package model;

import java.util.Scanner;

public class Humano extends Jugador{

    public Humano(int cantTurno, String color, String nombre, int posicion) {
        super(cantTurno, color, nombre, posicion);
    }

    @Override
    public int lanzarDados() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lanzar Dado: ingrese 1");

        /*return Jugador.random.nextInt(6)+1;*/
        return scan.nextInt();
    }

}
