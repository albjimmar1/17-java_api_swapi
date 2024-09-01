package com.example.swapi.configurations;

import com.example.swapi.services.SwapiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SwapiConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }

    /*@Bean
    public SwapiService swapiService() {
        return new SwapiService();
    }*/

}
