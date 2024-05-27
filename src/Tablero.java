public class Tablero {
    private Casilla[] casillas;

    public Tablero(int cant) {
        casillas = new Casilla[cant];
        for (int i = 0; i < cant; i++) {
            casillas[i] = new Casilla(i, TipoCasilla.COMUN);
        }
        this.casillas[5] = new Oca(5, TipoCasilla.OCA);
    }

    public Casilla[] getCasillas() {
        return casillas;
    }


}
