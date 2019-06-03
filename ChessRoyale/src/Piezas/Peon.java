/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.*;
import static Piezas.Pieza.coordenadaValida;
import java.util.ArrayList;

/**
 * Clase Peón
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Peon extends Pieza {

    /**
     * Offset de coordenadas (fila, columna) que indican las POSICIONES donde
     * puede moverse el Peón.<br>
     * <br>
     * Posiciones: {1, 0}, {2, 0}, {1, -1}, {1, 1}
     */
    private final static int[][] COORDENADAS_OFFSET = {{1, 0}, {2, 0}, {1, -1}, {1, 1}};

    /**
     * Indica si el peón puede hacer su primer movimiento.
     */
    private boolean primerMovimientoHecho;

    public Peon(Color color) {
        super(Tipo.PEON, color);
        this.primerMovimientoHecho = false;
    }

    /**
     * Comprueba si el peón ha hecho su primer movimiento
     *
     * @return boolean
     */
    public boolean isPrimerMovimientoHecho() {
        return primerMovimientoHecho;
    }

    /**
     * Indica que el peón ha hecho su primer movimiento (usado después de que el peón
     * se mueva por primera vez)
     */
    public void primerMovimientoHecho() {
        this.primerMovimientoHecho = true;
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            // por cada offset se comprueban los movimientos válidos
            // añadimos el offset a la posición de la pieza
            // el offset de la fila es multiplicado por 1 o -1 según la dirección en que se mueve el peón (depende del color del peón)
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0] * this.getColor().getDireccion();
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) { // si la coordenada destino es válida
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (coordenadaOffset[1] == 0 && !destino.isOcupada()) {
                    //Movimiento a casilla vacía
                    if (coordenadaOffset[0] == 1) {//movimiento de 1 casilla
                        lista.add(destino); // movimiento válido
                    } else if (!this.isPrimerMovimientoHecho()) {//movimiento de 2 casillas
                        Casilla intermedia = tablero.getCasilla(origen.getFila() + this.getColor().getDireccion(), origen.getColumna());
                        if (!intermedia.isOcupada()) { // si la casilla entre origen y destino está vacía
                            lista.add(destino); // movimiento válido
                        }
                    }
                } else if (coordenadaOffset[1] != 0 && destino.isOcupada() && this.getColor() != destino.getPieza().getColor()) {
                    //Movimiento a casilla ocupada por el oponente (Ataque)
                    lista.add(destino); // movimiento válido
                }
            }
        }
        return lista;
    }
}
