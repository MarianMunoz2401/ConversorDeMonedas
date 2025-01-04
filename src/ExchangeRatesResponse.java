import java.util.Map;

public class ExchangeRatesResponse {
    private String base;
    private String date;
    private Map<String, Double> rates;

    // Getters
    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    // Método para obtener la tasa de cambio de una moneda en específico
    public Double getRateForCurrency(String currencyCode) {
        return rates.get(currencyCode);
    }
}
