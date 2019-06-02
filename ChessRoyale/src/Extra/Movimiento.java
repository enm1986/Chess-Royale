/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import Juego.Casilla;
import Juego.Tablero;
import java.util.ArrayList;


/**
 *
 * @author navar
 */
public abstract class Movimiento {

    private final Tablero tablero;
    private final Casilla casillaOrigen;
    private final Casilla casillaDestino;
    

    public Movimiento(Tablero tablero, Casilla casillaOrigen, Casilla casillaDestino) {
        this.tablero = tablero;
        this.casillaOrigen = casillaOrigen;
        this.casillaDestino = casillaDestino;
    }
    
}
