package controller;

import model.JuegoOca;
import view.JuegoOcaFrame;

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

    public void setView(JuegoOcaFrame frame){
        this.juegoOca.setViewOca(frame);
    }

    public void iniciarJuego() {
        juegoOca.juego();
    }
}
