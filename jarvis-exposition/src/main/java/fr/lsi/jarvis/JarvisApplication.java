package fr.lsi.jarvis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@ComponentScan("fr.lsi.jarvis")
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EntityScan("fr.lsi.jarvis")
public class OpenmoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenmoneyApplication.class, args);
	}

}
