package test.rest.tr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TrApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrApplication.class, args);
	}

}
