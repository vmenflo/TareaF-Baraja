/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parteb;

import partea.Naipe;

/**
 *
 * @author Víctor
 */
public class PruebaBaraja {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        
        baraja.toString();
        
        //Llamamos al metodo para barajar en los movimientos que digamos
        baraja.barajar(4);
        
        System.out.println("Una vez barajada queda así---------------------");
        
        baraja.toString();
        
        //Probamos el metodo sacar cartas
        //Creamos una array para almacenar la array que devuelva de naipes
        Naipe[] cartas = new Naipe [10];
        cartas = baraja.sacarCarta(10);
        
        System.out.println("Mostramos nuesta mano---------------------------");
        
        //Mostramos la mano
        for (Naipe carta : cartas) {
            System.out.println(carta);
        }
        
        //Y la baraja para comprobar que se queda la posicion en null
        System.out.println("Y la baraja queda así--------------------------");
        
        baraja.toString();
    }
}
