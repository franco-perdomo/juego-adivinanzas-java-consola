package juegoadivinanzas;
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinanzas {
    public static void main(String[] args) {
        System.out.println("*** Juego de Adivinanzas ***");
        var consola = new Scanner(System.in);
        var random = new Random();

        // Generamos un numero aleatorio entre 1 y 50
        var numeroSecreto = random.nextInt(50) + 1;
        var intentos = 0;
        var adivinanza = 0;

        while (adivinanza != numeroSecreto) {
            System.out.print("Adivina el numero secreto (1 - 50): ");
            adivinanza = consola.nextInt();

            if (adivinanza < numeroSecreto) {
                System.out.println("El numero secreto es mayor");
            } else if (adivinanza > numeroSecreto) {
                System.out.println("El numero secreto es menor");
            }

            intentos++;
        }

        System.out.printf("Felicidades, adivinaste el numero secreto en %d intentos%n", intentos);
    }
}

