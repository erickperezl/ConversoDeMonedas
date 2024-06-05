package Models;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exchange {

    public Currency locateCurrency(String CurrencyOption, double CurrencyAmount) {
        // Construcción de la URI para la solicitud
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f917710ac4b1dd53eb99c57b/pair/" + CurrencyOption + CurrencyAmount);

        // Creación del cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // Creación de la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Envío de la solicitud y recepción de la respuesta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Conversión de la respuesta JSON a un objeto Currency
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            // Manejo de errores en caso de fallo en la conversión
            throw new RuntimeException("No se pudo realizar la conversión de moneda: " + e.getMessage());
        }
    }
}


