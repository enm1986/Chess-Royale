/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Juego.Casilla;
import Juego.Tablero;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author navar
 */
public class Ventana extends JFrame {

    final static String RUTA_IMAGEN = "img/";
    final static Dimension DIMENSION_VENTANA = new Dimension(600, 600);
    final static Dimension DIMENSION_TABLERO = new Dimension(480, 480);
    final static Dimension DIMENSION_CASILLA = new Dimension(60, 60);
    static DireccionTablero direccionTablero;

    private JFrame ventana;
    private JMenuBar menu;
    private PanelTablero panelTablero;
    
    private Tablero tablero;
    static Casilla casillaOrigen;
    static Casilla casillaDestino;

    public Ventana() {
        this.ventana = new JFrame("Chess Royale");
        this.ventana.setLayout(new BorderLayout());
        this.ventana.setSize(DIMENSION_VENTANA);
        this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.menu = new JMenuBar();
        prepararMenu(this.menu);
        this.ventana.setJMenuBar(this.menu);

        this.tablero = new Tablero();
        this.panelTablero = new PanelTablero(this.tablero);
        direccionTablero = DireccionTablero.NORMAL;
        this.ventana.add(this.panelTablero, BorderLayout.CENTER);

        this.ventana.setVisible(true);
    }

    private void prepararMenu(JMenuBar menu) {
        menu.add(crearPestanaArchivo());
        menu.add(crearPestanaOpciones());
    }

    private JMenu crearPestanaArchivo() {
        JMenu archivo = new JMenu("Archivo");

        JMenuItem guardarPartida = new JMenuItem("Guardar partida...");
        guardarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Guardar partida");
            }
        });
        archivo.add(guardarPartida);

        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        archivo.add(salir);

        return archivo;
    }

    private JMenu crearPestanaOpciones() {
        JMenu opciones = new JMenu("Opciones");

        JMenuItem girar = new JMenuItem("Girar tablero");
        girar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direccionTablero = direccionTablero.girarTablero();
                panelTablero.dibujarTableroGUI(tablero);
            }
        });
        opciones.add(girar);

        JMenuItem verMov = new JMenuItem("Ver movimientos");
        verMov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Mostrar movimientos");
            }
        });
        opciones.add(verMov);

        return opciones;
    }

}
