/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 * Clase Alfil
 * 
 * @author infor04
 */
public class Alfil extends Pieza {

    /**
     * Constructor de pieza Alfil
     * 
     * @param color 
     */
    public Alfil(char color) {
        super(color, 'A');
    }

    /**
     * Valida los movimientos válidos del Alfil
     * 
     * @param f_origen fila origen
     * @param c_origen columna origen
     * @param f_destino fila destino
     * @param c_destino columna destino
     * @return Devuelve un booleano indicando si el movimiento es válido
     */
    @Override
    public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino) {

        boolean valido = false;
        int f_diferencia = Math.abs(f_destino - f_origen);
        int c_diferencia = Math.abs(c_destino - c_origen);

        if (f_diferencia == c_diferencia) { // movimientos válidos del Alfil
            valido = true;
        }

        return valido;
    }

}
