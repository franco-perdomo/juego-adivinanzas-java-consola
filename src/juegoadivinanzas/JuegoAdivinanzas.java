package juegoadivinanzas;
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanzas {

    private static final int MINIMO = 1;
    private static final int MAXIMO = 50;
    private static final int INTENTOS_MAXIMOS = 5;

    public static void main(String[] args) {
        System.out.println("*** Juego de Adivinanzas ***");
        var consola = new Scanner(System.in);
        var random = new Random();

        // Generamos un número aleatorio entre 1 y 50
        var numeroSecreto = random.nextInt(MAXIMO - MINIMO + 1) + MINIMO;
        var intentos = 0;
        var adivinanza = 0;

        while (adivinanza != numeroSecreto && intentos < INTENTOS_MAXIMOS) {
            adivinanza = leerNumero(consola);
            // Si está fuera de rango, avisamos y no cuenta como intento
            if (adivinanza < MINIMO || adivinanza > MAXIMO) {
                System.out.printf("Ingresa un numero entre %d y %d%n", MINIMO, MAXIMO);
                continue;
            }
            // Agregar una ayuda para orientar al jugador
            if (adivinanza < numeroSecreto) {
                System.out.println("El numero secreto es mayor");
            } else if (adivinanza > numeroSecreto) {
                System.out.println("El numero secreto es menor");
            }

            // Incrementamos la variable de intentos
            intentos++;
        }

        // Conclusion del juego
        if (adivinanza == numeroSecreto) {
            System.out.printf("Felicidades, adivinaste el numero secreto en %d intentos%n", intentos);
        } else {
            System.out.printf("Lo siento, has agotado tus intentos maximos: %d%n", INTENTOS_MAXIMOS);
            System.out.printf("El numero secreto era: %d%n", numeroSecreto);
        }
    }

    // Validación de entrada para evitar errores de texto
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
}

