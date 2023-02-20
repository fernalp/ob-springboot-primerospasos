package com.caldatam.obrestdatajpa.service;

import com.caldatam.obrestdatajpa.entities.Book;

public class BookPriceCalculator {
    //public static final double ENVIO = 2.99;

    public double calculatePrice (Book book){
        double price = book.getPrice();

        if (book.getPages() > 60){
            price += 5;
        }

    //    price += ENVIO;

        price += 2.99;

        return price;
    }

}
