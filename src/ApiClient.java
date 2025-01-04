import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private static final String API_KEY;

    static {
        try {
            API_KEY = Config.getApiKey();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la clave API desde config.properties", e);
        }
    }

    public ExchangeRatesResponse getExchangeRates() throws IOException, InterruptedException {
        // Creación del cliente HTTP y solicitud GET
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", "Bearer " + API_KEY)  // Autenticación API si es necesario
                .GET()
                .build();

        // Realización de la solicitud y manejo de la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Deserialización de la respuesta JSON usando Gson
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ExchangeRatesResponse.class);
        } else {
            throw new IOException("Error en la solicitud: Código de estado " + response.statusCode());
        }
    }
}
