package com.caldatam.obrestdatajpa.controller;

import com.caldatam.obrestdatajpa.entities.Book;
import com.caldatam.obrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //CRUD sobre la entidad Book


    //Buscar todos los libros

    /**
     *
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
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if (book.getId() != null){
            log.warn("Trying to create a book with id");
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }

        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    //Actualizar un libro en la base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId()==null){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    //Borrar un libro de la base de datos

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar todos los libros
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        if (bookRepository.count() > 0){
            bookRepository.deleteAll();
            log.info("REST request for delete all books");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
