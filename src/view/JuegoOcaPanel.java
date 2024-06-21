package view;

import model.Casilla;
import model.Jugador;
import model.Tablero;
import model.TipoCasilla;

import javax.swing.*;
import java.awt.*;


public class JuegoOcaPanel extends JPanel {

    private static final int ANCHO_CASILLA = 80;
    private static final int ALTO_CASILLA = 80;
    private static final int MARGEN_X = 50;
    private static final int MARGEN_Y = 50;

    private Tablero tablero;
    private int[] posicionesJugadores; // Array para las posiciones de los jugadores

    public JuegoOcaPanel() {
        setPreferredSize(new Dimension(600, 600)); // Tamaño del panel
        setBackground(Color.WHITE);
        posicionesJugadores = new int[4]; // Inicializar array para 4 jugadores
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
        repaint(); // Vuelve a pintar el panel cuando se establece el tablero
    }

    public void setPosicionesJugadores(int[] posicionesJugadores) {
        this.posicionesJugadores = posicionesJugadores;
        repaint(); // Vuelve a pintar el panel cuando se actualizan las posiciones de los jugadores
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (tablero != null) {
            Casilla[] casillas = tablero.getCasillas();

            for (int i = 0; i < casillas.length; i++) {
                int fila = i / 9;
                int columna = i % 9;

                int x = MARGEN_X + columna * ANCHO_CASILLA;
                int y = MARGEN_Y + fila * ALTO_CASILLA;

                // Dibujar el fondo de la casilla
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, ANCHO_CASILLA, ALTO_CASILLA);

                // Dibujar el borde de la casilla
                g.setColor(Color.BLACK);
                g.drawRect(x, y, ANCHO_CASILLA, ALTO_CASILLA);

                // Dibujar el número de la casilla
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(i), x + 5, y + 15);

                // Dibujar el tipo de casilla (puedes modificar esto según el tipo de casilla)
                if(casillas[i].getTipoCasilla() != TipoCasilla.COMUN){
                    g.drawString(casillas[i].getTipoCasilla().toString(), x + 5, y + 35);
                }

            }

            // Dibujar los jugadores en sus posiciones
            Color[] coloresJugadores = {Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA};

            for (int j = 0; j < posicionesJugadores.length; j++) {
                int posicion = posicionesJugadores[j];
                int fila = posicion / 9;
                int columna = posicion % 9;

                int x = MARGEN_X + columna * ANCHO_CASILLA;
                int y = MARGEN_Y + fila * ALTO_CASILLA;

                // Ajustar la posición dentro de la casilla para evitar que se superpongan
                int offsetX = (j % 2) * 20 - 10; // Desplazamiento en X (-10 o 10)
                int offsetY = (j / 2) * 20 - 10; // Desplazamiento en Y (-10 o 10)

                // Dibujar el jugador
                g.setColor(coloresJugadores[j]);
                g.fillOval(x + ANCHO_CASILLA / 2 - 10 + offsetX, y + ALTO_CASILLA / 2 - 10 + offsetY, 20, 20);
            }
        }
    }
}

