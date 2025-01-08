import java.util.Map;

public record Moneda(
        String result,
        String documentation,
        String terms_of_use,
        long time_last_update_unix,
        String time_last_update_utc,
        long time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        Map<String, Double> conversion_rates
) {
    /**
     * Método para obtener la tasa de conversión hacia una moneda específica.
     *
     * @param targetCode Código de la moneda objetivo (por ejemplo, "USD", "MXN").
     * @return Tasa de conversión hacia la moneda objetivo.
     * @throws IllegalArgumentException si el código de moneda objetivo no está en el mapa.
     */
    public double getConversionRate(String targetCode) {
        if (conversion_rates.containsKey(targetCode)) {
            return conversion_rates.get(targetCode);
        } else {
            throw new IllegalArgumentException("Tasa de conversión no encontrada para la moneda: " + targetCode);
        }
    }
}
