package model;

public final class CambioTurno extends Casilla {
    private final int cantidad;

    public CambioTurno(int posicion, TipoCasilla tipoCasilla, int cant) {
        super(posicion, tipoCasilla);
        this.cantidad = cant;
    }

    // en casilla dados se le agrega un turno --1
    @Override
    public void activarEfecto(Jugador jugador, Tablero tablero) {
        jugador.setCantTurno(jugador.getCantTurno()+cantidad);
    }
}
