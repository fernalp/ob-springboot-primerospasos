package com.caldatam.obrestdatajpa.service;

import com.caldatam.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {

        // Configuración de la Prueba
        Book book = new Book(1L,"asd","El pañal","Fernando Almanza", 100, 99.99, LocalDate.now(),true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // Comprobación de aserciones(test)
        assertTrue(price > 0);
        assertEquals(107.97999999999999, price);


    }
}