import java.util.Random;

public class JuegoOca {

    private static JuegoOca instance;
    private Jugador[]       jugadores;
    private Tablero         tablero;
    private boolean        hayGanador;

    private JuegoOca(){

    }

    public static JuegoOca getInstance(){
        if(JuegoOca.instance == null){
            JuegoOca.instance = new JuegoOca();
        }
        return JuegoOca.instance;
    }

    private Jugador[] generarJugadores(int cantHumanos){
        Jugador[] jugadores = new Jugador[4];
        return jugadores;
    }

    public void juego(){
        //Mientra no hay jugadores se sigue jugando
        int jugadorAct = 0;
        while (!hayGanador){
            //verifica si tiene turno, y recorre por todos los jugadores
            while (this.validarTurno(jugadorAct) && jugadorAct < jugadores.length){
                Jugador jugador = jugadores[jugadorAct];
                int posDestino = jugador.getPosicion() + jugador.lanzarDados();
                jugador.setPosicion(posDestino);
                this.tablero.getCasillas()[posDestino].activarEfecto(jugador,this.getTablero());
                jugadorAct++;
            }
            jugadorAct = 0;
        }
    }

    private boolean validarTurno(int pos){
        return jugadores[pos].getCantTurno() >= 0;
    }

    public Tablero getTablero() {
        return tablero;
    }
}
