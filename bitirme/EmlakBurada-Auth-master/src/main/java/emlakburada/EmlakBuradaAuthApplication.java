package emlakburada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmlakBuradaAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakBuradaAuthApplication.class, args);
	}

}
