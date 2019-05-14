/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 * Clase Dama
 * 
 * @author infor04
 */
public class Dama extends Pieza {

    /**
     * Constructor de pieza Dama
     * 
     * @param color 
     */
    public Dama(char color) {
        super(color, 'D');
    }

    /**
     * Valida los movimientos válidos de la Dama
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

        if ((c_origen == c_destino) || (f_origen == f_destino) || (f_diferencia == c_diferencia)) { // movimientos válidos de la Dama
            valido = true;
        }

        return valido;
    }

}
