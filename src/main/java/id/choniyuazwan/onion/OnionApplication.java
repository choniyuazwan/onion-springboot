package id.choniyuazwan.onion;

import id.choniyuazwan.onion.infrastructure.springboot.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import(UserConfig.class)
@SpringBootApplication
@EnableJpaRepositories
public class OnionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnionApplication.class, args);
	}

}
