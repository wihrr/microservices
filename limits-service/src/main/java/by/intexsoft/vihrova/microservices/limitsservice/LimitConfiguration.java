package by.intexsoft.vihrova.microservices.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LimitConfiguration {
    private int max;
    private int min;
}
