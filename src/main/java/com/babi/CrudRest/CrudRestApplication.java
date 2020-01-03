package com.babi.CrudRest;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.babi.CrudRest.model.Contato;
import com.babi.CrudRest.repository.ContatoRepository;

@SpringBootApplication
public class CrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContatoRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11).mapToObj(i -> {
				Contato c = new Contato();
				c.setName("Contato " + i);
				c.setEmail("contato" + i + "@email.com");
				c.setPhone("(111) 111-1111");
				return c;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};
	}
}
