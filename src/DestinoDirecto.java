public class DestinoDirecto {
    private int destino;

    public void activarEfecto(Jugador jugador, Tablero tablero){
        jugador.setPosicion(destino);
    }
}
