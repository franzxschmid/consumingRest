//TODO build the same for "http://jsonplaceholder.typicode.com/posts/1"

package de.franz.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
                
	}

        //RestTemplate to fetch the Data from our Spring-Boot-Quotation-Service
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

        //Convert the incoming JSON-Data into a Quote-Object
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return (String[] args) -> {
                    Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
                    //Contents of the Quote-Object get logged to Console
                    log.info(quote.toString());
                };
                
	}
}
