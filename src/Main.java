import controller.JuegoOcaController;
import model.JuegoOca;

public class Main {
    public static void main(String[] args) {

        JuegoOcaController oca = JuegoOcaController.getInstance();

        oca.IniciarJuego();
    }
}