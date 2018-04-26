package jinbid.converter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("jinbid.converter")
public class BidSysconverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidSysconverterApplication.class, args);
	}
}
