package com.tej.librarymanagement.model;

import com.tej.librarymanagement.exception.InvalidBookException;

public class OriginalBook extends Book implements Borrow{

    public OriginalBook(int id, String title, String writer, double price) throws InvalidBookException {
        super(id ,title, writer, price);
    }

    @Override
    public void borrowBook() {
        System.out.println("Take Book From Library");
    }

    @Override
    public void returnBook() {
       System.out.println("Return Book");
    }
    
    
}
