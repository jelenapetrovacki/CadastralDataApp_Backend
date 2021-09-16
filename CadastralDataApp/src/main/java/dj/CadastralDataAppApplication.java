package dj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dj.controller"})
@ComponentScan({"dj.EmailSenderService.java"})
public class CadastralDataAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastralDataAppApplication.class, args);
	}

}
