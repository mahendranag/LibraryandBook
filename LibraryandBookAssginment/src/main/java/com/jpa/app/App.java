package com.jpa.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App extends SpringBootServletInitializer {
	public static void main(String[] args) {
		System.out.println("from App::");
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner mappingExample(BookRepository bookRepository, LibraryRepository libraryRepository) {
		return args -> {
			Book book = new Book("Java 101");
			bookRepository.save(book);
			libraryRepository.save(new Library("Introduction Libarary", book));
			libraryRepository.save(new Library("Java 8 contents Library", book));
			libraryRepository.save(new Library("Concurrency Library", book));
		};
	}

}
