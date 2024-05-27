public class Humano extends Jugador{

    public Humano(int cantTurno, String color, String nombre, int posicion) {
        super(cantTurno, color, nombre, posicion);
    }

    @Override
    public int lanzarDados() {
        return 0;
    }
}
