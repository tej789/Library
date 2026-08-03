package com.tej.librarymanagement.model;

import com.tej.librarymanagement.exception.InvalidBookException;

public class PdfBook extends Book implements Borrow{

    public PdfBook(int id, String title, String writer, double price) throws InvalidBookException {
        super(id, title, writer, price);
    }

    @Override
    public void borrowBook() {

       System.out.println("Download Book pdf");
    }

    @Override
    public void returnBook() {
       System.out.println("Return Book");
    }

    
    
}
