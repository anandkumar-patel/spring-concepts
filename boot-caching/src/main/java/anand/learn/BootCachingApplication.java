package anand.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BootCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCachingApplication.class, args);
	}

}
