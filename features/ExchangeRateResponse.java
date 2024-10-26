package features;

import java.util.Map;

public class ExchangeRateResponse {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates; // Change this line

    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        return "ExchangeRateResponse{" +
                "result='" + result + '\'' +
                ", base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
