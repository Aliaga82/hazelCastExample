package com.example.hazelcastExample;

import com.example.hazelcastExample.repository.BookRepository;
import com.example.hazelcastExample.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Slf4j
@AllArgsConstructor
public class HazelcastExampleApplication implements CommandLineRunner {
    private final BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(HazelcastExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true){
			log.trace("Yuklenme databeysden");
			//bookService.getBookNamebyIsbn("aa");
			Thread.sleep(100);
		}
	}
}
