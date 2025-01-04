import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_FILE = "config.properties";

    // Obtención de la clave API desde el archivo properties
    public static String getApiKey() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE)) {
            properties.load(input);
            String apiKey = properties.getProperty("API_KEY");

            // Validación de que la clave API existe
            if (apiKey == null || apiKey.trim().isEmpty()) {
                throw new IOException("La clave API no se encuentra en el archivo config.properties");
            }
            return apiKey;
        }
    }
}
