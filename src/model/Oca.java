package model;

public class Oca extends Casilla {


    public Oca(int posicion, TipoCasilla tipoCasilla) {
        super(posicion, tipoCasilla);
    }

    @Override
    public void activarEfecto(Jugador jugador, Tablero tablero) {
        jugador.setPosicion(this.proximoOca(jugador, tablero));
    }

    private int proximoOca(Jugador jugador, Tablero tablero){
        boolean encontro = false;
        int i = jugador.getPosicion();
        while (!encontro && i < tablero.getCasillas().length-1){
            i++;
            if(tablero.getCasillas()[i].getTipoCasilla().equals(TipoCasilla.OCA)){
                encontro = true;
            }
        }

        return encontro ? i : jugador.getPosicion();
    }

}
