/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 * Clase Peón
 * 
 * @author infor04
 */
public class Peon extends Pieza {

    /**
     * Indica si el peón se ha movido por primera vez o no
     */
    private boolean movido_1;

    /**
     * Constructor de la pieza Peón
     *
     * @param color
     */
    public Peon(char color) {
        super(color, 'P');
        movido_1 = false; // inicializado a NO movido por primera vez
    }

    /**
     * Consulta si el Peón se ha movido por primera vez
     *
     * @return Devuelve un booleano indicando si el Peón ya se ha movido por
     * primera vez
     */
    public boolean isMovido_1() {
        return movido_1;
    }

    /**
     * Usado para actualizar el Peón cuando se haya movido por primera vez
     */
    public void setMovido_1() {
        this.movido_1 = true; // sólo puede moverse por primera vez una vez
    }

    /**
     * Valida los movimientos válidos del Peón
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
        int diagonal = Math.abs(c_destino - c_origen);

        if (f_destino > f_origen) { // si nº fila destino es mayor que nº fila origen

            if ((f_diferencia == 1) && ((diagonal == 0) || (diagonal == 1))) { // movimientos válidos del peón
                valido = true;
            } else if (!isMovido_1()) {
                if ((f_diferencia == 2) && (diagonal == 0)) { //movimiento válido del peón en primer movimiento
                    valido = true;
                }
            }

        }
        return valido;
    }

}
