import features.ExchangeRateClient;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ExchangeRateClient exchangeRateClient = new ExchangeRateClient();
        Scanner scanner = new Scanner(System.in);
        int option;
        double valor;

        do {
            System.out.println("Sea bienvenido/a a Conversor de Moneda");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) salir");
            System.out.print("Elija una opción válida: ");

            option = getValidOption(scanner);

            if (option == 7) {
                System.out.println("Saliendo del programa...");
                break;
            }

            valor = getValidAmount(scanner);

            double exchangeRate = getExchangeRate(exchangeRateClient, option);
            System.out.println();
            System.out.println("La moneda convertida es: " + (valor * exchangeRate));
            System.out.println();
            System.out.println("CONVERSIÓN REALIZADA CON ÉXITO!!!");

            waitBeforeNextIteration();

        } while (true);

        scanner.close();
    }

    private static int getValidOption(Scanner scanner) {
        while (true) {
            try {
                int option = scanner.nextInt();
                if (option < 1 || option > 7) {
                    throw new IllegalArgumentException("Opción no válida, por favor intente nuevamente.");
                }
                System.out.println("La opción escogida es: " + option);
                return option;
            } catch (Exception e) {
                System.out.print("Ingrese un valor correcto (1-7): ");
                scanner.nextLine();
            }
        }
    }

    private static double getValidAmount(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingrese el valor que desea convertir: ");
                Double valor = scanner.nextDouble();
                System.out.println("El valor a convertir es: " + valor);
                return valor;
            } catch (Exception e) {
                System.out.println("Ingrese un valor correcto: ");
                scanner.nextLine();
            }
        }
    }

    private static double getExchangeRate(ExchangeRateClient exchangeRateClient, int option) {
        String fromCurrency = null;
        String toCurrency = null;

        switch (option) {
            case 1:
                fromCurrency = "USD";
                toCurrency = "ARG";
                break;
            case 2:
                fromCurrency = "ARG";
                toCurrency = "USD";
                break;
            case 3:
                fromCurrency = "USD";
                toCurrency = "BRL";
                break;
            case 4:
                fromCurrency = "BRL";
                toCurrency = "USD";
                break;
            case 5:
                fromCurrency = "USD";
                toCurrency = "COP";
                break;
            case 6:
                fromCurrency = "COP";
                toCurrency = "USD";
                break;
        }

        try {
            System.out.println("CONVIERTIENDO " + fromCurrency + " A " + toCurrency + "... ");
            return exchangeRateClient.getExchangeRate(fromCurrency, toCurrency);
        } catch (IOException | InterruptedException e) {
            System.out.println("ERROR AL OBTENER INFORMACIÓN: " + e.getMessage());
            return 0.0;
        }
    }

    private static void waitBeforeNextIteration() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido.");
        }
    }
}
