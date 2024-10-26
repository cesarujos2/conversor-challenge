package features;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangeRateClient {

    private static final Gson gson = new Gson();
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private String urlApi;

    public ExchangeRateClient() {
    }

    public Double getExchangeRate(String codeMoney, String codeMoneyConvert) throws IOException, InterruptedException {
        urlApi = "https://v6.exchangerate-api.com/v6/49febd299e846b7aeef0bbbd/latest/" + codeMoney;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlApi))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ExchangeRateResponse data = gson.fromJson(response.body(), ExchangeRateResponse.class);

            Map<String, Double> moneyConverted = data.getConversionRates();
            Double exchangeRate = moneyConverted.get(codeMoneyConvert);

            return exchangeRate;

        } catch (Exception error) {
            throw new RuntimeException("Error fetching exchange rates: " + error.getMessage());
        }
    }
}
