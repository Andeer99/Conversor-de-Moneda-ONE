import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ConsultaTasaDeCambio {
    private static final String API_KEY = "0c0632a59b19df603d1b7535";

    public double realizarConversion(String monedaInicial, String monedaFinal, double cantidad) {
        // Construir la URL con el formato correcto incluyendo una cantidad
        URI urlExchangerate = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaInicial + "/" + monedaFinal + "/" + cantidad);

        // Crear cliente HTTP y solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(urlExchangerate).build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear la respuesta JSON
            RespuestaConversion respuesta = new Gson().fromJson(response.body(), RespuestaConversion.class);

            // Retornar el resultado de la conversión
            return respuesta.conversion_result;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo realizar la conversión. Verifica tu conexión o los datos ingresados.", e);
        }
    }

    // Clase auxiliar para mapear la respuesta de la API
    private static class RespuestaConversion {
        double conversion_result; // Este atributo debe coincidir con el nombre del campo en el JSON de la API
    }
}
