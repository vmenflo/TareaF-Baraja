/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parteb;

import java.util.Arrays;
import java.util.Random;
import partea.Naipe;
import partea.Palo;

/**
 *
 * @author Víctor
 */
public class Baraja {

    //Atributos 
    private Naipe[] baraja;
    public static final int NAIPEXBARAJA = 40;

    //Constructor 
    public Baraja() {

        Naipe[] cartas = new Naipe[NAIPEXBARAJA];
        //Palo[] palos = Palo.values();
        Naipe aleatorio;
        for (int i = 0; i < NAIPEXBARAJA; i++) {
            do {
                aleatorio = new Naipe();

            } while (cartaRepetida(aleatorio, cartas, i));

            cartas[i] = aleatorio;

        }

        this.baraja = cartas;
    }

    //Metodo para controlar que no se repita
    private boolean cartaRepetida(Naipe nuevaCarta, Naipe[] cartas, int numCartas) {
        for (int i = 0; i < numCartas; i++) {
            if (nuevaCarta.equals(cartas[i])) {
                return true;
            }
        }
        return false;
    }

    // Getter
    public Naipe[] getBaraja() {
        return baraja;
    }


    // To String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Baraja{");
        sb.append("baraja=").append(baraja);
        sb.append(", CUARENTA=").append(NAIPEXBARAJA);
        sb.append('}');
        return sb.toString();
    }

    //METODO PARA BARAJAR
    public void barajar(int movimientos) {

        //Bucle para repetir el movimiento tantas veces como se indique
        for (int i = 0; i < movimientos; i++) {
            //Creamos una variable axuliar para almacenar momentaneamente un naipe
            Naipe auxiliar = null;
            //Creamos el obbjeto ramdon para los números aleatorios
            Random r = new Random();
            int aleatorio1 = r.nextInt(1, 41);
            int aleatorio2 = 0;
            do { //Bucle para asegurarnos de que no salga el mismo número
                aleatorio2 = r.nextInt(1, 41);
            } while (aleatorio1 == aleatorio2);

            System.out.println("En la baraja, el naipe que ocupa la posicion "
                    + aleatorio1 + " " + baraja[aleatorio1]
                    + " pasa a la posicion " + aleatorio2 + " " + baraja[aleatorio2]);

            //guardamos el aleatorio1 en aux para dejar hueco
            auxiliar = baraja[aleatorio1];
            //En el hueco del aleatorio1 metemos aleatorio2
            baraja[aleatorio1] = baraja[aleatorio2];
            //Y por ultimo el aleatorio2 en el 1
            baraja[aleatorio2] = auxiliar;

        }

    }

    //METODO PARA SACAR CARTAS 
    public Naipe[] sacarCarta(int numCartas) {
        
        if (numCartas <1 ||numCartas > 40) {
            Naipe[] cartas = new Naipe[0];
            return cartas;
        }
        
        int aleatorio = 0;
        Random r = new Random();
        Naipe[] cartas = new Naipe[numCartas];
        
        for (int i = 0; i < numCartas; i++) {
            do {
                aleatorio = r.nextInt(1, NAIPEXBARAJA);
            } while (baraja[aleatorio] == null);

            cartas[i] = baraja[aleatorio];
            baraja[aleatorio] = null;

        }
        
        baraja= new Naipe[NAIPEXBARAJA - numCartas];
        for(int i=0; i<baraja.length; i++){
            
            baraja[i]= 
            
        }

        return cartas;
    }

   
}
