/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

// imports paquete Juego
import static Juego.ChessRoyale.DIMENSION_VENTANA;
import Juego.Casilla;
import Juego.Tablero;

// imports librerías
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 * Interfaz gráfica del programa.
 * <br><br>
 *
 * El bucle principal del juego será gestionado por los eventos que ocurran en
 * la interfaz gráfica.
 *
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Ventana extends JFrame {

//variables estáticas que se se usan exclusivamente en el paquete GUI
    // opciones GUI
    static DireccionTablero direccionTablero;
    static boolean girarTableroAuto;
    static boolean mostrarMovimientos;

    // casillas seleccionables en el tablero (Lógica juego)
    static Casilla casillaOrigen;
    static Casilla casillaDestino;

//Atributos
    //Atributos GUI
    private final JFrame ventana;
    private final JMenuBar menu;
    private final PanelTablero panelTablero;

    //Atributos Lógica juego
    private final Tablero tablero;

    //Constructor
    /**
     * Constructor de la ventana de la interfaz gráfica
     */
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

    /**
     * Crea la barra de menú
     * <br><br>
     * Por ahora tiene 2 pestañas
     *
     * @param menu Barra de menú
     */
    private void prepararMenu(JMenuBar menu) {
        menu.add(crearPestanaArchivo());
        menu.add(crearPestanaOpciones());
    }

    /**
     * Crea la pestaña "Archivo" de la barrá de menú.
     *
     * @return JMenu - Pestaña de la barra del menú
     */
    private JMenu crearPestanaArchivo() {
        JMenu archivo = new JMenu("Archivo");

        //Primera opción de la pestaña
        JMenuItem reiniciar = new JMenuItem("Reiniciar partida");
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablero.reiniciarTablero();
                panelTablero.dibujarTableroGUI();
            }
        });
        archivo.add(reiniciar);

        //Segunda opción de la pestaña
        JMenuItem guardarPartida = new JMenuItem("Guardar partida...");
        guardarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Guardar partida - No implementado");
            }
        });
        archivo.add(guardarPartida);

        //Tercera opción de la pestaña
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

    /**
     * Crea la pestaña "Opciones" de la barrá de menú.
     *
     * @return JMenu - Pestaña de la barra del menú
     */
    private JMenu crearPestanaOpciones() {
        JMenu opciones = new JMenu("Opciones");

        //Primera opción de la pestaña
        JMenuItem girar = new JMenuItem("Girar tablero");
        girar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                direccionTablero = direccionTablero.girarTablero();
                panelTablero.dibujarTableroGUI();
            }
        });
        opciones.add(girar);

        //Separador
        opciones.addSeparator();

        //Segunda opción de la pestaña - Activar/desactivar giro automático
        JCheckBoxMenuItem giroAuto = new JCheckBoxMenuItem("Giro automático");
        giroAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                girarTableroAuto = giroAuto.isSelected();
            }
        });
        opciones.add(giroAuto);

        //Tercera opción de la pestaña - - Activar/desactivar ver movimientos
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
