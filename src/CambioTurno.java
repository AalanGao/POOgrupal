public class CambioTurno extends Casilla {
    private int cantidad;

    // en casilla dados se le agrega un turno --1
    @Override
    public void activarEfecto(Jugador jugador, Tablero tablero) {
        jugador.setCantTurno(jugador.getCantTurno()-cantidad);
    }
}
