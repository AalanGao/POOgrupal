package model;

public final class IA extends Jugador{

    public IA(int cantTurno, String color, String nombre, int posicion) {
        super(cantTurno, color, nombre, posicion);
    }

    @Override
    public int lanzarDados() {
        return Jugador.random.nextInt(6)+1;
    }
}
