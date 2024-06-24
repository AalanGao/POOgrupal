import controller.JuegoOcaController;
import view.JuegoOcaFrame;

public class Main {
    public static void main(String[] args) {

        JuegoOcaFrame frame = new JuegoOcaFrame();
        JuegoOcaController oca = JuegoOcaController.getInstance();
        oca.setView(frame);

        oca.iniciarJuego();
    }
}