public class Tablero {
    private Casilla[] casillas;

    public Tablero(int cant) {
        casillas = new Casilla[cant];
        for (int i = 0; i < cant; i++) {
            casillas[i] = new Casilla(i, TipoCasilla.COMUN);
        }
        this.casillas[5] = new Oca(5, TipoCasilla.OCA);
        int[] array= {5,9,14,18,23,27,32,36,41,45,50,54,59};
     for (int i = 0; i < array.length; i++) {
            this.casillas[array[i]] = new Oca(array[i], TipoCasilla.OCA);
        }
     this.casillas[6] = new DestinoDirecto(6, TipoCasilla.PUENTE, 19);
     this.casillas[12] = new DestinoDirecto(12, TipoCasilla.PUENTE, 19);
     this.casillas[19] = new CambioTurno(19, TipoCasilla.POSADA,-1);
     this.casillas[42] = new DestinoDirecto(42, TipoCasilla.LABERINTO, 30);
     this.casillas[26] = new CambioTurno(56, TipoCasilla.CARCEL,1);
     this.casillas[53] = new CambioTurno(53, TipoCasilla.VOLVERLANZARDADOS,1);
     this.casillas[58] = new DestinoDirecto(58, TipoCasilla.CALAVERA, 1);

    }


    public Casilla[] getCasillas() {
        return casillas;
    }


}
