package com.caldatam.obrestdatajpa.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Schema(name = "Libro", description = "Entidad libro que representar un libro")
public class Book {

    //1. Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Clave primaria autogenerada por la base de datos")
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Integer pages;
    @Schema(description = "Precio en doláres con 2 cifras decimales")
    private Double precio;
    private LocalDate releaseDate;
    private Boolean online;

    //2. Constructores
    public Book() {
    }

    public Book(Long id, String isbn, String title, String author, Integer pages, Double precio, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.precio = precio;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    //3. Getter y Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    //4. toString


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", precio=" + precio +
                ", releaseDate=" + releaseDate +
                ", online=" + online +
                '}';
    }
}
