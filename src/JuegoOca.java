import java.util.Random;

public class JuegoOca {

    private static JuegoOca  instance;
    private final static int cantJugadores = 4;
    private final static int cantCasillas  = 63;
    private Jugador[]        jugadores;
    private Tablero          tablero;
    private boolean          hayGanador;

    private JuegoOca(){
        this.generarJugadores(1);
        this.tablero = new Tablero(cantCasillas);
    }

    public static JuegoOca getInstance(){
        if(JuegoOca.instance == null){
            JuegoOca.instance = new JuegoOca();
        }
        return JuegoOca.instance;
    }

    //cantidad de persona que jueguen
    private void generarJugadores(int cantHumanos){
        this.jugadores = new Jugador[4];
        for (int i = 0; i < cantJugadores; i++) {
            if (i < cantHumanos){
                jugadores[i] = new Humano(1,"negro","jugador",0);
            }else {
                jugadores[i] = new IA(1,"negro","IA",0);
            }
        }
    }

    public void juego(){
        //Mientra no haya ganador se sigue jugando
        System.out.println("Comienzo Juego OCA");
        int jugadorAct = 0;
        while (!hayGanador){
            //verifica si tiene turno, juega hasta que se quede sin turno
            while (this.validarTurno(jugadorAct)){
                Jugador jugador = jugadores[jugadorAct];
                int posDestino = jugador.getPosicion() + jugador.lanzarDados();
                if(posDestino >= cantCasillas){
                    posDestino =  cantCasillas-1 + (cantCasillas-1 - posDestino);
                } else if (posDestino == cantCasillas-1) {
                    hayGanador = true;
                }
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

            this.estadoDelJuego();
        }
    }

    private boolean validarTurno(int pos){
        return jugadores[pos].getCantTurno() > 0;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void estadoDelJuego(){
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getNombre() + " Posicion:" + jugadores[i].getPosicion());
        }
    }
}
