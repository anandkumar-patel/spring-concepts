package anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"anand", "appointment"})
public class SpringDataJpaApplication {
	public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
	}
}
