/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import static Juego.ChessRoyale.DIMENSION_VENTANA;
import Juego.Casilla;
import Juego.Tablero;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Interfaz gráfica del programa
 *  
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Ventana extends JFrame {

    //variables estáticas que se se usan exclusivamente en el paquete GUI
    static boolean girarTableroAuto;
    static boolean mostrarMovimientos;
    
    static DireccionTablero direccionTablero;
    static Casilla casillaOrigen;
    static Casilla casillaDestino;

    //Atributos
    private final JFrame ventana;
    private final JMenuBar menu;
    private final PanelTablero panelTablero;

    private final Tablero tablero;
    
    //Constructor
    public Ventana() {
        // forma de la ventana
        this.ventana = new JFrame("Chess Royale");
        this.ventana.setLayout(new BorderLayout());
        this.ventana.setSize(DIMENSION_VENTANA);
        this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // barra de menú
        this.menu = new JMenuBar();
        mostrarMovimientos = false;
        girarTableroAuto = false;
        prepararMenu(this.menu);
        this.ventana.setJMenuBar(this.menu);

        // tablero GUI
        this.tablero = new Tablero();
        this.panelTablero = new PanelTablero(this.tablero);
        direccionTablero = DireccionTablero.NORMAL;
        this.ventana.add(this.panelTablero, BorderLayout.CENTER);

        // posición ventana
        this.ventana.setLocationRelativeTo(null); //centrar ventana
        this.ventana.setVisible(true);
    }

    private void prepararMenu(JMenuBar menu) {
        menu.add(crearPestanaArchivo());
        menu.add(crearPestanaOpciones());
    }

    private JMenu crearPestanaArchivo() {
        JMenu archivo = new JMenu("Archivo");

        JMenuItem reiniciar = new JMenuItem("Reiniciar partida");
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablero.reiniciarTablero();
                panelTablero.dibujarTableroGUI();
            }
        });
        archivo.add(reiniciar);

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
                panelTablero.dibujarTableroGUI();
            }
        });
        opciones.add(girar);

        opciones.addSeparator();

        JCheckBoxMenuItem giroAuto = new JCheckBoxMenuItem("Giro automático");
        giroAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                girarTableroAuto = giroAuto.isSelected();
            }
        });
        opciones.add(giroAuto);

        JCheckBoxMenuItem verMov = new JCheckBoxMenuItem("Ver movimientos");
        verMov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMovimientos = verMov.isSelected();
            }
        });
        opciones.add(verMov);

        return opciones;
    }

}
