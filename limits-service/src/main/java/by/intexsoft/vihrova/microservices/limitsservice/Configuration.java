package by.intexsoft.vihrova.microservices.limitsservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("limits-service")
@Component
public class Configuration {
    private int min;
    private int max;
}
