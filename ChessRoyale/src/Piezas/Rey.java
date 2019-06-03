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
 * Clase Rey
 *
 * @author Eugenio Navarro
 * @author Carlos Canovas
 */
public class Rey extends Pieza {

    /**
     * Offset de coordenadas (fila, columna) que indican las POSICIONES donde
     * puede moverse el Rey<br>
     * <br>
     * Posiciones: {1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}
     */
    private final static int[][] COORDENADAS_OFFSET
            = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};

    /**
     * Contador de movimientos del Rey.<br>
     * Como no se ha implementado el empate ni el Jaque, hemos añadido una regla
     * que si el rey se mueve más de un nº fijo de veces se acaba la partida
     */
    private int contadorMovimientos;

    public Rey(Color color) {
        super(Tipo.REY, color);
        this.contadorMovimientos = 0;
    }

    /**
     * Devuelve la cantidad de movimientos realizados por la pieza
     *
     * @return int
     */
    public int getContadorMovimientos() {
        return contadorMovimientos;
    }

    /**
     * Incrementa la cantidad de movimientos realizados por la pieza
     */
    public void setContadorMovimientos() {
        this.contadorMovimientos++;
    }

    @Override
    public ArrayList<Casilla> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Casilla> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            // por cada offset se comprueban los movimientos válidos
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0]; //añadimos el offset a la posición de la pieza
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            if (coordenadaValida(coordenadaDestino)) { // si la coordenada destino es válida
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) { // si la casilla desino está vacía
                    lista.add(destino); // movimiento válido
                } else {
                    if (this.getColor() != destino.getPieza().getColor()) { // si está ocupada por el oponente
                        lista.add(destino); // movimiento válido (Ataque)
                    }
                }
            }
        }
        return lista;
    }
}
