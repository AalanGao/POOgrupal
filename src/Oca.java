public class Oca extends DestinoDirecto {

    @Override
    public void activarEfecto(Jugador jugador, Tablero tablero) {
        jugador.setPosicion(this.proximoOca(jugador, tablero));
    }

    private int proximoOca(Jugador jugador, Tablero tablero){
        boolean encontro = false;
        int i = jugador.getPosicion();
        while (!encontro && i < tablero.getCasillas().length){
            i++;
            if(tablero.getCasillas()[i].getTipoCasilla().equals(TipoCasilla.OCA)){
                encontro = true;
            }
        }

        return encontro ? i : jugador.getPosicion();
    }

}
