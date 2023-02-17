package com.caldatam.obrestdatajpa.controller;

import com.caldatam.obrestdatajpa.entities.Book;
import com.caldatam.obrestdatajpa.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //CRUD sobre la entidad Book


    //Buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * @return List<Book>
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Buscar un libro por su id en la base de datos

    //public Book findOneById(Long id){
    //    return bookRepository.
    //}


    //Crear un nuevo libro en la base de datos


    //Actualizar un libro en la base de datos


    //Borrar un libro de la base de datos

}
