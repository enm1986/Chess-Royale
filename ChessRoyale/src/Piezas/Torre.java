/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 * Clase Torre
 * 
 * @author infor04
 */
public class Torre extends Pieza {

    /**
     * Constructor de la pieza Torre
     * @param color 
     */
    public Torre(char color) {
        super(color, 'T');
    }

    /**
     * Valida los movimientos válidos de la Torre
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

        if ((f_origen == f_destino) || (c_origen == c_destino)) { // movimientos válidos de la Torre
            valido = true;
        }

        return valido;
    }

}
