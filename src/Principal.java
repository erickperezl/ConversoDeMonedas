import Models.Currency;
import Models.Exchange;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Instancia del convertidor
        Exchange exchange = new Exchange();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Desplegar menú
            mostrarMenu();

            // Selección del usuario
            System.out.print("Seleccione una opción para la conversión de divisas: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor de divisas.\nAplicación terminada.");
                break;
            }

            System.out.print("Ingrese la cantidad que desea convertir: ");
            double cantidad = scanner.nextDouble();

            realizarConversion(exchange, opcion, cantidad);
        }
    }

    private static void mostrarMenu() {
        System.out.println("--------------------------------------");
        System.out.println("  Bienvenido al Conversor de Monedas ");
        System.out.println("        Desarrollado por Erick Pérez ");
        System.out.println("--------------------------------------");
        System.out.println("\n" +
                "___________      .__        __     __________                        \n" +
                "\\_   _____/______|__| ____ |  | __ \\______   \\_______   ____ ________\n" +
                " |    __)_\\_  __ \\  |/ ___\\|  |/ /  |     ___/\\_  __ \\_/ __ \\\\___   /\n" +
                " |        \\|  | \\/  \\  \\___|    <   |    |     |  | \\/\\  ___/ /    / \n" +
                "/_______  /|__|  |__|\\___  >__|_ \\  |____|     |__|    \\___  >_____ \\\n" +
                "        \\/               \\/     \\/                         \\/      \\/\n");
        System.out.println("1) Dólar (USD) a Peso Mexicano (MXN)");
        System.out.println("2) Peso Mexicano (MXN) a Dólar (USD)");
        System.out.println("3) Dólar (USD) a Euro (EUR)");
        System.out.println("4) Euro (EUR) a Dólar (USD)");
        System.out.println("5) Dólar (USD) a Dólar Canadiense (CAD)");
        System.out.println("6) Dólar Canadiense (CAD) a Dólar (USD)");
        System.out.println("7) Salir");
    }

    private static void realizarConversion(Exchange exchange, int opcion, double cantidad) {
        String[] paresDivisas = {"USD/MXN/", "MXN/USD/", "USD/EUR/", "EUR/USD/", "USD/CAD/", "CAD/USD/"};

        if (opcion < 1 || opcion > 6) {
            System.out.println("Opción no válida, por favor intente nuevamente.");
            return;
        }

        Currency moneda = exchange.locateCurrency(paresDivisas[opcion - 1], cantidad);
        String[] etiquetas = {"de USD a MXN", "de MXN a USD", "de USD a EUR", "de EUR a USD", "de USD a CAD", "de CAD a USD"};
        System.out.printf("La cantidad de %.2f %s se convierte en %.2f%n", cantidad, etiquetas[opcion - 1], moneda.conversion_result());
    }
}

