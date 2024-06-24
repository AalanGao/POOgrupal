package model;

public class Casilla {

    private int posicion;
    private TipoCasilla tipoCasilla;

    public Casilla(int posicion, TipoCasilla tipoCasilla) {
        this.posicion = posicion;
        this.tipoCasilla = tipoCasilla;
    }

    public void activarEfecto(Jugador jugador, Tablero tablero){
    }

    public TipoCasilla getTipoCasilla() {
        return tipoCasilla;
    }
}
