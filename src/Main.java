import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el cliente API
        ApiClient apiClient = new ApiClient();

        // Crear el scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        try {
            // Obtener las tasas de cambio
            ExchangeRatesResponse exchangeRates = apiClient.getExchangeRates();
            Map<String, Double> rates = exchangeRates.getRates();

            // Mostrar las monedas disponibles
            System.out.println("Monedas disponibles: USD, EUR, COP");
            System.out.print("Introduce la moneda de origen (ejemplo: USD): ");
            String fromCurrency = scanner.nextLine().toUpperCase();  // Leer la moneda de origen

            System.out.print("Introduce la moneda de destino (ejemplo: EUR): ");
            String toCurrency = scanner.nextLine().toUpperCase();  // Leer la moneda de destino

            System.out.print("Introduce el monto a convertir: ");
            double amount = scanner.nextDouble();  // Leer el monto a convertir

            // Verificar si las monedas ingresadas son válidas
            if (rates.containsKey(fromCurrency) && rates.containsKey(toCurrency)) {
                // Realizar la conversión
                double fromRate = rates.get(fromCurrency);
                double toRate = rates.get(toCurrency);

                // Convertir el monto
                double convertedAmount = (amount / fromRate) * toRate;

                // Mostrar el resultado de la conversión
                System.out.printf("El monto %.2f %s equivale a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            } else {
                System.out.println("Monedas inválidas. Asegúrate de que las monedas estén entre USD, EUR y COP.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        } finally {
            scanner.close();  // Cerramos el scanner después de usarlo
        }
    }
}

