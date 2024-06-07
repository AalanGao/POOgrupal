package model;

public class Pozo extends Casilla {
    public Pozo(int posicion, TipoCasilla tipoCasilla) {
        super(posicion, tipoCasilla);
    }

    public void activarEfecto(Jugador jugador, Tablero tablero){
        jugador.setCantTurno(Integer.MIN_VALUE);
    }
}
