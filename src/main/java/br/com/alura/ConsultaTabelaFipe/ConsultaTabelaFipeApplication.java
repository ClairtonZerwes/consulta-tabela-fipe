package br.com.alura.ConsultaTabelaFipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.ConsultaTabelaFipe.principal.Principal;

@SpringBootApplication
public class ConsultaTabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaTabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal menuPrincipal = new Principal();
		menuPrincipal.exiberMenu();
	}
}
