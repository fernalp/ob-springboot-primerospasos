package com.caldatam.obrestdatajpa.controller;

import com.caldatam.obrestdatajpa.entities.Book;
import com.caldatam.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        //Opcion 1
        if (optionalBook.isPresent())
            return ResponseEntity.ok(optionalBook.get());
        else
            return ResponseEntity.notFound().build();

        //Opcion 2
        //return optionalBook.orElse(null);
        //return optionalBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    //Crear un nuevo libro en la base de datos
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return bookRepository.save(book);
    }

    //Actualizar un libro en la base de datos


    //Borrar un libro de la base de datos

}
