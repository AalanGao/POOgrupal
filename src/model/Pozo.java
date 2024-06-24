package model;

public final class Pozo extends Casilla {

    public Pozo(int posicion, TipoCasilla tipoCasilla) {
        super(posicion, tipoCasilla);
    }

    public void activarEfecto(Jugador jugador, Tablero tablero){
        jugador.setCantTurno(-999);
    }
}
