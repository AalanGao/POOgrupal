public class DestinoDirecto extends Casilla{
    private int destino;

    public DestinoDirecto(int posicion, TipoCasilla tipoCasilla) {
        super(posicion, tipoCasilla);
    }


    public void activarEfecto(Jugador jugador, Tablero tablero){
        jugador.setPosicion(destino);
    }
}
