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
 * Clase Alfil
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Alfil extends Pieza {

    /**
     * Offset de coordenadas (fila, columna) que indican las DIRECCIONES hacia donde puede moverse el Alfil<br>
     * <br>
     * Diagonales = {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
     */
    private final static int[][] COORDENADAS_OFFSET
            = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public Alfil(Color color) {
        super(Tipo.ALFIL, color);
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            // por cada offset se comprueban los movimientos válidos
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0]; //añadimos el offset a la posición de la pieza
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            boolean piezaBloquea = false;
            while (coordenadaValida(coordenadaDestino) && !piezaBloquea) {
                // mientras la coordenada esté en el tablero y no nos bloquee otra pieza
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) { // si la casilla destino está vacía
                    lista.add(destino); // el movimiento es válido
                    coordenadaDestino[0] = coordenadaDestino[0] + coordenadaOffset[0]; // incrementamos con el offset
                    coordenadaDestino[1] = coordenadaDestino[1] + coordenadaOffset[1];
                } else { // si está ocupada
                    piezaBloquea = true; // bloquea el paso
                    if (this.getColor() != destino.getPieza().getColor()) { // si la pieza que bloquea el paso es del oponente
                        lista.add(destino); // el movimiento es válido (Ataque)
                    }
                }
            }
        }
        return lista;
    }

}
