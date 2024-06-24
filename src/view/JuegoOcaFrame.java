package view;

import javax.swing.*;
import java.awt.*;

public final class JuegoOcaFrame extends JFrame {

    private static final int ANCHO_JUEGO = 850;
    private static final int ALTO_JUEGO = 700;

    private JuegoOcaPanel juegoPanel;
    private JButton btnLanzarDados;

    public JuegoOcaFrame() {
        setTitle("Juego de la Ocaa");
        setSize(ANCHO_JUEGO, ALTO_JUEGO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        juegoPanel = new JuegoOcaPanel();
        add(juegoPanel);

        // Crear botón para lanzar dados
        btnLanzarDados = new JButton("Lanzar Dados");
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnLanzarDados);
        add(panelBoton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void mostrarDialogoGanador(String nombreJugador) {
        JOptionPane.showMessageDialog(this,
                "¡El jugador " + nombreJugador + " ha ganado!",
                "¡Fin del juego!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public JuegoOcaPanel getJuegoPanel() {
        return juegoPanel;
    }

    public JButton getBtnLanzarDados() {
        return btnLanzarDados;
    }
}