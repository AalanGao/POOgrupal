package controller;

import model.JuegoOca;

public class JuegoOcaController {

    private static JuegoOcaController instance;

    private final JuegoOca juegoOca;

    private JuegoOcaController() {
        this.juegoOca = JuegoOca.getInstance();
    }

    public static JuegoOcaController getInstance() {
        if(instance == null) {
            instance = new JuegoOcaController();
        }
        return instance;
    }

    public void IniciarJuego(){
        this.juegoOca.juego();
    }
}
