/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 *
 * @author infor04
 */
public abstract class Pieza {
    
    public static final char BLANCA = 'B';
    public static final char NEGRA = 'N';
    
    private char color;
    private char tipo;

    public Pieza(char color, char tipo) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    abstract public boolean movimientoValido(int f_origen, int c_origen, int f_destino, int c_destino);
    
}
