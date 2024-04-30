public abstract class Jugador {

    private int    id;
    private String nombre;
    private String color;
    private int    posicion;
    private int    cantTurno;

    public abstract int lanzarDados();

    public int getCantTurno() {
        return cantTurno;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setCantTurno(int cantTurno) {
        this.cantTurno = cantTurno;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
