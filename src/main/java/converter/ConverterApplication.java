package converter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@MapperScan("converter")
public class ConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConverterApplication.class, args);
	}
}
