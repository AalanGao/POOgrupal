package model;

public final class DestinoDirecto extends Casilla{
    private int destino;

    public DestinoDirecto(int posicion, TipoCasilla tipoCasilla, int destino) {
        super(posicion, tipoCasilla);
        this.destino = destino;
    }

    public void activarEfecto(Jugador jugador, Tablero tablero){
        jugador.setPosicion(destino);
    }
}
