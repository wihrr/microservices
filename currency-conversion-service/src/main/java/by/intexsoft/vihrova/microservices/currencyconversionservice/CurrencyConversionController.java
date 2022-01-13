package by.intexsoft.vihrova.microservices.currencyconversionservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertBean convertCurrency(@PathVariable String from,
                                               @PathVariable String to,
                                               @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConvertBean> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConvertBean.class,
                        uriVariables);

        CurrencyConvertBean response = responseEntity.getBody();

        return new CurrencyConvertBean(response.getId(), from, to, response.getConversionMultiple(),
                quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertBean convertCurrencyFeign(@PathVariable String from,
                                               @PathVariable String to,
                                               @PathVariable BigDecimal quantity) {

        CurrencyConvertBean response = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConvertBean(response.getId(), from, to, response.getConversionMultiple(),
                quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
