package model;

import view.JuegoOcaFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class JuegoOca implements Observado{

    private static JuegoOca  instance;
    private final static int cantJugadores = 4;
    private final static int cantCasillas  = 63;
    private Jugador[]        jugadores;
    private Tablero          tablero;
    private boolean          hayGanador;
    private final JuegoOcaFrame juegoOcaFrame;
    private boolean jugador0HaLanzadoDados;

    private JuegoOca(){
        this.juegoOcaFrame = new JuegoOcaFrame();
        this.generarJugadores(1);
        this.tablero = new Tablero(cantCasillas);

        juegoOcaFrame.getBtnLanzarDados().addActionListener(e -> {
            this.jugador0HaLanzadoDados = true;
        });
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
                jugadores[i] = new IA(1,"negro","IA " + i,0);
            }
        }
    }

    public void juego()  {
        //Mientra no haya ganador se sigue jugando
        int jugadorAct = 0;
        juegoOcaFrame.getJuegoPanel().setTablero(this.getTablero());

        while (!hayGanador){
            //verifica si tiene turno, juega hasta que se quede sin turno
            while (this.validarTurno(jugadorAct)){
                Jugador jugador = jugadores[jugadorAct];
                if (jugadorAct == 0) {
                    // Habilitar el botón para lanzar dados
                    SwingUtilities.invokeLater(() -> {
                        juegoOcaFrame.getBtnLanzarDados().setEnabled(true);
                    });

                    // Esperar hasta que se haga clic en el botón
                    while (!jugador0HaLanzadoDados) {
                        try {
                            Thread.sleep(100); // Esperar 1 segundo antes de verificar de nuevo
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Desactivar el botón después de que se haya lanzado los dados
                    SwingUtilities.invokeLater(() -> {
                        juegoOcaFrame.getBtnLanzarDados().setEnabled(false);
                    });

                    // Reiniciar la bandera para el siguiente turno del jugador 0
                    jugador0HaLanzadoDados = false;
                }
                int posAnterior = jugador.getPosicion();
                int posDestino =  posAnterior + jugador.lanzarDados();
                if(posDestino >= cantCasillas){
                    posDestino =  cantCasillas-1 + (cantCasillas-1 - posDestino);
                } else if (posDestino == cantCasillas-1) {
                    hayGanador = true;
                }

                int pasos = Math.abs(posDestino - posAnterior);
                int direccion = (posDestino > posAnterior) ? 1 : -1;

                for (int i = 0; i <= pasos; i++) {
                    int nuevaPosicion = posAnterior + i * direccion;
                    jugador.setPosicion(nuevaPosicion);

                    // Actualizar la interfaz de usuario
                        juegoOcaFrame.getJuegoPanel().setPosicionesJugadores(this.estadoJuego());

                    try {
                        Thread.sleep(300); // Esperar 0.5 segundos
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                jugador.setPosicion(posDestino);
                this.tablero.getCasillas()[posDestino].activarEfecto(jugador,this.getTablero());
                jugador.setCantTurno(jugador.getCantTurno()-1);

                if(posAnterior < 31 && posDestino > 31){
                    this.notificar();
                }
            }

            if (hayGanador) {
                juegoOcaFrame.mostrarDialogoGanador(jugadores[jugadorAct].getNombre());
            }

            juegoOcaFrame.getJuegoPanel().setPosicionesJugadores(this.estadoJuego());

            jugadores[jugadorAct].setCantTurno(jugadores[jugadorAct].getCantTurno()+1);

            if(jugadorAct == jugadores.length-1){
                jugadorAct = 0;
            }else {
                jugadorAct++;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    private boolean validarTurno(int pos){
        return jugadores[pos].getCantTurno() > 0;
    }

    public Tablero getTablero() {
        return tablero;
    }

    @Override
    public void notificar() {
        for (int i = 0; i < jugadores.length; i++) {
            if (this.jugadores[i].getPosicion() == 31){
                this.jugadores[i].update();
            }
        }
    }

    public int[] estadoJuego(){
        int[] estado = new int[4];
        for (int i = 0; i < jugadores.length; i++) {
            estado[i] = this.jugadores[i].getPosicion();
        }
        return estado;
    }
}
