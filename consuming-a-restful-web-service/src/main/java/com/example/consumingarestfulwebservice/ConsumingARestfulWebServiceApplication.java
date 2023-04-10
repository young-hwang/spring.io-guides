package com.example.consumingarestfulwebservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@JsonIgnoreProperties(ignoreUnknown = true)
record Quote(String type, Value value) {

}

record Value(Long id, String quote) {

}

@SpringBootApplication
public class ConsumingARestfulWebServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingARestfulWebServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingARestfulWebServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public ApplicationRunner applicationRunner(RestTemplate restTemplate) {
		return args -> {
			Quote quote = restTemplate.getForObject("http://localhost:48080/api/random", Quote.class);
			log.info("quote : {}", quote);
		};
	}
}
