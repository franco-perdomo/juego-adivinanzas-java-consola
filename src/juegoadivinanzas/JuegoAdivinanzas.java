package juegoadivinanzas;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanzas {

    private static final int MINIMO = 1;
    private static final int MAXIMO = 50;
    private static final int INTENTOS_MAXIMOS = 5;

    public static void main(String[] args) {
        System.out.println("*** Juego de Adivinanzas ***");

        // Cierra el Scanner automáticamente.
        try (var consola = new Scanner(System.in)) {

            int numeroSecreto = new Random().nextInt(MAXIMO - MINIMO + 1) + MINIMO;
            int intentos = 0;
            int adivinanza = 0;

            while (adivinanza != numeroSecreto && intentos < INTENTOS_MAXIMOS) {
                adivinanza = leerNumero(consola);

                // "continue" evita que un número fuera de rango gaste un intento.
                if (adivinanza < MINIMO || adivinanza > MAXIMO) {
                    System.out.printf("Ingresa un numero entre %d y %d%n", MINIMO, MAXIMO);
                    continue;
                }

                intentos++;
                mostrarPista(adivinanza, numeroSecreto);
            }

            mostrarResultado(adivinanza == numeroSecreto, intentos, numeroSecreto);
        }
    }

    // Repite la lectura hasta recibir un entero válido, en vez de cerrar con error.
    private static int leerNumero(Scanner consola) {
        System.out.printf("Adivina el numero secreto (%d - %d): ", MINIMO, MAXIMO);
        while (true) {
            try {
                return Integer.parseInt(consola.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada invalida, ingresa un numero entero: ");
            }
        }
    }

    private static void mostrarPista(int adivinanza, int numeroSecreto) {
        if (adivinanza < numeroSecreto) {
            System.out.println("El numero secreto es mayor");
        } else if (adivinanza > numeroSecreto) {
            System.out.println("El numero secreto es menor");
        }
    }

    private static void mostrarResultado(boolean acerto, int intentos, int numeroSecreto) {
        if (acerto) {
            System.out.printf("Felicidades, adivinaste el numero secreto en %d intentos%n", intentos);
        } else {
            System.out.printf("Lo siento, has agotado tus intentos maximos: %d%n", INTENTOS_MAXIMOS);
            System.out.printf("El numero secreto era: %d%n", numeroSecreto);
        }
    }
}

