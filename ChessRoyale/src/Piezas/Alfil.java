/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

import Juego.Casilla;
import Juego.Movimiento;
import Juego.MovimientoAtaque;
import Juego.MovimientoSimple;
import Juego.Tablero;
import static Piezas.Pieza.coordenadaValida;
import java.util.ArrayList;

/**
 * Clase Alfil
 *
 * @author infor04
 */
public class Alfil extends Pieza {

    private final static int[][] COORDENADAS_OFFSET 
            = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    private final Tipo tipo;

    public Alfil(Color color) {
        super(color);
        this.tipo = Tipo.ALFIL;
    }

    @Override
    public Tipo getTipo() {
        return this.tipo;
    }

    @Override
    public ArrayList<Movimiento> movimientosValidos(Tablero tablero, Casilla origen) {
        ArrayList<Movimiento> lista = new ArrayList<>();
        int[] coordenadaDestino = {0, 0};
        for (int[] coordenadaOffset : COORDENADAS_OFFSET) {
            coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0];
            coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
            boolean piezaBloquea = false;
            while (coordenadaValida(coordenadaDestino) && !piezaBloquea) {
                Casilla destino = tablero.getCasilla(coordenadaDestino[0], coordenadaDestino[1]);
                if (!destino.isOcupada()) {
                    lista.add(new MovimientoSimple(tablero, origen, destino));
                } else {
                    if (this.getColor() != destino.getPieza().getColor()) {
                        lista.add(new MovimientoAtaque(tablero, origen, destino));
                    }
                    piezaBloquea = true;
                }
                if (!piezaBloquea) {
                    coordenadaDestino[0] = origen.getFila() + coordenadaOffset[0];
                    coordenadaDestino[1] = origen.getColumna() + coordenadaOffset[1];
                }
            }
        }
        return lista;
    }

}
