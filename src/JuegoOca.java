import java.util.Random;

public class JuegoOca {

    private static JuegoOca  instance;
    private final static int cantJugadores = 4;
    private final static int cantCasillas  = 63;
    private Jugador[]        jugadores;
    private Tablero          tablero;
    private boolean          hayGanador;

    private JuegoOca(){

    }

    public static JuegoOca getInstance(){
        if(JuegoOca.instance == null){
            JuegoOca.instance = new JuegoOca();
        }
        return JuegoOca.instance;
    }

    //cantidad de persona que jueguen
    private Jugador[] generarJugadores(int cantHumanos){
        Jugador[] jugadores = new Jugador[4];
        for (int i = 0; i < cantJugadores; i++) {
            if (i < cantHumanos){
                jugadores[i] = new Humano(1,"negro","jugador",0);
            }else {
                jugadores[i] = new IA(1,"negro","IA",0);
            }
        }
        return jugadores;
    }

    public void juego(){
        //Mientra no haya ganador se sigue jugando
        int jugadorAct = 0;
        while (!hayGanador){
            //verifica si tiene turno, juega hasta que se quede sin turno
            while (this.validarTurno(jugadorAct)){
                Jugador jugador = jugadores[jugadorAct];
                int posDestino = jugador.getPosicion() + jugador.lanzarDados();
                jugador.setPosicion(posDestino);
                this.tablero.getCasillas()[posDestino].activarEfecto(jugador,this.getTablero());
                jugador.setCantTurno(jugador.getCantTurno()-1);
            }

            jugadores[jugadorAct].setCantTurno(jugadores[jugadorAct].getCantTurno()+1);

            if(jugadorAct == jugadores.length-1){
                jugadorAct = 0;
            }else {
                jugadorAct++;
            }
        }
    }

    private boolean validarTurno(int pos){
        return jugadores[pos].getCantTurno() > 0;
    }

    public Tablero getTablero() {
        return tablero;
    }


}
