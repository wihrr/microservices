package by.intexsoft.vihrova.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
@RibbonClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {

//    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
@GetMapping(value = "/currency-exchange-service/currency-exchange/from/{from}/to/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyConvertBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
