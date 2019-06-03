/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import GUI.Ventana;
import java.awt.Dimension;

/**
 * Juego de ajedrez con alguna modificación en las reglas.
 * <br><br>
 * Controles GUI:
 * <ul>
 * <li>Botón izquierdo ratón: selecciona pieza</li>
 * <li>Botón derecho ratón: cancela selección</li>
 * </ul>
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class ChessRoyale {

    public static int REY_MAX_MOV = 10;
    public static String RUTA_IMAGEN = "img/picasso/";
    public static Dimension DIMENSION_VENTANA = new Dimension(600, 600);
    public static Dimension DIMENSION_TABLERO = new Dimension(480, 480);
    public static Dimension DIMENSION_CASILLA = new Dimension(60, 60);

    public static void main(String[] args) {

        Ventana ventana = new Ventana();

    }
}
