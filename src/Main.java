import controller.JuegoOcaController;

public class Main {
    public static void main(String[] args) {

        JuegoOcaController oca = JuegoOcaController.getInstance();

        oca.iniciarJuego();
    }
}