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
    public static final int TAMANIO_BARAJA = 40;

    //Constructor 
    public Baraja() {

        Naipe[] cartas = new Naipe[TAMANIO_BARAJA];
        //Palo[] palos = Palo.values();
        Naipe aleatorio;
        for (int i = 0; i < TAMANIO_BARAJA; i++) {
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
        for(int i=0; i<baraja.length;i++){
            System.out.println(baraja[i]);
        }
        sb.append(", CUARENTA=").append(TAMANIO_BARAJA);
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
            int aleatorio1 = r.nextInt(1, baraja.length);
            int aleatorio2 = 0;
            do { //Bucle para asegurarnos de que no salga el mismo número
                aleatorio2 = r.nextInt(1,baraja.length);
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
        //Controlo cuantas cartas sacar
        if (numCartas <1 ||numCartas > baraja.length) {
            Naipe[] cartas = new Naipe[0];
            return cartas;
        } 
        // Ya no me va a servir 
        // Creo un aleatorio para seleccionar la posicion aleatoria
        int aleatorio = 0;
        Random r = new Random();
        Naipe[] cartas = new Naipe[numCartas];
        
        // Bucle para darle valor al aleatorio de forma random y guardarla en 
        // la nueva array de cartas
        for (int i = 0; i < numCartas; i++) {
           do { //Controlo que no meta un null
                aleatorio = r.nextInt(1, 40);
           } while (baraja[aleatorio] == null);

            cartas[i] = baraja[aleatorio];
            baraja[aleatorio]=null;

        }
        
        // Creamos una baraja auxiliar con el nuevo tamaño
        int tamaño=TAMANIO_BARAJA-numCartas;
        //Creamos un naipe auxiliar
        Naipe[] nuevaBaraja = new Naipe [tamaño];
        int contador=0;
        //For-each para meter nos naipes en la baraja
         for (Naipe naipe : baraja) {
            if (naipe != null) {
                nuevaBaraja[contador++] = naipe;
            }
        }
       //Lo igualo
       baraja=nuevaBaraja;

        return cartas;
    }


   
}
