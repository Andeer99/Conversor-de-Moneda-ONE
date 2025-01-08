import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaTasaDeCambio {
    public Moneda tipoDeMoneda(String monedaInicial, String monedaFinal) {
        String apiKey = "0c0632a59b19df603d1b7535";
        URI urlExchangerate = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaInicial);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(urlExchangerate).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);
            if (moneda != null) {
                return moneda; // Devuelve el objeto Moneda
            } else {
                throw new RuntimeException("No se pudo obtener la tasa de cambio");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la tasa de cambio: " + e.getMessage(), e);
        }
    }
}
