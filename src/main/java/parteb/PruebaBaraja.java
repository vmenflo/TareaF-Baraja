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
        
        for(int i = 0; i<40;i++){
            System.out.println(baraja.getBaraja()[i]);
        }
        
        //Llamamos al metodo para barajar en los movimientos que digamos
        baraja.barajar(4);
        
        System.out.println("Una vez barajada queda así---------------------");
        
        for(int i = 0; i<40;i++){
            System.out.println(baraja.getBaraja()[i]);
        }
        
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
        
        for(int i = 0; i<30;i++){
            System.out.println(baraja.getBaraja()[i]);
        }
    }
}
