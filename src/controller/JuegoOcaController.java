package controller;

import model.JuegoOca;
import view.JuegoOcaFrame;

import javax.swing.*;

public class JuegoOcaController {

    private static JuegoOcaController instance;

    private final JuegoOca juegoOca;

    private final JuegoOcaFrame juegoOcaFrame;

    private JuegoOcaController() {
        this.juegoOca = JuegoOca.getInstance();
        this.juegoOcaFrame = new JuegoOcaFrame();
    }

    public static JuegoOcaController getInstance() {
        if(instance == null) {
            instance = new JuegoOcaController();
        }
        return instance;
    }

    /*public void iniciarJuego() {
        Thread juegoThread = new Thread(() -> {
            juegoOca.juego();
        });
        juegoThread.start();

        // Actualizar el panel de juego con el tablero
        juegoOcaFrame.getJuegoPanel().setTablero(juegoOca.getTablero());
        juegoOcaFrame.getJuegoPanel().setPosicionesJugadores(juegoOca.estadoJuego());
    }*/
    public void iniciarJuego2() {
        // Asegúrate de que la creación y visualización de la ventana se realice en el EDT
        juegoOca.juego();
    }
}
