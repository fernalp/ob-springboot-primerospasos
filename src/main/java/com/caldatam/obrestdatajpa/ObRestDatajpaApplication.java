package com.caldatam.obrestdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);

		//1. Crear Libro

		Book book = new Book(null, "CA-1789", "Epale Epale", "Fernando Almanza", 98, 75.98, LocalDate.of(2020,12,27),true);
		Book book2 = new Book(null, "CA-1669", "Epale Pilinchi", "Fernando Almanza", 76, 54.98, LocalDate.of(2015,12,27),false);

		//2. Almacenar Libro

		System.out.println("El número de libros es:" + bookRepository.count());

		bookRepository.save(book);
		bookRepository.save(book2);

		//3. Recuperar todos los libros
		System.out.println("El número de libros es:" +  bookRepository.findAll().size());
		bookRepository.findAll();

		//4. Borrar un libro

		bookRepository.deleteById(1L);

		System.out.println("El número de libros es:" + bookRepository.findAll().size());
	}

}
