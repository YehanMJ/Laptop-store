package lk.acpt.demo_api;

import lk.acpt.demo_api.service.StorageService;
import lk.acpt.demo_api.supporter.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DemoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService ) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
