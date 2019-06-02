/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Casilla;
import Juego.Movimiento;
import Juego.Tablero;
import java.util.ArrayList;

/**
 *
 * @author infor04
 */
public abstract class Pieza {

    private Color color;

    public Pieza(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    abstract public Tipo getTipo();
    abstract public ArrayList<Movimiento> movimientosValidos(Tablero tablero, Casilla casilla);

    public String getNombre() {
        return this.getTipo().toString().substring(0, 1) + this.getColor().toString().substring(0, 1);
    }

    protected static boolean coordenadaValida(int[] coordenada) {
        return (coordenada[0] >= 0 && coordenada[0] <= 7 && coordenada[1] >= 0 && coordenada[1] <= 7);
    }
}
