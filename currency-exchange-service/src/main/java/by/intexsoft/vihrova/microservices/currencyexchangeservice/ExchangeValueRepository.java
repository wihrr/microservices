package by.intexsoft.vihrova.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
        ExchangeValue findExchangeValueByFromAndTo (String from, String to);
}
